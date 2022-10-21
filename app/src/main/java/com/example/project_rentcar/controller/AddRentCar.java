package com.example.project_rentcar.controller;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_rentcar.R;
import com.example.project_rentcar.model.car.Car;
import com.example.project_rentcar.model.db.AppDB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class AddRentCar extends AppCompatActivity {

    int requestCode = 1;
    private File selectedFile;
    private String imageName;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.add_rent_car);

        final Button browse = findViewById(R.id.browseBTN);
        final EditText name = findViewById(R.id.name);
        final EditText baggage = findViewById(R.id.baggage);
        final EditText brand = findViewById(R.id.brand);
        final EditText engine = findViewById(R.id.engine);
        final EditText type = findViewById(R.id.type);
        final EditText gear = findViewById(R.id.gear);
        final EditText rate = findViewById(R.id.rate);
        final EditText location = findViewById(R.id.location);
        final EditText seat = findViewById(R.id.seat);
//        imageView = findViewById(R.id.picview);
        Button save = findViewById(R.id.button);
        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, requestCode);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                BitmapDrawable drawable = (BitmapDrawable) imageView.getDrawable();
//                Bitmap bitmap = drawable.getBitmap();
//
//                File filepath = Environment.getExternalStorageDirectory();
//                File dir = new File(filepath.getAbsolutePath()+"/Demo/");
//                dir.mkdir();
//                File file = new File(dir, System.currentTimeMillis()+".jpg");
//                try {
//                    outputStream = new FileOutputStream(file);
//                }catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//                bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
//                Toast.makeText(getApplicationContext(),"Image Save to Internal",Toast.LENGTH_SHORT).show();
//                try {
//                    outputStream.flush();
//                }catch (IOException e){
//                    e.printStackTrace();
//                }try {
//                    outputStream.close();
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
                if (isDataEmpty(name.toString(),brand.toString(),type.toString(),seat.toString(),gear.toString(),baggage.toString(),engine.toString(),rate.toString(),location.toString())) {
                    handleNoImage();
                    saveNewCar(name.getText().toString(), brand.getText().toString(), type.getText().toString(), seat.getText().toString(), gear.getText().toString(), baggage.getText().toString(), engine.getText().toString(), rate.getText().toString(), location.getText().toString());
                }else {
                    Toast.makeText(getApplicationContext(),"Fill all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private  void  saveNewCar(String cname, String cBrand, String cType, String cSeat, String cGear, String cBaggage, String cEngine, String cRate, String cLocation){
        AppDB db = AppDB.getInstance(this.getApplicationContext());
        Car car = new Car();
        car.name = cname;
        car.brand = cBrand;
        car.type = cType;
        car.seat = cSeat;
        car.gear = cGear;
        car.baggage = cBaggage;
        car.engine = cEngine;
        car.rate = cRate;
        car.prLocation = cLocation;

        db.carsDAO().insertCar(car);
        finish();
    }

    @Override
    public void onActivityResult(int requestCodeF, int resultCodeF, Intent data){
        super.onActivityResult(resultCodeF,resultCodeF,data);
        Uri selectedImage = data.getData();
        String[] filePathColumn = { MediaStore.Images.Media.DATA };

        Cursor cursor = getContentResolver().query(selectedImage,
                filePathColumn, null, null, null);
        cursor.moveToFirst();

        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        cursor.close();

        ImageView imageView = (ImageView) findViewById(R.id.picview);
        imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
    }

    public boolean isDataEmpty(String cname, String cBrand, String cType, String cSeat, String cGear, String cBaggage, String cEngine, String cRate, String cLocation) {
        return !cname.isEmpty() && !cBrand.isEmpty() && !cType.isEmpty() && !cSeat.isEmpty() && !cGear.isEmpty() && !cBaggage.isEmpty() && !cEngine.isEmpty() && !cRate.isEmpty() && !cLocation.isEmpty();
    }

    public void handleNoImage() {
        if(selectedFile == null) {
            selectedFile = new File(System.getProperty("user.dir") + File.separator + "userimages" + File.separator + "no_image.png");
            imageName = "no_image.png";
        }
    }

}

