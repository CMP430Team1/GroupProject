package com.example.groceryapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "userCart_Table")
public class UserCart {

    @PrimaryKey(autoGenerate = true)
    protected int cartId;

    /*//@TypeConverters(Converters.class)
    @ColumnInfo(name = "Grocery_Item")
    protected GroceryItem product;

    @ColumnInfo(name = "Item_Quantity")
    protected int quantity;*/

    @ColumnInfo(name = "ItemName")
    protected String item;

    @ColumnInfo(name = "ItemPrice")
    protected double price;

    @ColumnInfo(name = "Quantity")
    protected int quantity;

    public UserCart(String item, double price, int quantity) {
        this.item = item;
        this.price = price;
        this.quantity = quantity;
    }

    /*public UserCart(GroceryItem product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }*/

}
