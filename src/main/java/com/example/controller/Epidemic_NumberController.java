package com.example.controller;

import com.example.controller.impl.IpImpl;
import com.example.pojo.Epidemic_Number;
import com.example.service.Epidemic_NumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @author Zenglin.Fang
 * @ClassName Epidemic_NumberController
 * @Description:
 * @Data: 2021/4/9 14:54
 **/
@Controller
public class Epidemic_NumberController {

    @Autowired
    IpImpl ipImpl;
    @Autowired
    private Epidemic_NumberServiceImpl epidemic_numberService;

    @RequestMapping("/Dashboard/allnumber")
    public String getAllEmployee(Model model, HttpServletRequest request, Device device){
        ipImpl.getLocation(request,"进入全量数据页面",device);
        Collection<Epidemic_Number> allnum = epidemic_numberService.queryNumList();
        model.addAttribute("allnum",allnum);
        return "AllNumber";
    }
}
