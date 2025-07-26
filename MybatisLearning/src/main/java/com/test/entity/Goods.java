package com.test.entity;

import lombok.Data;

import java.util.List;

@Data
public class Goods {
    private Integer id;
    private String name;
    private List<Customer> customers;
}
