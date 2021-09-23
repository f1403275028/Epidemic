package com.example.controller;

import com.example.controller.impl.IpImpl;
import com.example.pojo.NewAdd;
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
 * @ClassName ShowNewAddController
 * @Description:
 * @Data: 2021/3/9 14:54
 **/
@Controller
public class ShowNewAddController {

    @Autowired
    private Epidemic_NumberServiceImpl epidemic_numberService;
    @Autowired
    IpImpl ipImpl;
    //进入查看新增页面
    @RequestMapping("/Dashboard/newadd")
    public String newadd(Model model, HttpServletRequest request, Device device){
        ipImpl.getLocation(request,"进入查看新增页面",device);
        Collection<NewAdd> newadds = epidemic_numberService.queryNewList();
        model.addAttribute("newadds",newadds);
        return "newadd";
    }
}
