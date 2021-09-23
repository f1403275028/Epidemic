package com.example.controller;

import com.example.controller.impl.IpImpl;
import com.example.pojo.Epidemic_Number;
import com.example.service.Epidemic_NumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Zenglin.Fang
 * @ClassName UpdateController
 * @Description:
 * @Data: 2021/3/9 14:54
 **/
@Controller
public class UpdateController {
    @Autowired
    IpImpl ipImpl;
    @Autowired
    private Epidemic_NumberServiceImpl epidemic_numberService;

    @RequestMapping("/Dashboard/update")
    public String uodate(HttpServletRequest request, Device device){
        ipImpl.getLocation(request,"进入更新页面",device);
        return "update";
    }

    /**处理修改请求*/
    @PostMapping("/Dashboard/updatePeople")
    public String updatePeople(@RequestParam("area") String area,
                               @RequestParam("addnum") int addnum,
                               @RequestParam("total") int total,
                               @RequestParam("cure") int cure,
                               @RequestParam("dead") int dead){
        //调用底层业务方法 保存人员信息
        epidemic_numberService.updateNum(new Epidemic_Number(area,addnum,total,cure,dead));
        return "redirect:/Dashboard/updateSuccess";
    }

    /**修改成功*/
    @RequestMapping("/Dashboard/updateSuccess")
    public String addSuccess(HttpServletRequest request, Device device){
        ipImpl.getLocation(request,"进入更新成功页面",device);
        return "updateSuccess";
    }
}
