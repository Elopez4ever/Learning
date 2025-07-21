package com.test.repository;

import com.test.entity.Student;

public interface StudentRepository {
    Student getById(Integer id);
}
