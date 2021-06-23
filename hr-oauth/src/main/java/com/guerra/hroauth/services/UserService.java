package com.guerra.hroauth.services;

import com.guerra.hroauth.entities.User;
import com.guerra.hroauth.feignclients.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserFeignClient userFeignClient;

    public UserService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    public Optional<User> findByEmail(String email){
        Optional<User> user = userFeignClient.findByEmail(email);
        if (!user.isPresent()){
            log.error("Email not found: {}", email);
            throw new IllegalArgumentException("Email not found!");
        }
        log.info("Email found: {}", email);
        return user;
    }
}
