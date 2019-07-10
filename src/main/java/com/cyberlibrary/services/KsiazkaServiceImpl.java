package com.cyberlibrary.services;

import com.cyberlibrary.DAO.KsiazkaDAO;
import com.cyberlibrary.entity.Autor;
import com.cyberlibrary.entity.Dziedzina;
import com.cyberlibrary.entity.Ksiazka;
import com.cyberlibrary.helpers.PageOfBooks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class KsiazkaServiceImpl implements KsiazkaService {

    @Autowired
    private KsiazkaDAO ksiazkaDAO;

    @Override
    @Transactional
    public List<Ksiazka> getKsiazki() {
        return ksiazkaDAO.getKsiazki();
    }

    @Override
    @Transactional
    public PageOfBooks getPaginatedList(int first) {
        return ksiazkaDAO.getPaginatedList(first);
    }

    @Override
    @Transactional
    public PageOfBooks pageOfBorrowed(int first)
    {
        return ksiazkaDAO.getPaginatedBorrowedList(first);
    }

    @Override
    @Transactional
    public Ksiazka getKsiazkaById(int id) {
        return ksiazkaDAO.getKsiazkaById(id);
    }

    @Override
    @Transactional
    public List<Ksiazka> getKsiazkiByAutor(Autor autor) {
        return ksiazkaDAO.getKsiazkiByAutor(autor);
    }

    @Override
    @Transactional
    public List<Ksiazka> getKsiazkiByDziedzina(Dziedzina dziedzina) {
        return ksiazkaDAO.getKsiazkiByDziedzina(dziedzina);
    }

    @Override
    @Transactional
    public void saveKsiazka(Ksiazka ksiazka) {
    ksiazkaDAO.saveKsiazka(ksiazka);
    }

    @Override
    @Transactional
    public void delete(Ksiazka ksiazka) {
        ksiazkaDAO.delete(ksiazka);
    }

}
