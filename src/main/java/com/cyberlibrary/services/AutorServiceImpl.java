package com.cyberlibrary.services;

import com.cyberlibrary.DAO.AutorDAO;
import com.cyberlibrary.entity.Autor;
import com.cyberlibrary.helpers.PageOfAutors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AutorServiceImpl implements AutorService {


    @Autowired
    private AutorDAO autorDAO;

    @Override
    @Transactional
    public List<Autor> getAutors() {
        List<Autor> autors = autorDAO.getAutors();
        return autors;
    }


    @Override
    @Transactional
    public Autor getAutor(int id) {
        Autor autor = autorDAO.getAutor(id);
        return autor;
    }

    @Override
    @Transactional
    public void saveAutor(Autor autor) {
        autorDAO.saveAutor(autor);
    }

    @Override
    @Transactional
    public void deleteAutor(int id) {
        autorDAO.deleteAutor(id);
    }

    @Override
    @Transactional
    public Autor getAutorByName(String imie, String nazwisko) {
        return autorDAO.getAutorByName(imie,nazwisko);
    }

    @Override
    @Transactional
    public PageOfAutors getAutorPage(int i) {
      return  autorDAO.getAutorPage(i);
    }
}
