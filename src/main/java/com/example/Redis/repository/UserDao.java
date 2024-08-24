package com.example.Redis.repository;

import com.example.Redis.entity.User;

import java.util.List;

public interface UserDao {
    boolean saveUser(User user);

    List<User> fetchAllUser();
}
