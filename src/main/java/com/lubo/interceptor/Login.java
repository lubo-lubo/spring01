package com.lubo.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object name=request.getSession().getAttribute("name");
        if(name!=null){
            return true;
        }else{
            response.sendRedirect("/user/login");
            return false;
        }
    }
}
