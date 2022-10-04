package com.example.project_rentcar.model.car;

import java.io.File;

public class Car {

    private int ID;
    private String name;
    private String brand;
    private String type;
    private String status;
    private String seat;
    private String gear;
    private String baggage;
    private String engine;
    private String owner;
    private String rate;
    private String prLocation;
    private String image;

    public Car(int ID, String name, String brand, String type, String status, String seat, String gear, String baggage, String engine, String owner, String rate, String prLocation, String image) {
        this.ID = ID;
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.status = status;
        this.seat = seat;
        this.gear = gear;
        this.baggage = baggage;
        this.engine = engine;
        this.owner = owner;
        this.rate = rate;
        this.prLocation = prLocation;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public String getSeat() {
        return seat;
    }

    public String getGear() {
        return gear;
    }

    public String getBaggage() {
        return baggage;
    }

    public String getEngine() {
        return engine;
    }

    public String getOwner() {
        return owner;
    }

    public String getRate() {
        return rate;
    }

    public String getPrLocation() {
        return prLocation;
    }

    public int getID() {
        return ID;
    }

    public String getImage() {
        return image;
    }

    public String getPicturePath() {
        File file = new File(System.getProperty("user.dir") + File.separator + "productimages" + File.separator + image);
        return file.toURI().toString();
    }
}
