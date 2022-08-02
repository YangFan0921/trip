package com.journey.trip;

import com.journey.trip.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// localhost:8080/vrd/send.html
// urlPatters的路径为绝对路径
@WebFilter(filterName = "MyFilter",urlPatterns = {"/vrd/send.html","/vrd/banner.html"})
public class MyFilter implements Filter {
    //销毁
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 把request和response对象转成Http协议下的对象
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
//        System.out.println("拦截");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null){
            chain.doFilter(req, resp); //放行
        }else {
            System.out.println("拦截！");
            //重定向到登录页面
            response.sendRedirect("/vrd/login.html");
        }

    }

    // 初始化
    public void init(FilterConfig config) throws ServletException {

    }

}
