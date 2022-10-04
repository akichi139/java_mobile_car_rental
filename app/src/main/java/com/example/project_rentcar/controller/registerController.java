package com.example.project_rentcar.controller;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.project_rentcar.R;
import com.example.project_rentcar.model.account.User;

public class registerController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

//        users = (UserList) FXRouter.getData();

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Button button = (Button) findViewById(R.id.confirmBTN);
        EditText usernameText = (EditText) findViewById(R.id.username);
        EditText phoneText = (EditText) findViewById(R.id.phone);
        EditText passwordText = (EditText) findViewById(R.id.password);
        EditText confirmPasswordText = (EditText) findViewById(R.id.confirmPassword);

        imageView.setBackgroundResource(R.drawable.logo);
        button.setOnClickListener(new View.OnClickListener() {
            String username = usernameText.toString();
            String phone = phoneText.toString();
            String password = passwordText.toString();
            String confirmPassword = confirmPasswordText.toString();
            @Override
            public void onClick(View view)  {
                if (isDataEmpty(username, phone, password, confirmPassword)) {
//                    if(!users.isContainByUsername(usernameText)) {
                        if (passwordText.equals(confirmPasswordText)) {
                            register(username, password, phone);
                        }else
                            alert("กรุณาใส่รหัสผ่านให้ตรงกัน");
//                    }else
//                        alert("ชื่อผู้ใช้นี้ถูกใช้งานแล้ว");
                }else
                    alert("กรุณาใส่ข้อมูลให้ครบถ้วน");
            }
        });
    }

    public void register(String username, String password, String phone) {
        User user = new User(username, password, phone);
//        users.addUser(user);
//
//        try {
//            userListDataSource.writeData(users);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    private void alert(String massage) {
        AlertDialog dlg = new AlertDialog.Builder(registerController.this).setTitle("Message").setMessage(massage).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).create();dlg.show();
    }

    public Boolean isDataEmpty(String username, String phone, String password, String confirmPassword){
        return !username.isEmpty() && !phone.isEmpty() && !password.isEmpty() && !confirmPassword.isEmpty();
    }
}
