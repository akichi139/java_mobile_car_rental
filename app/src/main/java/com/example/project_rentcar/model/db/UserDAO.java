package com.example.project_rentcar.model.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.project_rentcar.model.account.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM User")
    abstract List<User> getAllUser();

    @Query("SELECT * FROM User WHERE username = :username")
    int isDataExist(String userName);

    @Insert
    abstract void insertUser(User... users);

    @Delete
    abstract void delete(User user);
}
