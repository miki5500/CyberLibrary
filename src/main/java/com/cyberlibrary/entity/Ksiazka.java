package com.cyberlibrary.entity;

import com.cyberlibrary.entity.userEntity.User;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ksiazki")
public class Ksiazka {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "tytul")
    private String tytul;

    @Column(name = "wydawnictwo")
    private String wydawnictwo;

    @Column(name = "dostepna")
    private int dostepna;

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "dziedzina_id")
    private Dziedzina dziedzina;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "autorzy_do_ksiazki",
            joinColumns = @JoinColumn(name = "ksiazka_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id"))
    private Set<Autor> autorzy;

    @ManyToMany
    @JoinTable(
            name="ksiazka_do_user",
            joinColumns = @JoinColumn(name = "ksiazka_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> borrowedBy;

    public Ksiazka() {
    }

    public Ksiazka(int id, String tytul, String wydawnictwo, int dostepna, Dziedzina dziedzina) {
        this.id = id;
        this.tytul = tytul;
        this.wydawnictwo = wydawnictwo;
        this.dostepna = dostepna;
        this.dziedzina = dziedzina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String nazwa) {
        this.tytul = nazwa;
    }

    public String getWydawnictwo() {
        return wydawnictwo;
    }

    public void setWydawnictwo(String wydawnictwo) {
        this.wydawnictwo = wydawnictwo;
    }

    public int getDostepna() {
        return dostepna;
    }

    public void setDostepna(int dostepna) {
        this.dostepna = dostepna;
    }

    public Dziedzina getDziedzina() {
        return dziedzina;
    }

    public void setDziedzina(Dziedzina dziedzina) {
        this.dziedzina = dziedzina;
    }

    public Set<Autor> getAutorzy() {
        return autorzy;
    }

    public void setAutorzy(Set<Autor> autorzy) {
        this.autorzy = autorzy;
    }

    public void addAutor(Autor autor)
    {
        if(autorzy == null)
            autorzy = new HashSet<>();
        autorzy.add(autor);
    }

    public void setBorrowedBy(User user)
    {
        borrowedBy = new HashSet<>();
        borrowedBy.add(user);
    }
    public Set<User> getBorrowedBy()
    {
        return borrowedBy;
    }

    public void returnBook()
    {
        dostepna = 1;
        borrowedBy = null;
    }

    @Override
    public String toString()
    {
        return "Książka{ "+
                "id= " + this.id +
                " tytuł= " + this.tytul +
                " wydawnictwo= " + this.wydawnictwo +
                " dziedzina= " + this.dziedzina.getNazwa();

    }

    public void deleteAutor(Autor autor) {
        autorzy.remove(autor);
    }
}
