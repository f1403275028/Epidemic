package com.example.controller;


import com.example.pojo.Epidemic_Number;
import com.example.service.Epidemic_NumberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddController {

    //进入添加界面

    @Autowired
    private Epidemic_NumberServiceImpl epidemic_numberService;

    @RequestMapping("/Dashboard/add")
    public String add(Model model){
        return "add";
    }


    //处理添加人数请求
    @PostMapping("/Dashboard/addPeople")
    public String add(@RequestParam("area")String area,
                      @RequestParam("addnum") int addnum,
                      @RequestParam("total") int total,
                      @RequestParam("cure") int cure,
                      @RequestParam("dead") int dead){
        //调用底层业务方法 保存人员信息
        epidemic_numberService.addNum(new Epidemic_Number(area,addnum,total,cure,dead));
        return "redirect:/Dashboard/addSuccess";
    }

    //添加人数成功
    @RequestMapping("/Dashboard/addSuccess")
    public String addSuccess(){
        return "addSuccess";
    }
}
