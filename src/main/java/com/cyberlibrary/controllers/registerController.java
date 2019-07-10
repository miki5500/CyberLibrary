package com.cyberlibrary.controllers;

import com.cyberlibrary.entity.userEntity.User;
import com.cyberlibrary.entity.userEntity.UserService;
import com.cyberlibrary.helpers.AddBook;
import com.cyberlibrary.validators.UserRegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class registerController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String getRegisterPage(Model model)
    {
        User user = new User();
        model.addAttribute("user",user);
        return "register";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") User user, BindingResult result,Model model)
    {
        System.out.println(user.getPassword());
        String returnPage;
        User userExist = userService.getUserByEmail(user.getEmail());
        System.out.println("Jestem tu");
        new UserRegisterValidator().validateEmailExist(userExist,result);
        System.out.println("Jestem tam");
        new UserRegisterValidator().validate(user,result);

            System.out.println("Jestem save");
            userService.saveUser(user);
            returnPage = "index";
        return returnPage;

    }

}
