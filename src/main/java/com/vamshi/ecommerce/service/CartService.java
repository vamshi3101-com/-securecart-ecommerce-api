package com.vamshi.ecommerce.service;

import com.vamshi.ecommerce.entity.Cart;
import com.vamshi.ecommerce.entity.User;
import com.vamshi.ecommerce.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class CartService {
    private final CartRepository cartRepository;
    public CartService(CartRepository cartRepository){
        this.cartRepository=cartRepository;
    }
    public Cart addToCart(Cart cart){
        return cartRepository.save(cart);
    }
    public List<Cart> getAllInCart(){
        return cartRepository.findAll();
    }
    public Cart getById(Long id){
        return cartRepository.findById(id).orElse(null);
    }
    public Cart updateCart(Long cartid,int quantity){
        Cart oldCart=cartRepository.findById(cartid).orElse(null);
        if(oldCart!=null){
            oldCart.setQuantity(quantity);

        }
        return cartRepository.save(oldCart);
    }
    public void deleteCart(Long cartid){
        cartRepository.deleteById(cartid);

    }
}
