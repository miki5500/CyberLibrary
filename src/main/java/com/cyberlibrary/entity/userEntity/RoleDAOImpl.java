package com.cyberlibrary.entity.userEntity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDAOImpl implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Role findByRole(String role1) {

        Session session = sessionFactory.getCurrentSession();

        Query<Role> roleQuery = session.createQuery("from Role where role=:rol",Role.class);
            roleQuery.setParameter("rol",role1);
        Role w = roleQuery.getSingleResult();
        return w;
    }
}
