package com.example.groceryapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class GroceryViewModel extends AndroidViewModel {

    private GroceryRepository mRepository;
    private LiveData<List<GroceryItem>> mAllGroceryItems;

    public GroceryViewModel(@NonNull Application application) {
        super(application);
        mRepository      = new GroceryRepository(application);
        mAllGroceryItems = mRepository.getAllGroceryItems();
    }

    LiveData<List<GroceryItem>> getAllGroceryItems(){
        return  mAllGroceryItems;
    }

    public void insert(GroceryItem item){
        mRepository.insert(item);
    }
}
