package com.cyberlibrary.helpers;

import com.cyberlibrary.entity.Autor;

import java.util.List;

public class PageOfAutors {

    private List<Autor> autorList;

    private long nrstron;

    public PageOfAutors(List<Autor> autorList, long nrstron) {
        this.autorList = autorList;
        this.nrstron = nrstron;
    }

    public List<Autor> getAutorList() {
        return autorList;
    }

    public void setAutorList(List<Autor> autorList) {
        this.autorList = autorList;
    }

    public long getNrstron() {
        return nrstron;
    }

    public void setNrstron(long nrstron) {
        this.nrstron = nrstron;
    }
}
