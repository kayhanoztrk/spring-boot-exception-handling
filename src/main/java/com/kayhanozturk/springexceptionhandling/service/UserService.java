package com.kayhanozturk.springexceptionhandling.service;

import com.kayhanozturk.springexceptionhandling.model.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
}
