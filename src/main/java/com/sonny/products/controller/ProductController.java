package com.sonny.products.controller;


import com.sonny.products.entity.Product;
import com.sonny.products.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping(path = "product", produces = APPLICATION_JSON_VALUE)
public class ProductController {

    private ProductService productService;

    @GetMapping
    public Iterable<Product> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String sentiment) {
        return this.productService.search(name, sentiment);
    }
}
