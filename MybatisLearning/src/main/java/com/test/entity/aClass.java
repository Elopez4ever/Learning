package com.test.entity;

import lombok.Data;

import java.util.List;

@Data
public class aClass {
    private Integer id;
    private String name;
    private List<Student> students;
}
