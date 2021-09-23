package com.example.controller;

import com.example.controller.impl.IpImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PermissionsController {
    @Autowired
    IpImpl ipImpl;
    @RequestMapping("/noPermissions")
    public String permissions(HttpServletRequest request, Device device){
        ipImpl.getLocation(request,"进入无权限页面",device);
        return "NoPermissions";
    }
}
