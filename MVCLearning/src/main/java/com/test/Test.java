package com.test;

import com.test.config.AppConfig;
import com.test.controller.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserController userController = context.getBean(UserController.class);
        System.out.println(userController.getUserById(1));
    }
}
