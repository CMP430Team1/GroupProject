package com.example.groceryapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userCart_Table")
public class UserCart {

    @PrimaryKey(autoGenerate = true)
    private int id;

   // @NonNull
    @ColumnInfo(name = "Grocery_Item")
    private GroceryItem product;

    @ColumnInfo(name = "Item_Quantity")
    private int quantity;

    public UserCart(GroceryItem product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public GroceryItem getProduct() {
        return product;
    }

    public void setProduct(@NonNull GroceryItem product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
