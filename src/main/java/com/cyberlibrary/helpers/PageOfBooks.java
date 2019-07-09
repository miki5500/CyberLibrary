package com.cyberlibrary.helpers;

import com.cyberlibrary.entity.Ksiazka;

import java.util.List;

public class PageOfBooks {

    private  List<Ksiazka> ksiazkaList;

    private long countOfPages;

    public PageOfBooks() {
    }

    public List<Ksiazka> getKsiazkaList() {
        return ksiazkaList;
    }

    public void setKsiazkaList(List<Ksiazka> ksiazkaList) {
        this.ksiazkaList = ksiazkaList;
    }

    public long getCountOfPages() {
        return countOfPages;
    }

    public void setCountOfPages(long countOfPages) {


        this.countOfPages = countOfPages/8;
    }
}
