package com.cyberlibrary.services;

import com.cyberlibrary.entity.Autor;
import com.cyberlibrary.entity.Dziedzina;
import com.cyberlibrary.entity.Ksiazka;
import com.cyberlibrary.helpers.PageOfBooks;

import java.util.List;

public interface KsiazkaService {

    List<Ksiazka> getKsiazki();
    PageOfBooks getPaginatedList(int first);
    Ksiazka getKsiazkaById(int id);
    List<Ksiazka> getKsiazkiByAutor(Autor autor);
    List<Ksiazka> getKsiazkiByDziedzina(Dziedzina dziedzina);
    void saveKsiazka(Ksiazka ksiazka);
    void delete(Ksiazka ksiazka);
    PageOfBooks pageOfBorrowed(int first);

}
