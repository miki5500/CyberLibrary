package com.cyberlibrary.helpers;

import com.cyberlibrary.entity.userEntity.User;

import java.util.List;

public class PageOfUsers {

    private List<User> usersPage;

    private long nrStron;

    public PageOfUsers(List<User> usersPage, long nrStron) {
        this.usersPage = usersPage;
        this.nrStron = nrStron;
    }

    public List<User> getUsersPage() {
        return usersPage;
    }

    public void setUsersPage(List<User> usersPage) {
        this.usersPage = usersPage;
    }

    public long getNrStron() {
        return nrStron;
    }

    public void setNrStron(long nrStron) {
        this.nrStron = nrStron;
    }
}
