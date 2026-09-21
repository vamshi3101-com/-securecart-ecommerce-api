package com.vamshi.ecommerce.service;

import com.vamshi.ecommerce.ResourceNotFoundException;
import com.vamshi.ecommerce.entity.Order;
import com.vamshi.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }
    public Order addOrder(Order order){
        return orderRepository.save(order);
    }
    public List<Order>getAllOrder(){
        return orderRepository.findAll();
    }
    public Order getOrderById(Long id){
        return orderRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("Order not found with id " + id));
    }
    public Order updateOrder(Long id,Order order){
        Order oldOrder=orderRepository.findById(id).orElse(null);
        if(oldOrder!=null){
            oldOrder.setUserId(order.getUserId());
            oldOrder.setAmount(order.getAmount());
            oldOrder.setStatus(order.getStatus());
            oldOrder.setOrderDate(order.getOrderDate());
        }
        return orderRepository.save(oldOrder);
    }
    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }
    public List<Order> getOrderByUser(Long userid){
        return orderRepository.findByUserId(userid);
    }
}
