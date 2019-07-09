package com.cyberlibrary.services;

import com.cyberlibrary.entity.Dziedzina;

import java.util.List;

public interface DziedzinaService {

    List<Dziedzina> getListaDziedzin();
    Dziedzina getDziedzina(int id);
    void saveDziedzina(Dziedzina dziedzina);
    void deleteDziedzina(int id);
    Dziedzina getDziedzina(String category);
}
