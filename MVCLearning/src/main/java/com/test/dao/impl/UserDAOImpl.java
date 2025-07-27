package com.test.dao.impl;

import com.test.dao.UserDAO;
import com.test.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO {
    private final static Map<Integer, User> users;

    static {
        users = new HashMap<>();
        users.put(1, new User(1, "张三"));
        users.put(2, new User(2, "李四"));
        users.put(3, new User(3, "王五"));
    }


    @Override
    public User getById(Integer id) {
        return users.get(id);
    }
}
