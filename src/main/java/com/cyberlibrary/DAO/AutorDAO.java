package com.cyberlibrary.DAO;

import com.cyberlibrary.entity.Autor;
import com.cyberlibrary.helpers.PageOfAutors;

import java.util.List;

public interface AutorDAO {

    List<Autor> getAutors();
    Autor getAutor(long id);
    void saveAutor(Autor autor);
    void deleteAutor(long id);
    Autor getAutorByName(String imie, String nazwisko);
    PageOfAutors getAutorPage(int i);
}
