package com.assessment.two.service;

import com.assessment.two.dao.*;
import com.assessment.two.entity.Cart;
import com.assessment.two.entity.Orders;
import com.assessment.two.entity.Products;
import com.assessment.two.entity.Users;
import com.assessment.two.exception.ErrorWhileExecutingQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Map;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private AddressRepository addressRepository;
    private ProductRepository productRepository;
    private UserRepository userRepository;
    private CartRepository cartRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }


    public Orders getOrder(int cartId,int addressId){
        try {
            Cart cart = cartRepository.getReferenceById(cartId);
            Users users = userRepository.getReferenceById(cart.getUsers().getUserId());
            int total = 0;
//        for(Map.Entry<Integer,Integer> entry: cart.getItems().entrySet()){
//            int key = entry.getKey();
//            int number = entry.getValue();
//            Products products = productRepository.getReferenceById(key);
//            total += number*products.getPrice();
//            if(products.getQuantity() < 4){
//                productRepository.updateProduct(products.getProductId());
//            }
//        }
            for (Products products : cart.getItems()) {
                total += products.getPrice();
                Products current = productRepository.getReferenceById(products.getPid());
                current.setQuantity(current.getQuantity() - products.getQuantity());
//            if(current.getQuantity() < 4){
//                productRepository.updateProduct(products.getProductId());
//
//            }
            }
            Orders orders = new Orders();
            orders.setOrderDate(LocalDate.now());
            orders.setAmount(total);
            orders.setAddress(addressRepository.getReferenceById(addressId));
            orders.setUsers(users);
            return orderRepository.save(orders);
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while creating order");
        }
    }
}
