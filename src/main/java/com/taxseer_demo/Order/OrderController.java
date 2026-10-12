package com.taxseer_demo.Order;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(
        origins = "http://localhost:4200",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}
)
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public Flux<Orders> getOrders(@RequestParam(required = false) String filer,
                                  @RequestParam(required = false) String year,
                                  @RequestParam(required = false) String status) {
        return orderService.getFilteredOrders(filer, year, status);
    }

    @GetMapping("/{orderId}/forms")
    public Flux<OrderForm> getOrderForms(@PathVariable Long orderId) {
        return orderService.getFormsForOrder(orderId);
    }
}