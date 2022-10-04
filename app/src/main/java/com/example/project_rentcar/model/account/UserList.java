package com.example.project_rentcar.model.account;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    public boolean isContainByUsername(String username) {
        for(User user: users)
            if(user.getUsername().equals(username))
                return true;
        return false;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
