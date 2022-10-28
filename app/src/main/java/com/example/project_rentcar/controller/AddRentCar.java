package com.example.project_rentcar.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_rentcar.DBHelper;
import com.example.project_rentcar.MainActivity;
import com.example.project_rentcar.R;

import java.io.File;

public class AddRentCar extends AppCompatActivity {

    int requestCode = 1;
    private File selectedFile;
    private String imageName;
    private String user;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.add_rent_car);

        Bundle b = getIntent().getExtras();
        String username = ""; // or other values
        if(b != null)
            username = b.getString("key");

        user = username;

        TextView account = (TextView)findViewById(R.id.userView);
        account.setText(user);

//        final Button browse = findViewById(R.id.browseBTN);
        final EditText cid = findViewById(R.id.id);
        final EditText baggage = findViewById(R.id.baggage);
        final EditText brand = findViewById(R.id.brand);
        final EditText engine = findViewById(R.id.engine);
        final EditText type = findViewById(R.id.type);
        final EditText gear = findViewById(R.id.gear);
        final EditText rate = findViewById(R.id.rate);
        final EditText location = findViewById(R.id.location);
        final EditText seat = findViewById(R.id.seat);
        DBHelper DB = new DBHelper(this);
//        imageView = findViewById(R.id.picview);
        Button save = findViewById(R.id.button);
//        browse.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(
//                        Intent.ACTION_PICK,
//                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//
//                startActivityForResult(i, requestCode);
//            }
//        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = cid.getText().toString();
                String cBrand = brand.getText().toString();
                String cType = type.getText().toString();
                String cSeat = seat.getText().toString();
                String cGear = gear.getText().toString();
                String cBaggage = baggage.getText().toString();
                String cEngine = engine.getText().toString();
                String cRate = rate.getText().toString();
                String cLocation = location.getText().toString();

                if (id.equals("") || cBrand.equals("") || cType.equals("") || cSeat.equals("") || cGear.equals("") || cBaggage.equals("") || cEngine.equals("") || cRate.equals("") || cLocation.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkID = DB.checkID(id);
                    if (checkID==false){
                        Boolean insert = DB.insertCar(id,cBrand,cType,cSeat,cGear,cBaggage,cEngine,user,"empty",cRate,cLocation);
                        if (insert==true){
                            Toast.makeText(getApplicationContext(), "Bus has been added", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "ID already exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

