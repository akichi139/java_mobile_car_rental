package com.example.project_rentcar.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.project_rentcar.DBHelper;
import com.example.project_rentcar.MainActivity;
import com.example.project_rentcar.R;
import com.example.project_rentcar.model.account.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registerController extends AppCompatActivity {

    AwesomeValidation awesomeValidation;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Button button = (Button) findViewById(R.id.confirmBTN);
        EditText usernameText = (EditText) findViewById(R.id.username);
        EditText phoneText = (EditText) findViewById(R.id.phone);
        EditText passwordText = (EditText) findViewById(R.id.password);
        EditText confirmPasswordText = (EditText) findViewById(R.id.confirmPassword);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.username, RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        awesomeValidation.addValidation(this,R.id.phone,"[0][8-9][0-9]{8}$",R.string.invalid_phone);
        awesomeValidation.addValidation(this,R.id.password,".{6,}",R.string.invalid_password);
        awesomeValidation.addValidation(this,R.id.confirmPassword,R.id.password,R.string.invalid_confirm_password);

        DB = new DBHelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                String username = usernameText.getText().toString();
                String phone = phoneText.getText().toString();
                String password = passwordText.getText().toString();
                if (awesomeValidation.validate()) {
                    Boolean checkUser = DB.checkUsername(username);
                    if (checkUser==false){
                        Boolean insert = DB.insertData(username,password,phone);
                        if (insert==true){
                            Toast.makeText(getApplicationContext(), "Registered Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), loginController.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "User Already exists please sign in", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), loginController.class);
                        startActivity(intent);
                    }
                }else
                    Toast.makeText(getApplicationContext(),"Fill all fields!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
