package com.example.controller;

import com.example.pojo.NewAdd;
import com.example.service.Epidemic_NumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class ShowNewAddController {

    @Autowired
    private Epidemic_NumberServiceImpl epidemic_numberService;

    //进入查看新增页面
    @RequestMapping("/Dashboard/newadd")
    public String newadd(Model model){
        Collection<NewAdd> newadds = epidemic_numberService.queryNewList();
        model.addAttribute("newadds",newadds);
        return "newadd";
    }
}
