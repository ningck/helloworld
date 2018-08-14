package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "user")
public class SampleController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "index")
    public String index(){
        return "user/index";
    }


    @RequestMapping(value = "find",method = RequestMethod.GET)
    public String find(@RequestParam(value = "name")String name, Model model){
        User user = userService.findUserByName(name);

        if(user != null){
            model.addAttribute("user",user);
            System.out.println(user);
        }else{
            model.addAttribute("message","未查询到用户");
        }
        return "user/index";
    }
}
