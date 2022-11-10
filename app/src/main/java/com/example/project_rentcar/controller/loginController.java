package com.example.project_rentcar.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_rentcar.DBHelper;
import com.example.project_rentcar.MainActivity;
import com.example.project_rentcar.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class loginController extends AppCompatActivity {

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        EditText username = findViewById(R.id.Luser);
        EditText password = findViewById(R.id.Lpwd);
        Button login = findViewById(R.id.loginBTN);
        Button signup = findViewById(R.id.registerBTN);
        DBHelper DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(loginController.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkUserPwd = DB.checkUsernamePassword(user, pass);
                    if (checkUserPwd==true){
                        Toast.makeText(loginController.this, "LogIn Successful", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("user",user);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(loginController.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), registerController.class);
                startActivity(intent);
            }
        });


    }
}
