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
        List<Ksiazka> ksiazki = ksiazkaDAO.getKsiazki();
        return ksiazki;
    }

    @Override
    @Transactional
    public PageOfBooks getPaginatedList(int first) {
        return ksiazkaDAO.getPaginatedList(first);
    }

    @Override
    @Transactional
    public Ksiazka getKsiazkaById(int id) {
        Ksiazka ksiazki = ksiazkaDAO.getKsiazkaById(id);
        return ksiazki;
    }

    @Override
    @Transactional
    public List<Ksiazka> getKsiazkiByAutor(Autor autor) {
        List<Ksiazka> ksiazki = ksiazkaDAO.getKsiazkiByAutor(autor);
        return ksiazki;
    }

    @Override
    @Transactional
    public List<Ksiazka> getKsiazkiByDziedzina(Dziedzina dziedzina) {
        List<Ksiazka> ksiazki = ksiazkaDAO.getKsiazkiByDziedzina(dziedzina);
        return ksiazki;
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
