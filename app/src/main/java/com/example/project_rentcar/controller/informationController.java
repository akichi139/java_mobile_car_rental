package com.example.project_rentcar.controller;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_rentcar.R;
import com.example.project_rentcar.model.car.Car;
import com.example.project_rentcar.model.car.CarList;

public class informationController extends AppCompatActivity {

    private CarList cars;
    private Car car;
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        Bundle b = getIntent().getExtras();
        String username = ""; // or other values
        if(b != null)
            username = b.getString("key2");

        Bundle a = getIntent().getExtras();
        int value = -1; // or other values
        if(a != null)
            value = b.getInt("key");

        user = username;

        TextView account = (TextView)findViewById(R.id.userView);
        account.setText(user);

        TextView id = (TextView) findViewById(R.id.idText);
        TextView brand = (TextView) findViewById(R.id.brandText);
        TextView type = (TextView) findViewById(R.id.typeText);
        TextView seat = (TextView) findViewById(R.id.seatText);
        TextView gear = (TextView) findViewById(R.id.gearText);
        TextView baggage = (TextView) findViewById(R.id.bagText);
        TextView engine = (TextView) findViewById(R.id.engineText);
        TextView owner = (TextView) findViewById(R.id.ownerText);
        TextView status = (TextView) findViewById(R.id.statusText);
        TextView rate = (TextView) findViewById(R.id.rateText);
        TextView location = (TextView) findViewById(R.id.locationText);
//        ImageView imageView = (ImageView) findViewById(R.id.imageView4);

//        car = cars.setReference(car);
        id.setText(car.getName());
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
//        imageView.setImageResource(R.drawable.logo);



    }
}
