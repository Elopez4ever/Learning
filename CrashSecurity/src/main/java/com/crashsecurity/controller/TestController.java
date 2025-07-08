package com.crashsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        return "你好，已登录用户";
    }

    @GetMapping("/profile")
    public String profile() {
        return "这里是个人中心，USER/ADMIN都可以访问";
    }

    @GetMapping("/admin")
    public String admin() {
        return "这里是管理员页面，只有ADMIN能访问";
    }
}
