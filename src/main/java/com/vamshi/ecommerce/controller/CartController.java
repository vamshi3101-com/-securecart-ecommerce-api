package com.vamshi.ecommerce.controller;

import com.vamshi.ecommerce.entity.Cart;
import com.vamshi.ecommerce.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/cart")
public class CartController {
    private final CartService cartservice;
    public CartController(CartService cartservice){
    this.cartservice=cartservice;
    }
    @PostMapping
    public Cart savedToCart(@RequestBody Cart cart){
        return cartservice.addToCart(cart);
    }
    @GetMapping
    public List<Cart>getAllInCart(){
        return cartservice.getAllInCart();
    }
    @GetMapping("/{id}")
    public Cart getById(@PathVariable Long id){
        return cartservice.getById(id);
    }
    @PutMapping("/{id}")
    public Cart updateCart(@RequestParam int quantity,
                           @PathVariable Long id){
        return cartservice.updateCart(id,quantity);
    }
    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable Long id){
        cartservice.deleteCart(id);
    }
    @GetMapping("/user/{userId}")
    public List<Cart>getByUser(@PathVariable Long userId){
        List<Cart>all=cartservice.getAllInCart();
        List<Cart>result=new java.util.ArrayList<>();
        for(Cart c:all){
            if(c.getUserId().equals(userId)){
                result.add(c);
            }
        }
        return result;
    }

}
