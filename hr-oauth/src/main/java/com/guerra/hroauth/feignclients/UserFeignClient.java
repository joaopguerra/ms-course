package com.guerra.hroauth.feignclients;

import com.guerra.hroauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Component
@FeignClient(name = "hr-user", path = "/users")
public interface UserFeignClient {

    @GetMapping(value = "/search")
    Optional<User> findByEmail(@RequestParam String email);
}
