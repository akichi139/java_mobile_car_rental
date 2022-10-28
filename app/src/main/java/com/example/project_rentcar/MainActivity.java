package com.example.project_rentcar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
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
import com.example.project_rentcar.model.car.Car;
import com.example.project_rentcar.model.car.CarList;
import com.example.project_rentcar.model.db.AppDB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CarList carList;
    DBHelper myDB;

    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle b = getIntent().getExtras();
        String username = ""; // or other values
        if(b != null)
            username = b.getString("key");

        user = username;

        TextView account = (TextView)findViewById(R.id.userView);
        account.setText(user);

        ListView listView = (ListView) findViewById(R.id.recycleView);
        Button addCar = (Button)findViewById(R.id.addNewCar);
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
                        + "Total Baggage:" + "  " + data.getString(5) + "                              "
                        + "Car Engine:" + "  " + data.getString(6) + "                              "
                        + "Owner:" + "  " + data.getString(7) + "                              "
                        + "Status:" + "  " + data.getString(8) + "                              "
                        + "Rate:" + "  " + data.getString(9) + "                              "
                        + "Pickup Location:" + "  " + data.getString(10));
                theList.add("");
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(listAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            Bundle a = new Bundle();
                            a.putInt("key", position); //Your id
                            b.putString("key2",user);
                            intent.putExtras(a); //Put your id to your next Intent
                            intent.putExtras(b);
                            startActivity(intent);
                            finish();
                        }
                        if (position == 2) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            Bundle a = new Bundle();
                            a.putInt("key", position); //Your id
                            b.putString("key2",user);
                            intent.putExtras(a); //Put your id to your next Intent
                            intent.putExtras(b);
                            startActivity(intent);
                            finish();
                        }
                        if (position == 4) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            Bundle a = new Bundle();
                            a.putInt("key", position); //Your id
                            b.putString("key2",user);
                            intent.putExtras(a); //Put your id to your next Intent
                            intent.putExtras(b);
                            startActivity(intent);
                            finish();
                        }
                        if (position == 6) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            Bundle a = new Bundle();
                            a.putInt("key", position); //Your id
                            b.putString("key2",user);
                            intent.putExtras(a); //Put your id to your next Intent
                            intent.putExtras(b);
                            startActivity(intent);
                            finish();
                        }
                        if (position == 8) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            Bundle a = new Bundle();
                            a.putInt("key", position); //Your id
                            b.putString("key2",user);
                            intent.putExtras(a); //Put your id to your next Intent
                            intent.putExtras(b);
                            startActivity(intent);
                            finish();
                        }
                        if (position == 10) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            Bundle a = new Bundle();
                            a.putInt("key", position); //Your id
                            b.putString("key2",user);
                            intent.putExtras(a); //Put your id to your next Intent
                            intent.putExtras(b);
                            startActivity(intent);
                            finish();
                        }
                        if (position == 12) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            Bundle a = new Bundle();
                            a.putInt("key", position); //Your id
                            b.putString("key2",user);
                            intent.putExtras(a); //Put your id to your next Intent
                            intent.putExtras(b);
                            startActivity(intent);
                            finish();
                        }
                        if (position == 14) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            Bundle a = new Bundle();
                            a.putInt("key", position); //Your id
                            b.putString("key2",user);
                            intent.putExtras(a); //Put your id to your next Intent
                            intent.putExtras(b);
                            startActivity(intent);
                            finish();
                        }
                        if (position == 16) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            Bundle a = new Bundle();
                            a.putInt("key", position); //Your id
                            b.putString("key2",user);
                            intent.putExtras(a); //Put your id to your next Intent
                            intent.putExtras(b);
                            startActivity(intent);
                            finish();
                        }
                        if (position == 18) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            Bundle a = new Bundle();
                            a.putInt("key", position); //Your id
                            b.putString("key2",user);
                            intent.putExtras(a); //Put your id to your next Intent
                            intent.putExtras(b);
                            startActivity(intent);
                            finish();
                        }
                        if (position == 20) {
                            Intent intent = new Intent(view.getContext(), informationController.class);
                            Bundle a = new Bundle();
                            a.putInt("key", position); //Your id
                            b.putString("key2",user);
                            intent.putExtras(a); //Put your id to your next Intent
                            intent.putExtras(b);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
            }
        }
        addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddRentCar.class);
                Bundle b = new Bundle();
                b.putString("key", String.valueOf(user));
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });
    }
}