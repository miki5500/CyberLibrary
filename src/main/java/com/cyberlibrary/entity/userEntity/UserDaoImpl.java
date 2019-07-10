package com.cyberlibrary.entity.userEntity;

import com.cyberlibrary.helpers.PageOfUsers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<User> getAllUserList() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query = currentSession.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User getUserByEmail(String mail) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query = currentSession.createQuery("from User where email=:mail",User.class);
        query.setParameter("mail",mail);
        User u;
        try {
            u = query.getSingleResult();
        }catch (NoResultException r)
        {
            u = new User();
        }
        return u;
    }

    @Override
    public User getUserById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> query = currentSession.createQuery("from User where id=:idU",User.class);
        query.setParameter("idU",id);
        return query.getSingleResult();
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public void deleteUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);

    }

    @Override
    public PageOfUsers getUserPage(int first) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(*) from User");
        Query<User> queryK = session.createQuery("from User",User.class);
        queryK.setFirstResult(first);
        queryK.setMaxResults(8);

        return new PageOfUsers(queryK.getResultList(),(long)query.getSingleResult());
    }
}
