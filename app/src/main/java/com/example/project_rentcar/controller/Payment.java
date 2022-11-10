package com.example.project_rentcar.controller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_rentcar.DBHelper;
import com.example.project_rentcar.MainActivity;
import com.example.project_rentcar.R;

public class Payment extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.payment);

        DBHelper DB = new DBHelper(this);

        Button purchase = findViewById(R.id.purchaseBTN);
        Button logout = findViewById(R.id.logoutBTN);
        ImageView logo = findViewById(R.id.imageView3);

        String user = getIntent().getStringExtra("user");
        TextView account = (TextView)findViewById(R.id.userView);
        account.setText(user);

        String str = getIntent().getStringExtra("position");
        String day = getIntent().getStringExtra("day");
        String[] split = str.split("\\s+");
//        String id = getIntent().getStringExtra("idCar");
//        String rate = getIntent().getStringExtra("rate");
        TextView textRate = (TextView) findViewById(R.id.ratePrice);
        TextView textDay = (TextView) findViewById(R.id.dayOfRent);
        TextView cid = (TextView) findViewById(R.id.carID);

        String id = split[1];
        String cBrand = split[4];
        String cType = split[7];
        String cSeat = split[10];
        String cGear = split[13];
        String cEngine = split[16];
        String cOwner = split[18];
        String cStatus = "Renting";
        String cRate = split[22];
        String cLocation = split[25];

        cid.setText(split[1]);
        textRate.setText(split[22]);
        Log.d("test","test day" + day);
        Log.d("test","test rate" + split[22]);
        textDay.setText(day);

        Integer total = Integer.valueOf(split[22]) * Integer.valueOf(day);

        TextView textTotal = (TextView) findViewById(R.id.totalText);
        String totalPay = total.toString();
        textTotal.setText(totalPay);

        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean update = DB.updateCars(id,cBrand,cType,cSeat,cGear,cEngine,cOwner,cStatus,cRate,cLocation) ;
                if (update==true){
                    Toast.makeText(getApplicationContext(), "Payment successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "logout successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), loginController.class);
                startActivity(intent);
            }
        });

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }
}
