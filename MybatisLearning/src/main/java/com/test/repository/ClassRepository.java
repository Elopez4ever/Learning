package com.test.repository;

import com.test.entity.aClass;

public interface ClassRepository {
    aClass getById(Integer id);
    aClass findById(Integer id);
}
