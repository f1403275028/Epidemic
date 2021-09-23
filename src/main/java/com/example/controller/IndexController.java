package com.example.controller;

import com.example.controller.impl.IpImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zenglin.Fang
 * @ClassName IndexController
 * @Description:
 * @Data: 2021/3/12 14:54
 **/
@Controller
public class IndexController {
    @Autowired
    IpImpl ipImpl;
    @RequestMapping("/index")
    public String index(HttpServletRequest request, Device device){
        ipImpl.getLocation(request,"进入首页",device);
        return "index";
    }

    @RequestMapping("/LoginFailed")
    public String loginFailed(HttpServletRequest request, Device device){
        ipImpl.getLocation(request,"进入登陆失败页面",device);
        return "LoginFailed";
    }
}
