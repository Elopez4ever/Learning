package com.springioc.ioc;


import com.springioc.entity.Address;
import com.springioc.entity.Student;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlContextApplication("D:\\IdeaProjects\\springioc\\src\\main\\resources\\spring.xml");
        Student student = (Student) applicationContext.getBean("student");
        Address address = (Address) applicationContext.getBean("address");
        System.out.println(student);
        System.out.println(address);
    }
}
