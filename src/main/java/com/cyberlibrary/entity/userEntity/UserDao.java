package com.cyberlibrary.entity.userEntity;

import com.cyberlibrary.helpers.PageOfUsers;

import java.util.List;

public interface UserDao {


    List<User> getAllUserList();
    User getUserByEmail(String mail);
    User getUserById(int id);
    void saveUser(User user);
    void deleteUser(User user);
    void updatePassword(User user);
    void updateUser(User user);
    PageOfUsers getUserPage(int first);

}
