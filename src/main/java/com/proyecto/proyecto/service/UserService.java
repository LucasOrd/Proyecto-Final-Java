package com.proyecto.proyecto.service;



import com.proyecto.proyecto.model.document.User;

import java.util.List;

public interface UserService {

        User create(User message);
        List<User> findAll();
        User getUserById(String id);

    }