package com.cyberlibrary.DAO;

import com.cyberlibrary.entity.Autor;
import com.cyberlibrary.helpers.PageOfAutors;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AutorDAOImpl implements AutorDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Autor> getAutors() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Autor> query = currentSession.createQuery("from Autor", Autor.class);
        List<Autor> autors = query.getResultList();
        return autors;
    }

    @Override
    public Autor getAutor(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Autor> query = currentSession.createQuery("SELECT a FROM Autor a WHERE id =:ida", Autor.class);
        query.setParameter("ida",id);
        Autor autor = query.getSingleResult();
        return autor;
    }

    @Override
    public void saveAutor(Autor autor) {
        Session session = sessionFactory.getCurrentSession();
        session.save(autor);
    }

    @Override
    public void deleteAutor(long id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "DELETE FROM Autor WHERE id =:ida";
        Query query = session.createQuery(hql);
        query.setParameter("ida",id);
        query.executeUpdate();
    }

    @Override
    public Autor getAutorByName(String imie, String nazwisko) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "SELECT a FROM Autor a WHERE imie=:im AND nazwisko=:nazw";
        Query<Autor> query = session.createQuery(hql,Autor.class);
        query.setParameter("im",imie);
        query.setParameter("nazw",nazwisko);
        List<Autor> a = query.getResultList();

        if(a.isEmpty())
        {
          return null;
        }else{
            return a.get(0);
        }

    }

    @Override
    public PageOfAutors getAutorPage(int i) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from Autor");
        Query<Autor> queryK = session.createQuery("from Autor",Autor.class);
        queryK.setFirstResult(i);
        queryK.setMaxResults(8);
        PageOfAutors page = new PageOfAutors(queryK.getResultList(),(long)query.getSingleResult());
        return page;
    }
}
