package com.example.project_rentcar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.project_rentcar.controller.AddRentCar;
import com.example.project_rentcar.model.car.Car;
import com.example.project_rentcar.model.car.CarList;
import com.example.project_rentcar.model.db.AppDB;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private CarList carList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addCars = findViewById(R.id.addNewCar);
        addCars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, AddRentCar.class),100);
            }
        });
        initRecycleView();

        loadCarList();
    }

    private void initRecycleView(){
        RecyclerView recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        carList = new CarList(this);
        recyclerView.setAdapter(carList);
    }

    private void loadCarList(){
        AppDB db = AppDB.getInstance(this.getApplicationContext());
        List<Car> cars = db.carsDAO().getAllCars();
        carList.setCarList(cars);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        if(requestCode == 100){
            loadCarList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}