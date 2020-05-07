package com.example.groceryapp;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {GroceryItem.class}, version = 2, exportSchema = false)
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
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static GroceryRoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final GroceryDao mDao;
        GroceryItem[] items = createItemList();

        public GroceryItem[] createItemList(){
            GroceryItem[] itemList = new GroceryItem[30];
            for(int i = 0; i < itemList.length; i++){
                if(i <= 10){
                    itemList[i] = new GroceryItem("Peas # " + i, (double)i, "frozen","This is peas # " + i);
                }
                if(i > 10 && i <= 20){
                    itemList[i] = new GroceryItem("Bread # " + i, (double)i, "fresh","This is Bread # " + i);
                }
                if(i > 20 && i <= 30){
                    itemList[i] = new GroceryItem("Beans # " + i, (double)i, "canned","This is Beans # " + i);
                }
            }
            return itemList;
        }

        public PopulateDbAsync(GroceryRoomDatabase db) {
            mDao = db.groceryDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mDao.deleteAll();

            for(int i = 0; i <= items.length - 1; i++){
                mDao.insert(items[i]);
            }

            return null;
        }
    }
}
