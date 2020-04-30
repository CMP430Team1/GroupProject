package com.example.groceryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryListAdapter.GroceryViewHolder> {

    private final LayoutInflater mInflater;
    private List<GroceryItem> mGroceryItems;

    GroceryListAdapter(Context context){
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new GroceryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryListAdapter.GroceryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if(mGroceryItems) // <-----Finish this method
        return 0;
    }

    private class GroceryViewHolder extends RecyclerView.ViewHolder {
        private TextView GroceryItemName;
        private TextView GroceryItemPrice;
        private TextView GroceryItemDescription;

        private GroceryViewHolder(View itemView){
            super(itemView);
            GroceryItemName = itemView.findViewById(R.id.item_name_textView);
            GroceryItemPrice = itemView.findViewById(R.id.item_price_textView);
            GroceryItemDescription = itemView.findViewById(R.id.item_description_textView);
        }
    }
}
