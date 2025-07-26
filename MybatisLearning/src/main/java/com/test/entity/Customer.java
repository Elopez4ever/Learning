package com.test.entity;

import lombok.Data;

import java.util.List;

@Data
public class Customer {
    private Integer id;
    private String name;
    private List<Goods> goods;
}
