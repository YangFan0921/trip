package com.journey.trip.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
public class CookieController {

    @RequestMapping("/cookie")
    public String cookie(HttpServletRequest request){
        System.out.println("123");
        // 从请求对象中获取传递过来的所有cookie
        Cookie[] cookies = request.getCookies();
        // 非空判断
        if (cookies!=null){
            for (Cookie c : cookies){
                String name = c.getName();
                String value = c.getValue();
                System.out.println("name="+name);
                System.out.println("value"+value);
            }
        }
        return "接受掉了cookie";
    }
}
