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

        String rate = getIntent().getStringExtra("rate");
        String day = getIntent().getStringExtra("day");
        String id = getIntent().getStringExtra("idCar");
        TextView textRate = (TextView) findViewById(R.id.ratePrice);
        TextView textDay = (TextView) findViewById(R.id.dayOfRent);
        TextView cid = (TextView) findViewById(R.id.carID);
        cid.setText(id);
        textRate.setText(rate);
        Log.d("test","test day" + day);
        Log.d("test","test rate" + rate);
        textDay.setText(day);

        Integer total = Integer.valueOf(rate) * Integer.valueOf(day);

        TextView textTotal = (TextView) findViewById(R.id.totalText);
        String totalPay = total.toString();
        textTotal.setText(totalPay);

        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Boolean update = DB.updateCar(id) ;
//                if (update==true){
//                    Toast.makeText(getApplicationContext(), "Payment successful", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("user", user);
                startActivity(intent);
//                }else{
//                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
//                }
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
