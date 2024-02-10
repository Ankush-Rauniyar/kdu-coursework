package com.assessment.two.dao;

import com.assessment.two.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Products,Integer> {
//    @Modifying
//    @Query("UPDATE products set quantity = 100 where product_id =: productId")
//    public void updateProduct(@Param("productId") int productId);
}
