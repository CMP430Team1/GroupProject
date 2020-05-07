package com.example.groceryapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GroceryDao {
    @Insert
    void insert(GroceryItem item);

    @Update
    void update(GroceryItem item);

    @Query("SELECT * from groceryItem_table ORDER BY Item_Name ASC")
    LiveData<List<GroceryItem>> getAllItems();

    @Query("SELECT * from groceryItem_table WHERE Item_Category LIKE :category")
    LiveData<List<GroceryItem>> getAllFrozenItems(String category);

    @Query("SELECT * from groceryItem_table WHERE Item_Category LIKE :category")
    LiveData<List<GroceryItem>> getAllFreshItems(String category);

    @Query("SELECT * from groceryItem_table WHERE Item_Category LIKE :category" )
    LiveData<List<GroceryItem>> getAllCannedItems(String category);

    @Query("DELETE FROM groceryItem_table")
    void deleteAll();
}
