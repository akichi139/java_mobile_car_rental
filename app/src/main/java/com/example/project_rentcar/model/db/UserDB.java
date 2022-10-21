package com.example.project_rentcar.model.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.project_rentcar.model.car.Car;

@Database(entities = {Car.class}, version = 1)
public abstract class UserDB extends RoomDatabase {
    public static UserDAO userDAO() {
        return null;
    }

    private static UserDB INSTANCE;
    public static synchronized UserDB getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),UserDB.class,"USERS").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

}
