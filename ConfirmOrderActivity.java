package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConfirmOrderActivity extends AppCompatActivity {

    private EditText nameEditText, phoneEditText, address1EditText, address2EditText, cityEditText, stateEditText, zipEditText;
    private Button confirmBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        confirmBtn = (Button) findViewById(R.id.confirm);
        nameEditText = (EditText) findViewById(R.id.customer_name);
        phoneEditText = (EditText) findViewById(R.id.customer_phone_no);
        address1EditText = (EditText) findViewById(R.id.shipping_address);
        address2EditText = (EditText) findViewById(R.id.shipping_address2);
        cityEditText = (EditText) findViewById(R.id.shipping_city);
        stateEditText = (EditText) findViewById(R.id.shipping_state);
        zipEditText = (EditText) findViewById (R.id.shipping_zip);


        confirmBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){


                Check();



            }
        });


    }


    private void Check()
    {
        if(TextUtils.isEmpty(nameEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your full name", Toast.LENGTH_SHORT).show();

        }

        else if(TextUtils.isEmpty(phoneEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your phone number", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(address1EditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your street address", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(cityEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your city", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(stateEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your state", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(zipEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your zipcode", Toast.LENGTH_SHORT).show();

        }
        else
        {
            ConfirmOrder();
            Intent intent = new Intent(ConfirmOrderActivity.this, PaymentActivity.class);
            startActivity(intent);
            finish();

        }

    }

    private void ConfirmOrder()
    {
        Toast.makeText(ConfirmOrderActivity.this, "Your shipping address has been added.", Toast.LENGTH_SHORT).show();
    }


}
