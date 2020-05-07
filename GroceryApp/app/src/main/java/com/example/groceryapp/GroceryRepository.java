package com.example.groceryapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class GroceryRepository {
    private GroceryDao mGroceryDao;
    private LiveData<List<GroceryItem>> mAllGrocery;

    private LiveData<List<GroceryItem>> mAllFrozenGrocery;
    private LiveData<List<GroceryItem>> mAllFreshGrocery;
    private LiveData<List<GroceryItem>> mAllCannedGrocery;

    GroceryRepository(Application application){
        GroceryRoomDatabase db = GroceryRoomDatabase.getDatabase(application);
        mGroceryDao            = db.groceryDao();
        mAllGrocery            = mGroceryDao.getAllItems();

        mAllFrozenGrocery      = mGroceryDao.getAllFrozenItems("frozen");
        mAllFreshGrocery       = mGroceryDao.getAllFreshItems("fresh");
        mAllCannedGrocery      = mGroceryDao.getAllCannedItems("canned");
    }


    LiveData<List<GroceryItem>> getAllGroceryItems(){
        return mAllGrocery;
    }

    LiveData<List<GroceryItem>> getAllFrozenGroceryItems() {
        return mAllFrozenGrocery;
    }

    LiveData<List<GroceryItem>> getAllFreshGroceryItems() {
        return mAllFreshGrocery;
    }

    LiveData<List<GroceryItem>> getAllCannedGroceryItems() {
        return mAllCannedGrocery;
    }



    public void insert(GroceryItem item){
        new insertAsyncTask(mGroceryDao).execute(item);
    }


    private class insertAsyncTask extends AsyncTask<GroceryItem, Void, Void> {
        private GroceryDao mAsyncTaskDao;

        public insertAsyncTask(GroceryDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(GroceryItem... groceryItems) {
            mAsyncTaskDao.insert(groceryItems[0]);
            return null;
        }
    }
}
