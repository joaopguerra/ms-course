package com.guerra.hruser.resources;

import com.guerra.hruser.entities.User;
import com.guerra.hruser.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserRepository userRepository;

    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable Long id) throws Exception {

        Optional<User> user = userRepository.findById(id);

        return user.orElseThrow(Exception::new);
    }

    @GetMapping(value = "/search")
    @ResponseStatus(HttpStatus.OK)
    public User findByEmail(@RequestParam String email) {

        User user = userRepository.findByEmail(email);

        return user;
    }
}

