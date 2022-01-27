package com.kayhanozturk.springexceptionhandling.service.impl;

import com.kayhanozturk.springexceptionhandling.exception.UserNotFoundException;
import com.kayhanozturk.springexceptionhandling.model.User;
import com.kayhanozturk.springexceptionhandling.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<User> userList = new ArrayList<>();

    @PostConstruct
    public void init() {
        userList.add(new User(1L, "James", "Hetfield"));
        userList.add(new User(2L, "Lars", "Ulrich"));
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public User findById(Long id) {
        return userList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User not found by id: " + id));
    }
}
