package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }


    @RequestMapping("/whetherlogout")
    public String whetherLogout(){
        return "Whetherlogout";
    }
}
