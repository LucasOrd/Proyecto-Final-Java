package com.proyecto.proyecto.service.Impl;


import com.proyecto.proyecto.cache.CacheClient;
import com.proyecto.proyecto.model.exceptions.ApiRestException;
import com.proyecto.proyecto.model.document.User;
import com.proyecto.proyecto.repository.UserRepository;
import com.proyecto.proyecto.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final CacheClient<User> cache;

    @Override
    public User create(User user) {
        try {
            var data = repository.save(user);
            return saveUserInCache(data);
        } catch (JsonProcessingException e) {
            log.error("Error converting message to string", e);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(repository.findAll());
    }

    @Override
    public User getUserById(String id) {
        try {
            var dataFromCache = cache.recover(id, User.class);
            if (!Objects.isNull(dataFromCache)) {
                return dataFromCache;
            }
            var dataFromDatabase = repository.findById(id)
                    .orElseThrow(ApiRestException::new);
            return saveUserInCache(dataFromDatabase);
        } catch (JsonProcessingException e) {
            log.error("Error converting user to string", e);
        } catch (ApiRestException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User saveUserInCache(User user) throws JsonProcessingException {
        return cache.save(user.getId(), user);
    }

}
