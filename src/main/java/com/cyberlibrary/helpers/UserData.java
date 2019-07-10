package com.cyberlibrary.helpers;

import com.cyberlibrary.entity.Ksiazka;
import com.cyberlibrary.entity.userEntity.Role;

import java.util.Set;

public class UserData {
    private String imie;
    private String nazwisko;
    private String mail;
    private String haslo;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}
