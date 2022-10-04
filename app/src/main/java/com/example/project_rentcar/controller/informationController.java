package com.example.project_rentcar.controller;

import android.media.Image;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_rentcar.R;
import com.example.project_rentcar.model.car.Car;
import com.example.project_rentcar.model.car.CarList;

public class informationController extends AppCompatActivity {

    private CarList cars;
    private Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        TextView name = (TextView) findViewById(R.id.nameText);
        TextView brand = (TextView) findViewById(R.id.nameText);
        TextView type = (TextView) findViewById(R.id.nameText);
        TextView status = (TextView) findViewById(R.id.nameText);
        TextView seat = (TextView) findViewById(R.id.nameText);
        TextView gear = (TextView) findViewById(R.id.nameText);
        TextView baggage = (TextView) findViewById(R.id.nameText);
        TextView engine = (TextView) findViewById(R.id.nameText);
        TextView owner = (TextView) findViewById(R.id.nameText);
        TextView rate = (TextView) findViewById(R.id.nameText);
        TextView location = (TextView) findViewById(R.id.nameText);
        ImageView imageView = (ImageView) findViewById(R.id.imageView4);

        car = cars.setReference(car);
        name.setText(car.getName());
        brand.setText(car.getBrand());
        type.setText(car.getType());
        status.setText(car.getStatus());
        seat.setText(car.getSeat());
        gear.setText(car.getGear());
        baggage.setText(car.getBaggage());
        engine.setText(car.getEngine());
        owner.setText(car.getOwner());
        rate.setText(car.getRate());
        location.setText(car.getPrLocation());
        imageView.setImageResource(R.drawable.logo);

    }
}
