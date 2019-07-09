package com.cyberlibrary.entity;

import javax.persistence.*;

@Entity
@Table(name = "dziedzina")
public class Dziedzina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nazwa")
    private String nazwa;


    public Dziedzina() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString()
    {
        return ""+this.nazwa;
    }
}
