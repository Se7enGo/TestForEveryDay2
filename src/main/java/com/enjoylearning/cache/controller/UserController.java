package com.enjoylearning.cache.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private ThreadLocal<String> user = new ThreadLocal<>();

    @RequestMapping("/user")
    public String loginUser(@RequestParam(required = true) String userName) {
        long start = System.currentTimeMillis();
        try {

            user.set(userName);
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        return "共用时：" + (end - start) + "登录用户是：" + user.get();
    }
}
