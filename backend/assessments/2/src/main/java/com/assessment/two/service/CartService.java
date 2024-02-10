package com.assessment.two.service;

import com.assessment.two.dao.CartRepository;
import com.assessment.two.entity.Cart;
import com.assessment.two.exception.ErrorWhileExecutingQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    public Cart addCart(Cart cart){
        try {
            return cartRepository.save(cart);
        }catch (Exception e){
            throw  new ErrorWhileExecutingQuery("error while saving cart");
        }
    }
}
