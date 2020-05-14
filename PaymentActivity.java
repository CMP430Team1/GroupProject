package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    private EditText cardnameEditText, cardnumEditText, expdateEditText, cvvnumEditText;
    private Button orderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        orderBtn = (Button) findViewById(R.id.order);
        cardnameEditText = (EditText) findViewById(R.id.cardholder_name);
        cardnumEditText = (EditText) findViewById(R.id.card_number);
        expdateEditText = (EditText) findViewById(R.id.Exp_date);
        cvvnumEditText = (EditText) findViewById(R.id.CVV_number);



        orderBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Check();


            }
        });
    }
    private void Check()
    {
        if(TextUtils.isEmpty(cardnameEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your full name", Toast.LENGTH_SHORT).show();

        }

        else if(TextUtils.isEmpty(cardnumEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your debit/credit card number", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(expdateEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide the expiration date", Toast.LENGTH_SHORT).show();

        }
        else if(TextUtils.isEmpty(cvvnumEditText.getText().toString()))
        {
            Toast.makeText(this, "Please provide your CVV number", Toast.LENGTH_SHORT).show();

        }

        else
        {
            PlaceOrder();

        }

    }

    private void PlaceOrder()
    {
        Toast.makeText(PaymentActivity.this, "Your order has been placed successfully.", Toast.LENGTH_SHORT).show();
    }

    // Intent intent = new Intent(confirmOrderActivity, HomeActivity)
//    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//    startActivity(intent)
    // finish(); to go back to the Home/Main activity

}
