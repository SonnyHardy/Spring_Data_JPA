package com.sonny.products.repository;

import com.sonny.products.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Integer> {

    Iterable<User> findByNameContains(String expression);
    @Query("FROM User u WHERE u.name LIKE %?1%")
    Iterable<User> getByEpression(String expression);
}
