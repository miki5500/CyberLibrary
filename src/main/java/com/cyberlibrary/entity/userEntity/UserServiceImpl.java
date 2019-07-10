package com.cyberlibrary.entity.userEntity;

import com.cyberlibrary.helpers.PageOfUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    @Transactional
    public List<User> getAllUserList() {
        return userDao.getAllUserList();
    }

    @Override
    @Transactional
    public User getUserByEmail(String mail) {
        return userDao.getUserByEmail(mail);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role r = roleDao.findByRole("ROLE_USER");
        Set<Role> rr = new HashSet<>();
        rr.add(r);
        user.setRoles(rr);
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user)
    {
        userDao.saveUser(user);
    }

    @Override
    @Transactional
    public PageOfUsers getUsersPage(int first) {
        return userDao.getUserPage(first);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    @Transactional
    public void updatePassword(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
    }
}
