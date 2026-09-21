package com.vamshi.ecommerce.controller;

import com.vamshi.ecommerce.entity.Order;
import com.vamshi.ecommerce.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService){
        this.orderService=orderService;
    }
    @PostMapping
    public Order createOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }
    @GetMapping
    public List<Order> findAllOrder(){
        return orderService.getAllOrder();
    }
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id,
                             @RequestBody Order order){
        return orderService.updateOrder(id,order);
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
    }
    @GetMapping("/users/{userId}")
    public List<Order> getByUser(@PathVariable Long userid){
        return orderService.getOrderByUser(userid);
    }
}
