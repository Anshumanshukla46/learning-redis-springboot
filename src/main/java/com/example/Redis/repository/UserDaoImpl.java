package com.example.Redis.repository;

import com.example.Redis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private RedisTemplate redisTemplate;

    private final String KEY = "USER"; // Redis is a key-value store, although we can store values without any key
//  using key is somewhere a good practice for organised data
// HERE THIS KEY CAN HAVE MULTIPLE DATA-STRUCTURES LIKE HASH, STRINGS

    @Override
    public boolean saveUser(User user) {
        try {
            // returns a HashOperation which have many methods like putall, put, get, delete, entries

            // in redis, this have hash which store field-value

            // HERE WE CAN THINK OF LABEL, HASHES-KEY, ACTUAL VALUE
            redisTemplate.opsForHash().put(KEY, user.getId().toString(), user); // adding user in redis server
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> fetchAllUser() {
//        return redisTemplate.opsForHash().values(KEY);
        Long userid = 1L;

        System.out.println("FETCH = "+redisTemplate.opsForHash().get(KEY, userid.toString()));

        return redisTemplate.opsForHash().values(KEY);
    }
}
