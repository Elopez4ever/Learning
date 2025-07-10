package com.springioc.entity;

import lombok.Data;

import java.util.List;

@Data
public class Student {
    private long id;
    private String name;
    private int age;
    private Address address;
    private List<Hobby> hobbies;
}
