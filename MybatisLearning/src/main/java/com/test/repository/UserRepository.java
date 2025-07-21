package com.test.repository;

import com.test.entity.User;

import java.util.List;

public interface UserRepository {
    // 返回影响的行数
    int add(User user);
    int delete(Integer id);
    int update(User user);
    User get(Integer id);
    User getByNameAge(String name, int age);
    int getCount();
    List<User> getAll();
}
