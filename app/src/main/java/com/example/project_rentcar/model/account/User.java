package com.example.project_rentcar.model.account;

public class User {
    private String username;
    private String password;
    private String phoneNum;

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public User(String username, String password, String phoneNum) {
        this.username = username;
        this.password = password;
        this.phoneNum = phoneNum;
    }
}
