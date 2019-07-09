package com.cyberlibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainPageController {


    @RequestMapping(value = {"/","/cyberlibrary"})
    public String getMainPage()
    {
        return "index";
    }



}
