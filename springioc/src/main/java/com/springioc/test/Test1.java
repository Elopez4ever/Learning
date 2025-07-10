package com.springioc.test;

import com.springioc.entity.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-factory.xml");
        Car car = (Car) classPathXmlApplicationContext.getBean("car");
        System.out.println(car);

        Car car1 = (Car) classPathXmlApplicationContext.getBean("car1");
        System.out.println(car1);
    }
}
