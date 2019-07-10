package com.cyberlibrary.controllers;

import com.cyberlibrary.entity.Autor;
import com.cyberlibrary.entity.Dziedzina;
import com.cyberlibrary.entity.Ksiazka;
import com.cyberlibrary.entity.userEntity.User;
import com.cyberlibrary.entity.userEntity.UserService;
import com.cyberlibrary.helpers.AddBook;
import com.cyberlibrary.helpers.PageOfBooks;
import com.cyberlibrary.helpers.SpringProjectUtils;
import com.cyberlibrary.services.AutorService;
import com.cyberlibrary.services.DziedzinaService;
import com.cyberlibrary.services.KsiazkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class bookController {


    @Autowired
    private AutorService autorService;

    @Autowired
    private KsiazkaService ksiazkaService;

    @Autowired
    private DziedzinaService dziedzinaService;

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/books/addBookForm")
    public String addBook(Model model)
    {
        AddBook book = new AddBook();
        model.addAttribute("book",book);
        List<Dziedzina> d = dziedzinaService.getListaDziedzin();
        model.addAttribute("listaD",d);
        return "addBookform";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/books/addBook")
    @Transactional
    public String saveBook(@ModelAttribute("book") AddBook addBook)
    {
        Autor a = autorService.getAutorByName(addBook.getName(),addBook.getLastName());
        Ksiazka k = new Ksiazka();
        Dziedzina d = dziedzinaService.getDziedzina(addBook.getCategory());
        k.setDostepna(1);
        k.setTytul(addBook.getTitle());
        k.setWydawnictwo(addBook.getWydawnictwo());
        k.setDziedzina(d);

        if(a == null)
        {
            a= new Autor();
            a.setImie(addBook.getName());
            a.setNazwisko(addBook.getLastName());
            autorService.saveAutor(a);
        }

        a.addKsiazka(k);
        k.addAutor(a);

        ksiazkaService.saveKsiazka(k);


        return "redirect:/books/bookList?page=0";
    }

    //@GetMapping("/books/bookList")
   // public String getBooks(@RequestParam("page") int strona, Model model)
    //{
     //   List<Ksiazka> k = ksiazkaService.getKsiazki();
     //   model.addAttribute("ksiazki",k);
    //    return "bookList";
    //}

    @GetMapping("/books/bookList")
    public String getPaginatedList(@RequestParam("page") int strona, Model model)
    {
       PageOfBooks pageOfBooks= ksiazkaService.getPaginatedList(strona * 8);
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
        return "bookList";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/books/borrowForm")
    @Transactional
    public String getBorrowForm(@RequestParam("bookId") int id, Model model)
    {
        int message = 1;
        Ksiazka ksiazka = ksiazkaService.getKsiazkaById(id);
        if(ksiazka.getDostepna() == 0)
        {
            message = 0;
        }else
        {
            ksiazka.setDostepna(0);
            String email;
            email = SpringProjectUtils.getLoggedUser();
            User user = userService.getUserByEmail(email);
            ksiazka.setBorrowedBy(user);
            ksiazkaService.saveKsiazka(ksiazka);
        }

        List<Autor> autorzy =new ArrayList<>(ksiazka.getAutorzy());
        model.addAttribute("message",message);
        model.addAttribute("ksiazka", ksiazka);
        model.addAttribute("autorzy",autorzy);
        return "borrowForm";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/books/borrow")
    @Transactional
    public String borrowBook(@RequestParam("bookId") int id,@RequestParam("confirm") boolean confirm)
    {
        if(!confirm)
        {
            Ksiazka ksiazka = ksiazkaService.getKsiazkaById(id);
            ksiazka.returnBook();
            ksiazkaService.saveKsiazka(ksiazka);
        }
        return "redirect:/cyberlibrary";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("books/updateBookForm")
    @Transactional
    public String updateBook(@RequestParam("bookId")int id,Model model)
    {
        Ksiazka ksiazka = ksiazkaService.getKsiazkaById(id);
        model.addAttribute("bookU",ksiazka);
        AddBook book = new AddBook();
        model.addAttribute("book",book);
        List<Dziedzina> d = dziedzinaService.getListaDziedzin();
        model.addAttribute("listaD",d);
        model.addAttribute("action","/cyberlibrary/books/update?bookId=" + id);
        return "updateForm";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/books/update")
    @Transactional
    public String updateBook(@ModelAttribute("book") AddBook addBook,@RequestParam("bookId") int id)
    {
        Ksiazka k = ksiazkaService.getKsiazkaById(id);

        if(!(addBook.getName().equals("")))
        {
            Autor a = autorService.getAutorByName(addBook.getName(),addBook.getLastName());
            if(a == null)
            {
                a= new Autor();
                a.setImie(addBook.getName());
                a.setNazwisko(addBook.getLastName());
                autorService.saveAutor(a);
            }

            a.addKsiazka(k);
            k.addAutor(a);
        }


        if(!(addBook.getCategory().equals(k.getDziedzina().getNazwa())))
        {
            Dziedzina d = dziedzinaService.getDziedzina(addBook.getCategory());
            k.setDziedzina(d);
        }
        if(!(addBook.getTitle().equals("")))
        {
            k.setTytul(addBook.getTitle());
        }
        if(!(addBook.getWydawnictwo().equals("")))
        {
            k.setWydawnictwo(addBook.getWydawnictwo());
        }

        ksiazkaService.saveKsiazka(k);

        return "redirect:/books/bookList?page=0";
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/books/removeAutor")
    @Transactional
    public String removeAutor(@RequestParam("bookId") int bookid,@RequestParam("autorId") long id)
    {

        Autor autor = autorService.getAutor((int)id);
        Ksiazka k = ksiazkaService.getKsiazkaById(bookid);
        k.deleteAutor(autor);
        ksiazkaService.saveKsiazka(k);
        return "redirect:/books/updateBookForm?bookId="+ bookid;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/books/deleteBook")
    public String removeBook(@RequestParam("bookId") int bookid)
    {
        Ksiazka k = ksiazkaService.getKsiazkaById(bookid);
        ksiazkaService.delete(k);
        return "redirect:/books/bookList?page=0";
    }

}
