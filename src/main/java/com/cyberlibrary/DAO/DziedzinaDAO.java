package com.cyberlibrary.DAO;

import com.cyberlibrary.entity.Dziedzina;

import java.util.List;

public interface DziedzinaDAO {

    List<Dziedzina> getListaDziedzin();
    Dziedzina getDziedzina(int id);
    void saveDziedzina(Dziedzina dziedzina);
    void deleteDziedzina(int id);

    Dziedzina getDziedzina(String category);
}
