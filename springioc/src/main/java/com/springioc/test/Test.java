package com.springioc.test;


import com.springioc.entity.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        // 加载配置文件
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) classPathXmlApplicationContext.getBean("student");
        System.out.println(student);
    }
}
