package com.taxseer_demo.Order;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderFormRepository orderFormRepository;

    public OrderService(OrderRepository orderRepository, OrderFormRepository orderFormRepository) {
        this.orderRepository = orderRepository;
        this.orderFormRepository = orderFormRepository;
    }

    public Flux<Orders> getFilteredOrders(String filer, String year, String status) {
        Flux<Orders> orders = orderRepository.findAll();

        if (filer != null && !filer.equals("all")) {
            orders = orders.filter(o -> o.getFiler().equalsIgnoreCase(filer));
        }
        if (year != null && !year.equals("all")) {
            orders = orders.filter(o -> o.getTaxYear().equals(year));
        }
        if (status != null && !status.equals("all")) {
            orders = orders.filter(o -> o.getStatus().equalsIgnoreCase(status));
        }
        return orders;
    }

    public Flux<OrderForm> getFormsForOrder(Long orderId) {
        return orderFormRepository.findByOrderId(orderId);
    }
}