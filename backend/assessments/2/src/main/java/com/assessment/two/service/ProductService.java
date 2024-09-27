package com.assessment.two.service;

import com.assessment.two.dao.ProductRepository;
import com.assessment.two.dto.ProductDto;
import com.assessment.two.entity.Products;
import com.assessment.two.exception.ErrorWhileExecutingQuery;
import com.assessment.two.mapping.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    /**
     *
     * @param products
     * @return
     */
    public ProductDto addProduct(Products products){
        try {
            Products products1 = productRepository.save(products);
            return Mapper.convertToProduct(products1);
        }catch (Exception e){
            throw new ErrorWhileExecutingQuery("error while adding products");
        }
    }
}
