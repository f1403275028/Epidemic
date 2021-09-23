package com.example.controller;

import com.example.controller.impl.IpImpl;
import com.example.service.Epidemic_NumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zenglin.Fang
 * @ClassName DeleteController
 * @Description:
 * @Data: 2021/3/11 14:54
 **/
@Controller
public class DeleteController {

    @Autowired
    IpImpl ipImpl;

    @Autowired
    private Epidemic_NumberServiceImpl epidemic_numberService;

    /**进入删除页面*/
    @RequestMapping("/Dashboard/delete")
    public String delete(HttpServletRequest request, Device device){
        ipImpl.getLocation(request,"进入删除页面",device);
        return "delete";
    }


    /**进入删除页面*/
    @RequestMapping("/Dashboard/deletePeople")
    public String deletePeople(@RequestParam("area") String area){
        epidemic_numberService.deleteNumByArea(area);
        return "redirect:/Dashboard/deleteSuccess";
    }


    /**进入删除成功页面*/
    @RequestMapping("/Dashboard/deleteSuccess")
    public String deleteSuccess(HttpServletRequest request, Device device){
        ipImpl.getLocation(request,"进入删除成功页面",device);
        return "deleteSuccess";
    }
}
