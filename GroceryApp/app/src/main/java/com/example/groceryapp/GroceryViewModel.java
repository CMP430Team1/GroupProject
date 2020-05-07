package com.example.groceryapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class GroceryViewModel extends AndroidViewModel {

    private GroceryRepository mRepository;
    private LiveData<List<GroceryItem>> mAllGroceryItems;

    private LiveData<List<GroceryItem>> mAllFrozenItems;
    private LiveData<List<GroceryItem>> mAllFreshItems;
    private LiveData<List<GroceryItem>> mAllCannedItems;

    public GroceryViewModel(@NonNull Application application) {
        super(application);
        mRepository      = new GroceryRepository(application);
        mAllGroceryItems = mRepository.getAllGroceryItems();
        mAllFrozenItems = mRepository.getAllFrozenGroceryItems();
        mAllFreshItems = mRepository.getAllFreshGroceryItems();
        mAllCannedItems = mRepository.getAllCannedGroceryItems();
    }

    LiveData<List<GroceryItem>> getAllGroceryItems(){
        return  mAllGroceryItems;
    }

    LiveData<List<GroceryItem>> getAllFrozenItems(){
        return  mAllFrozenItems;
    }

    LiveData<List<GroceryItem>> getAllFreshItems(){
        return  mAllFreshItems;
    }

    LiveData<List<GroceryItem>> getAllCannedItems(){
        return  mAllCannedItems;
    }

    public void insert(GroceryItem item){
        mRepository.insert(item);
    }
}
