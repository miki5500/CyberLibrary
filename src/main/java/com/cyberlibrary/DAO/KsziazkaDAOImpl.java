package com.cyberlibrary.DAO;

import com.cyberlibrary.entity.Autor;
import com.cyberlibrary.entity.Dziedzina;
import com.cyberlibrary.entity.Ksiazka;
import com.cyberlibrary.helpers.PageOfBooks;
import com.cyberlibrary.helpers.SearchHelper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class KsziazkaDAOImpl implements KsiazkaDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Ksiazka> getKsiazki() {
        Session session = sessionFactory.getCurrentSession();
        Query<Ksiazka> query = session.createQuery("from Ksiazka",Ksiazka.class);
        List<Ksiazka> ksiazki = query.getResultList();
        return ksiazki;
    }

    public PageOfBooks getPaginatedList(int first)
    {   PageOfBooks pageOfBooks = new PageOfBooks();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from Ksiazka");
        Query<Ksiazka> queryK = session.createQuery("from Ksiazka",Ksiazka.class);
        queryK.setFirstResult(first);
        queryK.setMaxResults(8);
        pageOfBooks.setCountOfPages((long)query.getSingleResult());
        pageOfBooks.setKsiazkaList(queryK.getResultList());
        return pageOfBooks;
    }


    @Override
    public Ksiazka getKsiazkaById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Ksiazka> query = session.createQuery("from Ksiazka where id =:idk",Ksiazka.class);
        query.setParameter("idk",id);
        Ksiazka ksiazki = query.getSingleResult();
        return ksiazki;
    }

    @Override
    public List<Ksiazka> getKsiazkiByAutor(Autor autor) {
        Session session = sessionFactory.getCurrentSession();
        Query<Ksiazka> query = session.createQuery("select k from Ksiazka k where k.autor.id =:ida",Ksiazka.class);
        query.setParameter("ida",autor.getId());
        List<Ksiazka> ksiazki = query.getResultList();
        return ksiazki;
    }



    @Override
    public List<Ksiazka> getKsiazkiByDziedzina(Dziedzina dziedzina) {
        Session session = sessionFactory.getCurrentSession();
        Query<Ksiazka> query = session.createQuery("select k from Ksiazka k where k.dziedzina.id =:idd",Ksiazka.class);
        query.setParameter("idd",dziedzina.getId());
       List<Ksiazka> ksiazki = query.getResultList();
        return ksiazki;
    }

    @Override
    public List<Ksiazka> getKsiazkaBySearch(SearchHelper searchHelper) {
        return null;
    }

    @Override
    public void saveKsiazka(Ksiazka ksiazka) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(ksiazka);
    }

    @Override
    public void delete(Ksiazka ksiazka) {
        Session session = sessionFactory.getCurrentSession();
        session.delete( ksiazka);
    }
}
