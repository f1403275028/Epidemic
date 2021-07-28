package com.example.controller;

import com.example.pojo.Epidemic_Number;
import com.example.service.Epidemic_NumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class DashboardController {


    @Autowired
    private Epidemic_NumberServiceImpl epidemic_numberService;

    @RequestMapping("/Dashboard/")
    public String dashboard(Model model){

        Collection<Epidemic_Number> allnum = epidemic_numberService.queryNumList();
        model.addAttribute("allnum",allnum);
        return "Dashboard";
    }
}