package com.example.Redis.service;

import com.example.Redis.entity.User;

import java.util.List;

public interface UserService {
    boolean saveUser(User user);

    List<User> fetchAllUser();
}
