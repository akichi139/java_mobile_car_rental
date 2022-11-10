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
                Log.d("test", String.valueOf(rentDay.getText()));
                intent.putExtra("rate", split[22]);
                Log.d("test", String.valueOf(rate.getText()));
                intent.putExtra("idCar", split[1]);
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

    }
}
