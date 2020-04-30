package com.example.groceryapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "groceryItem_table")
public class GroceryItem {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "Item_Name")
    private String itemName;

    @ColumnInfo(name = "Item_Price")
    private double itemPrice;

    @ColumnInfo(name = "Item_Description")
    private String itemDescription;

    public GroceryItem(@NonNull String name, @NonNull double price, @NonNull String description){
        itemName        = name;
        itemPrice       = price;
        itemDescription = description;
    }

    public String getItemName(){
        return itemName;
    }

    public double getItemPrice(){
        return itemPrice;
    }

    public String getItemDescription(){
        return itemDescription;
    }

    public void setItemName(String newName){
        itemName =  newName;
    }

    public void setItemPrice(double newPrice){
        itemPrice = newPrice;
    }

    public void setItemDescription(String newDescription){
        itemDescription = newDescription;
    }
}
