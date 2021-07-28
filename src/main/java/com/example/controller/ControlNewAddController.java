package com.example.controller;

import com.example.pojo.NewAdd;
import com.example.service.Epidemic_NumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControlNewAddController {


    @Autowired
    private Epidemic_NumberServiceImpl epidemic_numberService;

    @RequestMapping("/Dashboard/Controlnewadd")
    public String enter(){
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
    public String deletenewaddSuccess(){
        return "deletenewaddSuccess";
    }

    @RequestMapping("/Dashboard/addNewaddSuccess")
    public String addNewaddSuccess(){
        return "addNewaddSuccess";
    }
}
