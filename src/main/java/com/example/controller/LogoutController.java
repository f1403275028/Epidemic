package com.example.controller;

import com.example.controller.impl.IpImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {
    @Autowired
    IpImpl ipImpl;
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, Device device){
        ipImpl.getLocation(request,"登出",device);
        return "logout";
    }


    @RequestMapping("/whetherlogout")
    public String whetherLogout(HttpServletRequest request, Device device){
        ipImpl.getLocation(request,"确认登出？",device);
        return "Whetherlogout";
    }
}
