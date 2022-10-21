package com.example.project_rentcar.model.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.project_rentcar.model.car.Car;

import java.util.List;

@Dao
public interface CarsDAO {
    @Query("SELECT * FROM Car")
    abstract List<Car> getAllCars();

    @Insert
    abstract void insertCar(Car... cars);

    @Delete
    abstract void delete(Car car);
}
