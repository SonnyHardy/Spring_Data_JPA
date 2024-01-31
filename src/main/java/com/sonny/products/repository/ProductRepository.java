package com.sonny.products.repository;

import com.sonny.products.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    // select * from product where name= "param"
    Iterable<Product> findByName(String name);
    Iterable<Product> findByNameContainingOrderByPriceDesc(String name);

    Iterable<Product> findByPriceAfter(int price);

    List<Product> findBySentimentsTextContaining(String text);

}
