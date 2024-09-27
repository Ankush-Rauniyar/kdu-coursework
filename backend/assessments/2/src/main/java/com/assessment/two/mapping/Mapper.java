package com.assessment.two.mapping;

import com.assessment.two.dto.ProductDto;
import com.assessment.two.dto.UserDto;
import com.assessment.two.entity.Products;
import com.assessment.two.entity.Users;

public class Mapper {

    public static UserDto convertToUserDto(Users users){
        return new UserDto(users.getUserId(),users.getUsername());
    }

    public static ProductDto convertToProduct(Products products){
        return new ProductDto(products.getPid(),products.getName());
    }
}
