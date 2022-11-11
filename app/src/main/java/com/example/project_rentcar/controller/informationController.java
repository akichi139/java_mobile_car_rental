package com.example.project_rentcar.controller;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Parcelable;
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

public class informationController extends AppCompatActivity {

    DBHelper myDB;
    private String user;
    DBHelper DB = new DBHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information);

        String username = getIntent().getStringExtra("user");
        String str = getIntent().getStringExtra("position");
        String[] split = str.split("\\s+");
        Log.d("test", String.valueOf(split.length));

        user = username;

        TextView account = (TextView)findViewById(R.id.userView);
        account.setText(user);

        EditText rentDay = (EditText) findViewById(R.id.dayForRent);
        Button rent = (Button)findViewById(R.id.rentBtn);
        Button logout = findViewById(R.id.logoutBTN);
        Button rented = (Button)findViewById(R.id.rentedBTN);
        ImageView logo = findViewById(R.id.imageView3);

        TextView id = (TextView) findViewById(R.id.idText);
        TextView brand = (TextView) findViewById(R.id.brandText);
        TextView type = (TextView) findViewById(R.id.typeText);
        TextView seat = (TextView) findViewById(R.id.seatText);
        TextView gear = (TextView) findViewById(R.id.gearText);
        TextView engine = (TextView) findViewById(R.id.engineText);
        TextView owner = (TextView) findViewById(R.id.ownerText);
        TextView status = (TextView) findViewById(R.id.statusText);
        TextView rate = (TextView) findViewById(R.id.rateText);
        TextView location = (TextView) findViewById(R.id.locationText);

        for (int i = 0; i < 25; i++) {
            Log.d("test", i+" value: "+split[i]);
        }

        id.setText(split[1]);
        brand.setText(split[4]);
        type.setText(split[7]);
        seat.setText(split[10]);
        gear.setText(split[13]);
        engine.setText(split[16]);
        owner.setText(split[18]);
        status.setText(split[20]);
        rate.setText(split[22]);
        location.setText(split[25]);

        rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Payment.class);
                intent.putExtra("user", user);
                intent.putExtra("day", String.valueOf(rentDay.getText()));
                intent.putExtra("position",str);
                startActivity(intent);
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

        String cid = split[1];
        String cBrand = split[4];
        String cType = split[7];
        String cSeat = split[10];
        String cGear = split[13];
        String cEngine = split[16];
        String cOwner = split[18];
        String cStatus = "empty";
        String cRate = split[22];
        String cLocation = split[25];

        rented.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean update = DB.updateCars(cid,cBrand,cType,cSeat,cGear,cEngine,cOwner,cStatus,cRate,cLocation) ;
                if (update==true){
                    Toast.makeText(getApplicationContext(), "Status change to empty", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
