package com.taxseer_demo.Cart;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CartService {

    private final FilingRepository filingRepository;
    private final FilingRecipientRepository recipientRepository;
    private final CartRepository cartRepository;

    @Transactional
    public Mono<Cart> processFilingToCart(Map<String, Object> payload) {
        // 1. Map and save the main Filing record
        Filing filing = new Filing();
        filing.setFilerId(payload.get("filerId") != null ? Long.valueOf(payload.get("filerId").toString()) : null);
        filing.setFilerName((String) payload.get("filerName"));
        filing.setEin((String) payload.get("ein"));
        filing.setTaxYear((String) payload.get("taxYear"));
        filing.setFormType((String) payload.get("formType"));
        filing.setTotalForms(payload.get("totalForms") != null ? Integer.valueOf(payload.get("totalForms").toString()) : 0);

        Object box1 = payload.get("totalBox1");
        filing.setTotalBox1(box1 != null ? new BigDecimal(box1.toString()) : BigDecimal.ZERO);

        Object box4 = payload.get("totalFederalWithheld");
        filing.setTotalFederalWithheld(box4 != null ? new BigDecimal(box4.toString()) : BigDecimal.ZERO);

        return filingRepository.save(filing)
                .flatMap(savedFiling -> {
                    // 2. Extract and map the recipients list
                    @SuppressWarnings("unchecked")
                    List<Map<String, Object>> recipientMaps = (List<Map<String, Object>>) payload.get("recipients");

                    if (recipientMaps == null || recipientMaps.isEmpty()) {
                        return Mono.error(new IllegalArgumentException("Recipients list cannot be empty"));
                    }

                    Flux<FilingRecipient> recipientFlux = Flux.fromIterable(recipientMaps)
                            .map(map -> {
                                FilingRecipient r = new FilingRecipient();
                                r.setFilingId(savedFiling.getId());

                                Object recId = map.get("recipientId");
                                r.setRecipientId(recId != null ? Long.valueOf(recId.toString()) : null);

                                r.setName((String) map.get("name"));
                                r.setTin((String) map.get("tin"));

                                Object rBox1 = map.get("box1");
                                r.setBox1(rBox1 != null ? new BigDecimal(rBox1.toString()) : BigDecimal.ZERO);

                                Object rBox4 = map.get("box4");
                                r.setBox4(rBox4 != null ? new BigDecimal(rBox4.toString()) : BigDecimal.ZERO);

                                r.setBox6((String) map.get("box6"));
                                r.setDeliveryMethod((String) map.get("deliveryMethod"));
                                r.setStatus((String) map.get("status"));
                                return r;
                            });

                    return recipientRepository.saveAll(recipientFlux)
                            .collectList()
                            .flatMap(savedRecipients -> {
                                // 3. Create and persist the Cart entry linked to filing and filer
                                Cart cartItem = new Cart();
                                cartItem.setFilerId(savedFiling.getFilerId());
                                cartItem.setFilingId(savedFiling.getId());
                                cartItem.setItemStatus("PENDING");

                                // Example calculation: $25 per form
                                BigDecimal total = BigDecimal.valueOf(savedFiling.getTotalForms() * 25.00);
                                cartItem.setTotalAmount(total);

                                return cartRepository.save(cartItem);
                            });
                });
    }

    public Flux<Cart> getCartItemsForFiler(Long filerId) {
        return cartRepository.findByFilerId(filerId);
    }
}
