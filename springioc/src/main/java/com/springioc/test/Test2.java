package com.springioc.test;

import com.springioc.entity.People;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
        People person = (People) classPathXmlApplicationContext.getBean("person");
        System.out.println(person);
    }
}
