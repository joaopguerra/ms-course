package com.guerra.hroauth.resources;

import com.guerra.hroauth.entities.User;
import com.guerra.hroauth.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/search")
    @ResponseStatus(HttpStatus.OK)
    public User findByEmail(@RequestParam String email){
        Optional<User> user = userService.findByEmail(email);

        return user.orElseThrow(IllegalArgumentException::new);
    }
}
