package com.example.groceryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TextView itemName;
    private TextView itemPrice;
    private Button checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.cart_recyclerView);
        itemName = findViewById(R.id.cart_itemName_textView);
        itemPrice = findViewById(R.id.cart_itemPrice_textView);
        checkoutButton = findViewById(R.id.cart_checkoutButton);

        // Finish this class and the cartDAO query
    }

    public void goToCheckout(View view) {
        Toast.makeText(this, "Pressed the checkout button", Toast.LENGTH_SHORT).show();
    }
}
