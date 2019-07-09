package com.cyberlibrary.services;

import com.cyberlibrary.DAO.DziedzinaDAO;
import com.cyberlibrary.entity.Dziedzina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DziedzinaServiceImpl implements DziedzinaService {

    @Autowired
    private DziedzinaDAO dziedzinaDAO;

    @Override
    @Transactional
    public List<Dziedzina> getListaDziedzin() {
        List<Dziedzina> listaDziedzin = dziedzinaDAO.getListaDziedzin();
        return listaDziedzin;
    }

    @Override
    @Transactional
    public Dziedzina getDziedzina(int id) {
        Dziedzina dziedzina = dziedzinaDAO.getDziedzina(id);
        return dziedzina;
    }

    @Override
    @Transactional
    public void saveDziedzina(Dziedzina dziedzina) {
        dziedzinaDAO.saveDziedzina(dziedzina);
    }

    @Override
    @Transactional
    public void deleteDziedzina(int id) {
        dziedzinaDAO.deleteDziedzina(id);
    }

    @Override
    @Transactional
    public Dziedzina getDziedzina(String category) {
       return dziedzinaDAO.getDziedzina(category);
    }
}
