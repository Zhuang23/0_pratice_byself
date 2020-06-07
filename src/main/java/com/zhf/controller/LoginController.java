package com.zhf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.PublicKey;

@Controller
public class LoginController {
    @PostMapping("/user/login")
    public String login(HttpServletRequest request, HttpServletResponse response,String username, String password) throws ServletException, IOException {
        if( !StringUtils.isEmpty(username) && "123456".equals(password))
        {
            request.getSession().setAttribute("loginUser",username);
            return "redirect:/main.html";
//            request.getRequestDispatcher("main.html").forward(request,response);

        }
        request.setAttribute("msg","用户名或者密码错误");
        return "login";
    }
}
