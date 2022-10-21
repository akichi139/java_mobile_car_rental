package com.example.project_rentcar.model.db;

import static java.time.chrono.IsoChronology.INSTANCE;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.project_rentcar.model.car.Car;

@Database(entities = {Car.class}, version = 1)
public abstract class AppDB extends RoomDatabase{
    public abstract CarsDAO carsDAO();
    private static AppDB INSTANCE;
    public static AppDB getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDB.class,"CAR").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

}
