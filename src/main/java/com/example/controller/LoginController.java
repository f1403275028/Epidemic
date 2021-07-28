package com.example.controller;

import com.example.pojo.Login;
import com.example.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password
            ,HttpSession session)
    {
        List<Login> user = loginService.queryUser();
        for (int i =0;i<user.size();i++){
            if(user.get(i).getUsername().equals(username)&&user.get(i).getPassword().equals(password)){
                session.setAttribute("userLoginInfo",username);
                return "Dashboard";
            }
        }
        return "LoginFailed";
    }

    @RequestMapping("/user/addUser")
    public String addUser(){
        return "addNewUser";
    }

    @RequestMapping("/user/addNewUser")
    public String addNewUser(@RequestParam("username") String username,@RequestParam("password") String password){

        loginService.addUser(new Login(username,password));
        return "redirect:/user/addSuccess";
    }

    @RequestMapping("/user/addSuccess")
    public String addSuccess(){
        return "addUserSuccess";
    }

}
