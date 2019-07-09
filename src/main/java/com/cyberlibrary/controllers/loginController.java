package com.cyberlibrary.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;

@Controller
public class loginController {

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "logout", required = false) String logout , Model model)
    {

        if(error != null)
        {

                model.addAttribute("error", "Nieprawidłowy login i/lub hasło");

        }

        if(logout != null)
        {
                model.addAttribute("error", "Pomyślnie wylogowano");
        }

        return "login";
    }
}
