package com.sonny.products.service;


import com.sonny.products.entity.User;
import com.sonny.products.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;

    public Iterable<User> search(String name) {
        if(Strings.isNotEmpty(name)) {
            return this.userRepository.getByEpression(name);
        }

        return this.userRepository.findAll();
    }


}
