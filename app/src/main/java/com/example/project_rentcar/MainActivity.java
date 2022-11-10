package com.example.project_rentcar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project_rentcar.controller.AddRentCar;
import com.example.project_rentcar.controller.informationController;
import com.example.project_rentcar.controller.loginController;
import com.example.project_rentcar.model.car.Car;
import com.example.project_rentcar.model.car.CarList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CarList carList;
    DBHelper myDB;

    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String username = getIntent().getStringExtra("user");

        user = username;

        TextView account = (TextView)findViewById(R.id.userView);
        account.setText(user);

        ListView listView = (ListView) findViewById(R.id.listView);
        Button addCar = (Button)findViewById(R.id.addNewCar);
        Button logout = (Button)findViewById(R.id.logoutBTN);
        myDB = new DBHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.viewCars();
        if(data.getCount() == 0){
            Toast.makeText(this, "There are no contents in this list!",Toast.LENGTH_LONG).show();
        }else {
            while (data.moveToNext()) {

                theList.add("ID:" + "   " + data.getString(0) + "                             "
                        + "Car Brand:" + "  " + data.getString(1) + "                              "
                        + "Car Type:" + "  " + data.getString(2) + "                              "
                        + "Total Seats:" + "  " + data.getString(3) + "                              "
                        + "Car Gear:" + "  " + data.getString(4) + "                              "
                        + "Car Engine:" + "  " + data.getString(5) + "                              "
                        + "Owner:" + "  " + data.getString(6) + "                              "
                        + "Status:" + "  " + data.getString(7) + "                              "
                        + "Rate:" + "  " + data.getString(8) + "                              "
                        + "Pickup Location:" + "  " + data.getString(9));
                theList.add("");
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(listAdapter);
//
//                Log.d("test", String.valueOf(listAdapter));

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0) {
                            String str = (String) theList.get(position);
                            Log.d("test", str);
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            intent.putExtra("position", str);
                            intent.putExtra("user", user);
                            startActivity(intent);
                        }
                        if (position == 2) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            intent.putExtra("position", position);
                            intent.putExtra("user", user);
                            startActivity(intent);
                        }
                        if (position == 4) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            intent.putExtra("position", position);
                            intent.putExtra("user", user);
                            startActivity(intent);
                        }
                        if (position == 6) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            intent.putExtra("position", position);
                            intent.putExtra("user", user);
                            startActivity(intent);
                        }
                        if (position == 8) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            intent.putExtra("position", position);
                            intent.putExtra("user", user);
                            startActivity(intent);
                        }
                        if (position == 10) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            intent.putExtra("position", position);
                            intent.putExtra("user", user);
                            startActivity(intent);
                        }
                        if (position == 12) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            intent.putExtra("position", position);
                            intent.putExtra("user", user);
                            startActivity(intent);
                        }
                        if (position == 14) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            intent.putExtra("position", position);
                            intent.putExtra("user", user);
                            startActivity(intent);
                        }
                        if (position == 16) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            intent.putExtra("position", position);
                            intent.putExtra("user", user);
                            startActivity(intent);
                        }
                        if (position == 18) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            intent.putExtra("position", position);
                            intent.putExtra("user", user);
                            startActivity(intent);
                        }
                        if (position == 20) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            intent.putExtra("position", position);
                            intent.putExtra("user", user);
                            startActivity(intent);
                        }
                    }
                });
            }
        }
        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddRentCar.class);
                intent.putExtra("user", user);
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
    }
}