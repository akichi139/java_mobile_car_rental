package com.example.project_rentcar.controller;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_rentcar.DBHelper;
import com.example.project_rentcar.MainActivity;
import com.example.project_rentcar.R;

public class AddRentCar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.add_rent_car);

        String username = getIntent().getStringExtra("user");

        TextView account = (TextView)findViewById(R.id.userView);
        account.setText(username);

        final EditText cid = findViewById(R.id.id);
        final EditText brand = findViewById(R.id.brand);
        final EditText engine = findViewById(R.id.engine);
        final EditText type = findViewById(R.id.type);
        final EditText gear = findViewById(R.id.gear);
        final EditText rate = findViewById(R.id.rate);
        final EditText location = findViewById(R.id.location);
        final EditText seat = findViewById(R.id.seat);
        DBHelper DB = new DBHelper(this);

        Button save = findViewById(R.id.button);
        Button logout = findViewById(R.id.logoutBTN);
        ImageView logo = findViewById(R.id.imageView3);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = cid.getText().toString();
                String cBrand = brand.getText().toString();
                String cType = type.getText().toString();
                String cSeat = seat.getText().toString();
                String cGear = gear.getText().toString();
                String cEngine = engine.getText().toString();
                String cOwner = username;
                String cStatus = "empty";
                String cRate = rate.getText().toString();
                String cLocation = location.getText().toString();

                if (id.equals("") /*|| cBrand.equals("") || cType.equals("") || cSeat.equals("") || cGear.equals("") || cEngine.equals("") || cRate.equals("") || cLocation.equals("")*/)
                {
                    Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkID = DB.checkID(id);
                    if (checkID==false){
                        Boolean insert = DB.insertCar(id,cBrand,cType,cSeat,cGear,cEngine,cOwner,cStatus,cRate,cLocation);
                        if (insert==true){
                            Toast.makeText(getApplicationContext(), "Car has been added", Toast.LENGTH_SHORT).show();
                            Log.d("test",insert.toString());
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            intent.putExtra("user", username);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "add car error", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "ID already exists", Toast.LENGTH_SHORT).show();
                    }
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
                intent.putExtra("user", username);
                startActivity(intent);
            }
        });
    }
}

