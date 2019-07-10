package com.cyberlibrary.controllers;

import com.cyberlibrary.entity.Autor;
import com.cyberlibrary.entity.Ksiazka;
import com.cyberlibrary.entity.userEntity.User;
import com.cyberlibrary.entity.userEntity.UserService;
import com.cyberlibrary.helpers.PageOfAutors;
import com.cyberlibrary.helpers.PageOfBooks;
import com.cyberlibrary.helpers.PageOfUsers;
import com.cyberlibrary.services.AutorService;
import com.cyberlibrary.services.KsiazkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import java.util.List;

@Controller
public class adminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AutorService autorService;

    @Autowired
    private KsiazkaService ksiazkaService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String getAdmin(Model model)
    {
        model.addAttribute("message","");
        return "admin";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/userlist")
    public String getAdminPage(@RequestParam("page") int strona, Model model)
    {
        PageOfUsers u = userService.getUsersPage(strona * 8);
        List<User> user = u.getUsersPage();
        model.addAttribute("users",user);
        model.addAttribute("strony",u.getNrStron());
        if(strona > 0)
        {
            model.addAttribute("prev", strona - 1);
        }
        if(strona < u.getNrStron())
        {
            model.addAttribute("next",strona + 1);
        }
        return "admin";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/deleteuser")
    public String deleteUser(@RequestParam("userId") int id, Model model)
    {
        User u = userService.getUserById(id);
        u.setRoles(null);
        userService.updateUser(u);
        System.out.println(u.getEmail());
        userService.deleteUser(u);
        return "redirect:/admin/userlist?page=0";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/autorlist")
    public String getAutorPage(@RequestParam("page") int strona, Model model)
    {
        PageOfAutors u = autorService.getAutorPage(strona * 8);
        List<Autor> autor = u.getAutorList();
        model.addAttribute("autors",autor);
        model.addAttribute("strony",u.getNrstron());
        if(strona > 0)
        {
            model.addAttribute("prev", strona - 1);
        }
        if(strona < u.getNrstron())
        {
            model.addAttribute("next",strona + 1);
        }
        return "admin";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/deleteautor")
    public String deleteAutor(@RequestParam("autorId") int id)
    {
        Autor a = autorService.getAutor(id);
       // List<Ksiazka> k = ksiazkaService.getKsiazkiByAutor(a);
        //for (Ksiazka ks:k ) {
         //   if(ks.getAutorzy().size()== 1)
          //  {
           //     ksiazkaService.delete(ks);
           // }
        //}
       autorService.deleteAutor(id);

        return "redirect:/admin/autorlist?page=0";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/borrowedBooks")
    public String getBorrowedBooks(@RequestParam("page") int strona, Model model)
    {
        PageOfBooks pageOfBooks= ksiazkaService.pageOfBorrowed(strona * 8);
        List<Ksiazka> k = pageOfBooks.getKsiazkaList();
        model.addAttribute("ksiazki",k);
        model.addAttribute("strony",pageOfBooks.getCountOfPages());
        if(strona > 0)
        {
            model.addAttribute("prev", strona - 1);
        }
        if(strona < pageOfBooks.getCountOfPages())
        {
            model.addAttribute("next",strona + 1);
        }
        return "borrowedList";

    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin/bookreturn")
    public String returnBook(@RequestParam("bookId") int id)
    {
        Ksiazka k = ksiazkaService.getKsiazkaById(id);
        k.returnBook();
        ksiazkaService.saveKsiazka(k);
        return "redirect:/admin/borrowedBooks?page=0";

    }

}
