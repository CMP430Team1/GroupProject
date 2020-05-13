package com.example.groceryapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Ignore;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RoomWarnings;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CartDao {

    @Insert
    void insert(GroceryItem item);

    @Transaction
    @Query("SELECT * FROM userCart_Table")
    LiveData<List<CartWithGroceryItem>> getAllCartWithGroceryItems();

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @Query("SELECT * FROM userCart_Table")
    LiveData<List<UserCart>> getAllItems();

//    @Update
//    void update();                              //<------- Finish this class

    @Query("DELETE FROM userCart_Table")
    void deleteAll();

    @Delete
    void deleteItem(GroceryItem item);
}
