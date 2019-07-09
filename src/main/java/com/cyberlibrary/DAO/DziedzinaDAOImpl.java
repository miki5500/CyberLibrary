package com.cyberlibrary.DAO;

import com.cyberlibrary.entity.Dziedzina;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DziedzinaDAOImpl implements DziedzinaDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Dziedzina> getListaDziedzin() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Dziedzina> query = currentSession.createQuery("from Dziedzina", Dziedzina.class);
        List<Dziedzina> listaDziedzin = query.getResultList();
        return listaDziedzin;
    }

    @Override
    public Dziedzina getDziedzina(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Dziedzina> query = session.createQuery("SELECT d FROM Dziedzina d where d.id =:idd",Dziedzina.class);
        query.setParameter("idd",id);
        Dziedzina dziedzina = query.getSingleResult();
        return dziedzina;
    }

    @Override
    public void saveDziedzina(Dziedzina dziedzina) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(dziedzina);
    }

    @Override
    public void deleteDziedzina(int id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "DELETE FROM Dziedzina WHERE id =:idd";
        Query query = session.createQuery(hql);
        query.setParameter("idd",id);
        query.executeUpdate();
    }

    @Override
    public Dziedzina getDziedzina(String category) {
        Session session = sessionFactory.getCurrentSession();
        Query<Dziedzina> query = session.createQuery("SELECT d FROM Dziedzina d where d.nazwa =:idd",Dziedzina.class);
        query.setParameter("idd",category);
        Dziedzina dziedzina = query.getSingleResult();
        return dziedzina;
    }
}
