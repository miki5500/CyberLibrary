package com.cyberlibrary.services;

import com.cyberlibrary.entity.Autor;
import com.cyberlibrary.helpers.PageOfAutors;

import java.util.List;

public interface AutorService {

    List<Autor> getAutors();
    Autor getAutor(int id);
    void saveAutor(Autor autor);
    void deleteAutor(int id);

    Autor getAutorByName(String imie, String nazwisko);

    PageOfAutors getAutorPage(int i);
}
