package com.example.project_rentcar.model.transaction;

public class Transaction {
    private double totalPrice;

    public double getCost(double rate,int day){
        totalPrice = rate * day;
        return totalPrice;
    }

}