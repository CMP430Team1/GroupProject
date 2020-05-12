package com.example.groceryapp;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

public class Converters {

    @TypeConverter
    public static GroceryItem fromStringToGroceryItem(String itemString){
        GroceryItem item = new Gson().fromJson(itemString, GroceryItem.class);
        return item;
    }

    @TypeConverter
    public static String fromGroceryItemToString(GroceryItem item){
        String groceryItemString = new Gson().toJson(item);
        return groceryItemString;
    }
}
