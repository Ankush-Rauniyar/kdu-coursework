package com.assessment.two.controller;

import com.assessment.two.dto.AddressDto;
import com.assessment.two.dto.ProductDto;
import com.assessment.two.dto.UserDto;
import com.assessment.two.entity.*;
import com.assessment.two.service.*;
import jakarta.persistence.GeneratedValue;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingController {

    private UsersService usersService;
    private ProductService productService;
    private CartService cartService;
    private AddressService addressService;
    private OrderService orderService;

    @GetMapping("/person/login")
    public String check(){
        return "hello";
    }

    @Autowired
    public ShoppingController(UsersService usersService,ProductService productService,AddressService addressService,CartService cartService,OrderService orderService){
        this.usersService = usersService;
        this.productService = productService;
        this.addressService = addressService;
        this.cartService = cartService;
        this.orderService = orderService;
    }

    @PostMapping("app/users")
    public UserDto addUser(@RequestBody Users users){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        UserDto userDto= usersService.addUser(users);
        userDto.setName("usernam->"+ username);
        return userDto;
    }

    @PostMapping("app/product")
    public ProductDto addProduct(@RequestBody Products products){

        return productService.addProduct(products);
    }

    @PostMapping("app/address")
    public AddressDto addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @PostMapping("app/cart")
    public Cart addCart(@RequestBody Cart cart){
        return cartService.addCart(cart);
    }

    @GetMapping("app/get")
    public Orders getOrder(@RequestParam int cartId, @RequestParam int addressId){
        return orderService.getOrder(cartId,addressId);
    }
}
