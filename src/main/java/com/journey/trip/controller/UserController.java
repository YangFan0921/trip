package com.journey.trip.controller;

import com.journey.trip.entity.User;
import com.journey.trip.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired(required = false)
    UserMapper userMapper;

    @RequestMapping("/login")
    public int login(User user, String rem, HttpServletResponse response, HttpSession session){
        System.out.println("rem=" + rem);
        User u = userMapper.login(user.getUsername());
//        System.out.println(user);
        if(u!=null){
            if( u.getPassword().equals(user.getPassword())){
                // 把登录成功的user对象装进session中
                session.setAttribute("user",user);

                // 判断是否记住用户名密码
                if (rem != null){ // 勾选
                    // 创建Cookie对象 把用户名和密码保存进去
                    Cookie cookieUsername = new Cookie("username",user.getUsername());
                    Cookie cookiePassword = new Cookie("password",user.getPassword());
                    // 设置cookie的保存时间（单位：秒）
                    cookieUsername.setMaxAge(60*60*24*30); // 一个月
                    // 通过响应对象response把cookie下发给客户端
                    response.addCookie(cookieUsername);
                    response.addCookie(cookiePassword);
                }
                return 1; // 登陆成功
            }else {
                return 2; // 密码错误
            }
        }else {
            return 3; // 用户名不存在
        }
    }

    @RequestMapping("/checklogin")
    public boolean checklogin(HttpSession session){
        User u = (User) session.getAttribute("user");
        // u==null说明没登录 反之登录了返回true
        return u==null ? false : true;
    }

    @RequestMapping("/logout")
    public void logout(HttpSession session){
        session.removeAttribute("user");
    }

}
