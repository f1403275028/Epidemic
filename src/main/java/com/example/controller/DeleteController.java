package com.example.controller;

import com.example.service.Epidemic_NumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteController {



    @Autowired
    private Epidemic_NumberServiceImpl epidemic_numberService;

    /**进入删除页面*/
    @RequestMapping("/Dashboard/delete")
    public String delete(){
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
    public String deleteSuccess(){
        return "deleteSuccess";
    }
}
