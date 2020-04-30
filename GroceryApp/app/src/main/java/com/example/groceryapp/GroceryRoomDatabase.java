package com.example.groceryapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {GroceryItem.class}, version = 1, exportSchema = false)
public abstract class GroceryRoomDatabase extends RoomDatabase {
    public abstract GroceryDao groceryDao();

    private static GroceryRoomDatabase INSTANCE;

    public static GroceryRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (GroceryRoomDatabase.class){
                if(INSTANCE == null){
                    // Create DB here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            GroceryRoomDatabase.class, "groceryItem_database")
                            //wipes & rebuilds instead of migrating
                            // look into migration
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
