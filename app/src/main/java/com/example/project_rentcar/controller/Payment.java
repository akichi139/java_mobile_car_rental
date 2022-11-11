package com.example.project_rentcar.controller;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project_rentcar.A;
import com.example.project_rentcar.DBHelper;
import com.example.project_rentcar.MainActivity;
import com.example.project_rentcar.R;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Payment extends AppCompatActivity {

    A a;
    Context context = this;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.payment);

        TextView rentAmount = findViewById(R.id.rentAmount);

        Web3j web3 = Web3j.build(new HttpService("https://goerli.infura.io/v3/27bfa977ee9340ed80f98f444b417880"));
        Credentials credentials = Credentials.create("e5929058a97b2b050b864c62c1b000d5793a90f90ba6a392ea49b5cd4a99e91a");
        ContractGasProvider contractGasProvider = new DefaultGasProvider();
        a = A.load("0x420ed9D856Aa3860F87A9bec4d1BE5d7bEBEa458", web3, credentials, contractGasProvider);

        a.getData().flowable().subscribeOn(Schedulers.io()).subscribe(new Consumer<BigInteger>() {
            @Override
            public void accept(BigInteger bigInteger) throws Exception {
                Log.i("vac", "accept: " + bigInteger);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rentAmount.setText(String.valueOf(bigInteger));
                    }
                });
            }
        });

        DBHelper DB = new DBHelper(this);

        Button purchase = findViewById(R.id.purchaseBTN);
        Button logout = findViewById(R.id.logoutBTN);
        ImageView logo = findViewById(R.id.imageView3);

        String user = getIntent().getStringExtra("user");
        TextView account = (TextView)findViewById(R.id.userView);
        account.setText(user);

        String str = getIntent().getStringExtra("position");
        String day = getIntent().getStringExtra("day");
        String[] split = str.split("\\s+");
//        String id = getIntent().getStringExtra("idCar");
//        String rate = getIntent().getStringExtra("rate");
        TextView textRate = (TextView) findViewById(R.id.ratePrice);
        TextView textDay = (TextView) findViewById(R.id.dayOfRent);
        TextView cid = (TextView) findViewById(R.id.carID);

        String id = split[1];
        String cBrand = split[4];
        String cType = split[7];
        String cSeat = split[10];
        String cGear = split[13];
        String cEngine = split[16];
        String cOwner = split[18];
        String cStatus = "Renting";
        String cRate = split[22];
        String cLocation = split[25];

        cid.setText(split[1]);
        textRate.setText(split[22]);
        Log.d("test","test day" + day);
        Log.d("test","test rate" + split[22]);
        textDay.setText(day);

        Integer total = Integer.valueOf(split[22]) * Integer.valueOf(day);

        TextView textTotal = (TextView) findViewById(R.id.totalText);
        String totalPay = total.toString();
        textTotal.setText(totalPay);

        purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog = new ProgressDialog(context);

                progressDialog.setTitle("Connect to blockchain");
                progressDialog.setMessage("Please wait...");
                progressDialog.show();

                a.store(new BigInteger(day)).flowable().subscribeOn(Schedulers.io()).subscribe(new Consumer<TransactionReceipt>() {
                    @Override
                    public void accept(TransactionReceipt transactionReceipt) throws Exception {
                        Log.i("vac", "accept: ");
                        a.getData().flowable().subscribeOn(Schedulers.io()).subscribe(new Consumer<BigInteger>() {
                            @Override
                            public void accept(BigInteger bigInteger) throws Exception {
                                Log.i("vac", "accept: " + bigInteger);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        rentAmount.setText(String.valueOf(bigInteger));
                                    }
                                });
                            }
                        });
                        progressDialog.dismiss();
                    }
                });

                Boolean update = DB.updateCars(id,cBrand,cType,cSeat,cGear,cEngine,cOwner,cStatus,cRate,cLocation) ;
                if (update==true){
                    Toast.makeText(getApplicationContext(), "Payment successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("user", user);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                }
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
