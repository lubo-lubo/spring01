package com.lubo.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.lubo.pojo.User;
import com.lubo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    public String dologin(HttpSession session, @RequestParam(required = false) String name, @RequestParam(required=false) String password){
        if(userService.login(name, password)){
            session.setAttribute("name",name);
            return "success";
        }else{
            return "login";
        }
    }


    @RequestMapping("/showP")
    public String showPage(){
        return "showP";
    }
    @RequestMapping("/change")
    @ResponseBody
    public Object change(int pageNum){
        Page<User> page=userService.getPage(pageNum,4);
        System.out.println(page.getRecords());
        return page;
    }

    @RequestMapping("/list")
    public String list(){
        return "list";
    }
    @RequestMapping("/show")
    @ResponseBody
    public Object show(){
        List<User> list=userService.findAll();
        return list;
    }
    @RequestMapping("/showPage")
    @ResponseBody
    public Object show(int pageNum){
        List<User> list=userService.findPage(pageNum,4);
        return list;
    }
}
