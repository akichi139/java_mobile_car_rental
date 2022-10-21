package com.example.project_rentcar.model.car;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Car {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "product_name")
    public String name;

    @ColumnInfo(name = "brand_name")
    public String brand;

    @ColumnInfo(name = "type")
    public String type;

    @ColumnInfo(name = "status")
    public String status;

    @ColumnInfo(name = "seat")
    public String seat;

    @ColumnInfo(name = "gear")
    public String gear;

    @ColumnInfo(name = "baggage")
    public String baggage;

    @ColumnInfo(name = "engine")
    public String engine;

    @ColumnInfo(name = "owner")
    public String owner;

    @ColumnInfo(name = "rate")
    public String rate;

    @ColumnInfo(name = "pickLocation")
    public String prLocation;

    @ColumnInfo(name = "image_path")
    public String image;

    public int getId() {
        return id;
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

    public String getImage() {
        return image;
    }
}
