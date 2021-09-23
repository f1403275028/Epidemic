package com.example.controller;

import com.example.controller.impl.IpImpl;
import com.example.pojo.NewAdd;
import com.example.service.Epidemic_NumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zenglin.Fang
 * @ClassName  ControlNewAddController
 * @Description:
 * @Data: 2021/3/9 14:54
 **/
@Controller
public class ControlNewAddController {


    @Autowired
    private Epidemic_NumberServiceImpl epidemic_numberService;

    @Autowired
    IpImpl ipImpl;

    @RequestMapping("/Dashboard/Controlnewadd")
    public String enter(HttpServletRequest request, Device device){
        ipImpl.getLocation(request,"进入新增页面",device);
        return "controlnewadd";
    }

    @RequestMapping("/Dashboard/addNew")
    public String addnewadd(@RequestParam("area")String area,@RequestParam("num") int num){
        epidemic_numberService.addNew(new NewAdd(area,num));
        return "redirect:/Dashboard/addNewaddSuccess";
    }


    @RequestMapping("/Dashboard/deleteNewadd")
    public String deletenewadd(@RequestParam("area")String area){
        epidemic_numberService.deletenewByArea(area);
        return "redirect:/Dashboard/deletenewaddSuccess";
    }

    @RequestMapping("/Dashboard/deletenewaddSuccess")
    public String deletenewaddSuccess(HttpServletRequest request, Device device){
        ipImpl.getLocation(request,"进入删除成功页面",device);
        return "deletenewaddSuccess";
    }

    @RequestMapping("/Dashboard/addNewaddSuccess")
    public String addNewaddSuccess(HttpServletRequest request, Device device){
        ipImpl.getLocation(request,"进入添加成功页面",device);
        return "addNewaddSuccess";
    }
}
