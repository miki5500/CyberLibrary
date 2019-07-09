package com.cyberlibrary.controllers;

import com.cyberlibrary.entity.Ksiazka;
import com.cyberlibrary.entity.userEntity.User;
import com.cyberlibrary.entity.userEntity.UserService;
import com.cyberlibrary.helpers.SpringProjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@Controller
public class userController {

    @Autowired
    private UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profil")
    @Transactional
    public String getUserPage(@RequestParam("panel") int panel, Model model)
    {

        String mail = SpringProjectUtils.getLoggedUser();;
        User u = userService.getUserByEmail(mail);

        switch (panel)
        {

            case 1:
                model.addAttribute("message","Witamy");
                break;
            case 2:
                model.addAttribute("data",u);
                break;
            case 3:
                List<Ksiazka> k = new ArrayList<>(u.getBorrowedBooks());
                 model.addAttribute("books",k);
                break;
            case 4:
                model.addAttribute("warn","nie");
                break;
        }

       return "user";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profil/editPassword")
    public String changePassword(Model model)
    {
        String logged = SpringProjectUtils.getLoggedUser();
        User u = userService.getUserByEmail(logged);
        u.setRola(u.getRoles().iterator().next());
        u.setKsiazki(u.getBorrowedBooks());
        model.addAttribute("user",u);
        return "password";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/profil/editPassword")
    public String changePass(@ModelAttribute("user") User user)
    {
       userService.updatePassword(user);
        return "redirect:/cyberlibrary/";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profil/editdata")
    public String changedata(Model model)
    {
        String logged = SpringProjectUtils.getLoggedUser();
        User u = userService.getUserByEmail(logged);
        model.addAttribute("user",u);
        return "data";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/profil/editdata")
    public String changedat(@ModelAttribute("user") User user)
    {
        userService.updateUser(user);
        return "afteredit";
    }



}
