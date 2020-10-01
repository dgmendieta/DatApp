package com.diegosuarez.datapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;

public class DataConfirmActivity extends AppCompatActivity {
    //Global Variables
    TextView name;
    TextView date;
    TextView phone;
    TextView email;
    TextView description;
    Button backBtn;
    String data_name;
    String data_date;
    String data_phone;
    String data_email;
    String data_description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_confirm);
        //Catch data from intent
        Bundle data = getIntent().getExtras();

        //Identifying data destination
        name = (TextView) findViewById(R.id.name_data);
        date = (TextView) findViewById(R.id.date_data);
        phone = (TextView) findViewById(R.id.phone_data);
        email = (TextView) findViewById(R.id.email_data);
        description = (TextView) findViewById(R.id.description_data);
        //Get data from Bundle
        data_name = data.getString("name");
        data_date = data.getString("date");
        data_phone = data.getString("phone");
        data_email = data.getString("email");
        data_description = data.getString("description");
        //Set text in Text Views
        name.setText(data_name);
        date.setText(data_date);
        phone.setText(data_phone);
        email.setText(data_email);
        description.setText(data_description);
        //Edit data button. Previous screen is onPause so we just need to press Back Button
        //and data is still there.
        backBtn=(Button) findViewById(R.id.dataconfirm_backbtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });

    }
}