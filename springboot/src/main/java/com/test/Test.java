package com.test;

import com.test.entity.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Account account = (Account) classPathXmlApplicationContext.getBean("account");
    }
}
