package com.example.project_rentcar.model.car;

import java.util.ArrayList;

public class CarList {

    private ArrayList<Car> cars;

    public Car setReference(Car car) {
        for(Car car1: cars) {
            if (Integer.valueOf(car1.getID()).equals(car.getID()))
                return car1;
        }
        return null;
    }
}
