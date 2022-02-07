package com.proyecto.proyecto.controller;


import com.proyecto.proyecto.model.document.User;
import com.proyecto.proyecto.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/e-comerce")
@RequiredArgsConstructor
public class UserController {

        private final UserService service;

        @GetMapping("/user/{id}")
        public User getUserById(@PathVariable String id) {
        log.info("GET obtener User por el id");
        return service.getUserById(id);
    }

        @PostMapping("/user")
        public User createMessage(@RequestBody User user) {
        log.info("POST crear User");
        return service.create(user);
    }

    }
