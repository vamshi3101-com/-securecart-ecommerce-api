package com.vamshi.ecommerce.repository;

import com.vamshi.ecommerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {

    List<Cart> findByUserId(Long userId);
}
