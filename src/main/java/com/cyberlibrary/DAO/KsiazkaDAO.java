package com.cyberlibrary.DAO;

import com.cyberlibrary.entity.Autor;
import com.cyberlibrary.entity.Dziedzina;
import com.cyberlibrary.entity.Ksiazka;
import com.cyberlibrary.helpers.PageOfBooks;
import com.cyberlibrary.helpers.SearchHelper;

import java.util.List;

public interface KsiazkaDAO {

    List<Ksiazka> getKsiazki();
    PageOfBooks getPaginatedList(int first);
    Ksiazka getKsiazkaById(int id);
    List<Ksiazka> getKsiazkiByAutor(Autor autor);
    List<Ksiazka> getKsiazkiByDziedzina(Dziedzina dziedzina);
    List<Ksiazka> getKsiazkaBySearch(SearchHelper searchHelper);
    void saveKsiazka(Ksiazka ksiazka);
    void delete(Ksiazka ksiazka);
}
