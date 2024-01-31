package com.sonny.products.service;


import com.github.javafaker.Faker;
import com.sonny.products.entity.Product;
import com.sonny.products.entity.Sentiment;
import com.sonny.products.entity.User;
import com.sonny.products.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor
@Service
public class ProductService {

    private ProductRepository productRepository;

    public Iterable<Product> search(String name, String sentiment) {
        if(Strings.isNotEmpty(name)) {
            return productRepository.findByNameContainingOrderByPriceDesc(name);
        }
        if(Strings.isNotEmpty(sentiment)) {
            return productRepository.findBySentimentsTextContaining(sentiment);
        }
        return this.productRepository.findAll();
    }

    public void initializeProduct() {
        Faker faker = new Faker();
        final List<Product> products = IntStream.range(30, 70).mapToObj(index -> {
            User user = User.builder()
                    .name(faker.name().fullName())
                    .build();
            final List<Sentiment> sentiments = IntStream.range(2, 5).mapToObj(i -> Sentiment.builder()
                    .user(user)
                    .creation(Instant.now())
                    .text(faker.lorem().sentence(6)).build()
            ).collect(Collectors.toList());
            return Product.builder()
                    .sentiments(sentiments)
                    .name("Product "+ index)
                    .price(index * 100)
                    .build();
                }

        ).collect(Collectors.toList());

        this.productRepository.saveAll(products);

    }
}
