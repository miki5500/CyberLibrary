package com.cyberlibrary.controllers;

import com.cyberlibrary.DAO.KsiazkaDAO;
import com.cyberlibrary.constants.SpringProjectConstants;
import com.cyberlibrary.entity.Ksiazka;
import com.cyberlibrary.entity.userEntity.User;
import com.cyberlibrary.entity.userEntity.UserService;
import com.cyberlibrary.helpers.SpringProjectUtils;
import com.cyberlibrary.helpers.UserData;
import com.cyberlibrary.services.KsiazkaService;
import com.cyberlibrary.validators.UserRegisterValidator;
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

    @Autowired
    private KsiazkaService ksiazkaService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profil")
    @Transactional
    public String getUserPage(@RequestParam("panel") int panel, Model model)
    {

        String mail = SpringProjectUtils.getLoggedUser();
        User u = userService.getUserByEmail(mail);

        switch (panel)
        {

            case 1:
                model.addAttribute("message","Witamy");
                break;
            case 2:
                model.addAttribute("data",u);
                break;
        }

       return "user";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profil/editPassword")
    public String changePassword(Model model)
    {

       UserData u = new UserData();
        model.addAttribute("user",u);
        return "password";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/profil/editPassword")
    public String changePass(@ModelAttribute("user") UserData user)
    {
        String logged = SpringProjectUtils.getLoggedUser();
        User u = userService.getUserByEmail(logged);
       u.setPassword(user.getHaslo());
       userService.updatePassword(u);
        return "redirect:/cyberlibrary/";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profil/editData")
    public String changedata(Model model)
    {
        UserData u = new UserData();
        model.addAttribute("user",u);
        return "data";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/profil/editData")
    public String changedat(@ModelAttribute("user") UserData user)
    {
        String logged = SpringProjectUtils.getLoggedUser();
        User u = userService.getUserByEmail(logged);
        if(!(user.getImie().trim().equals("")))
        {
            u.setName(user.getImie());
        }
        if(!(user.getNazwisko().trim().equals("")))
        {
            u.setLastName(user.getNazwisko());
        }
        if(!(user.getMail().trim().equals("")))
        {
           if(SpringProjectUtils.checkEmailOrPassword(SpringProjectConstants.EMAIL_PATTERN,user.getMail())) {
               u.setEmail(user.getMail());
           }
        }
        userService.updateUser(u);

        return "afteredit";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profil/borrowed")
    @Transactional
    public String getBorrowedPage(@RequestParam("page") int strona, Model model)
    {

        String mail = SpringProjectUtils.getLoggedUser();
        User u = userService.getUserByEmail(mail);
        List<Ksiazka> k = new ArrayList<>(u.getBorrowedBooks());
        List<Ksiazka> bor;
        int liczbaStron = k.size() / 8;
        if(liczbaStron > 1)
        {
            bor = new ArrayList<>();
           for(int i = strona * 8; i < (strona * 8)+8; i++)
           {
               bor.add(k.get(i));
           }

            model.addAttribute("books",bor);

        }else
        {
            model.addAttribute("books",k);
        }

        model.addAttribute("strony",liczbaStron);
        if(strona > 0)
        {
            model.addAttribute("prev", strona - 1);
        }
        if(strona < liczbaStron)
        {
            model.addAttribute("next",strona + 1);
        }

         return "user";
    }

}
