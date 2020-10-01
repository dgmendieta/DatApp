package com.diegosuarez.datapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

import javax.net.ssl.SNIServerName;

public class MainActivity extends AppCompatActivity {
    //Global Variables
    DatePickerDialog picker;
    EditText eText;
    Button nextBtn;
    EditText data_name;
    EditText data_date;
    EditText data_phone;
    EditText data_email;
    EditText data_description;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Set Date Picker
        eText=(EditText) findViewById(R.id.inputDate);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        final Calendar cldr = Calendar.getInstance();
                        int day = cldr.get(Calendar.DAY_OF_MONTH);
                        int month = cldr.get(Calendar.MONTH);
                        int year = cldr.get(Calendar.YEAR);
                        // date picker dialog
                        picker = new DatePickerDialog(MainActivity.this,
                                new DatePickerDialog.OnDateSetListener() {
                                    @Override
                                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                        eText.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                                    }
                                }, year, month, day);
                        picker.show();
                        }
                });
        // Data Confirm Button Listener
        nextBtn=(Button) findViewById(R.id.next_button);
        nextBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        data_name = findViewById(R.id.inputName);
                        data_date = findViewById(R.id.inputDate);
                        data_phone = findViewById(R.id.inputPhone);
                        data_email = findViewById(R.id.inputEmail);
                        data_description = findViewById(R.id.inputDescription);
                        //Catch data from Edit Texts
                        String name = data_name.getText().toString();
                        String birthDate = data_date.getText().toString();
                        String phone = data_phone.getText().toString();
                        String email = data_email.getText().toString();
                        String description = data_description.getText().toString();
                        //Instantiate an Object
                        ContactData data = new ContactData(name,birthDate,phone,email,description);
                        //Create Intent and Send data
                        Intent intent = new Intent(MainActivity.this, DataConfirmActivity.class);
                        intent.putExtra("name", data.getName());
                        intent.putExtra("date", data.getBirthDate());
                        intent.putExtra("phone", data.getPhone());
                        intent.putExtra("email", data.getEmail());
                        intent.putExtra("description", data.getDescription());
                        startActivity(intent);

            }
        });//end of onClickListener




    }//end of onCreate

}//end of MainActivity