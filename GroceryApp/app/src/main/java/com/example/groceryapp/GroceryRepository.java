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

    private CartDao mCartDao;
    private LiveData<List<UserCart>> mAllCartItems;

    GroceryRepository(Application application){
        GroceryRoomDatabase db = GroceryRoomDatabase.getDatabase(application);
        mGroceryDao            = db.groceryDao();
        mAllGrocery            = mGroceryDao.getAllItems();

        mAllFrozenGrocery      = mGroceryDao.getAllFrozenItems("frozen");
        mAllFreshGrocery       = mGroceryDao.getAllFreshItems("fresh");
        mAllCannedGrocery      = mGroceryDao.getAllCannedItems("canned");

        mCartDao               = db.cartDao();
        mAllCartItems          = mCartDao.getAllItems();
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

    LiveData<List<UserCart>> getAllUserCartItems(){    //<-----changes
        return mAllCartItems;
    }



    public void insert(GroceryItem item){
        new insertAsyncTask(mGroceryDao).execute(item);
    }

    public void insertToCart(GroceryItem item){
        new insertToCartAsyncTask(mCartDao).execute(item);
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


    private class insertToCartAsyncTask extends AsyncTask<GroceryItem, Void, Void>{
        private CartDao mInsertAsyncTaskDao;

        public insertToCartAsyncTask(CartDao dao){
            mInsertAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(GroceryItem... groceryItems) {
            mInsertAsyncTaskDao.insert(groceryItems[0]);
            return null;
        }
    }
}
