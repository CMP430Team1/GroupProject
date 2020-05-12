package com.example.groceryapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CartDao {

    @Insert
    void insert(GroceryItem item);

//    @Query("SELECT Grocery_Item, item_Quantity FROM userCart_Table ORDER BY Grocery_Item ASC")
//    LiveData<List<GroceryItem>> getAllItems();

//    @Update
//    void update();                              //<------- Finish this class

    @Query("DELETE FROM userCart_Table")
    void deleteAll();

    @Delete
    void deleteItem(GroceryItem item);
}
