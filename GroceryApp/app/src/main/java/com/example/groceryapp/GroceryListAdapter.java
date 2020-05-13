package com.example.groceryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryListAdapter.GroceryViewHolder> {

    private final LayoutInflater mInflater;
    private List<GroceryItem> mGroceryItems;
    private onGroceryItemListener onGroceryItemListener;

    GroceryListAdapter(Context context,onGroceryItemListener onGroceryItemListener){
        mInflater = LayoutInflater.from(context);
        this.onGroceryItemListener = onGroceryItemListener;
        //mGroceryItems = data;
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new GroceryViewHolder(itemView, onGroceryItemListener);
    }

    @Override
    public void onBindViewHolder(GroceryViewHolder holder, int position) {
        GroceryItem current = mGroceryItems.get(position);
        holder.bindItem(current);
    }

    void setGroceryItems(List<GroceryItem> gItems){
        mGroceryItems = gItems;
        notifyDataSetChanged();
    }

    public GroceryItem getGroceryItemAt(int position){
        return mGroceryItems.get(position);
    }

    @Override
    public int getItemCount() {
        if(mGroceryItems != null)
            return mGroceryItems.size();// <-----Finish this method
        else return 0;
    }

    protected class GroceryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView GroceryItemName;
        private TextView GroceryItemPrice;
        private TextView GroceryItemDescription;
        private ImageView mAddCartImage;

        private onGroceryItemListener itemListener;

        private GroceryViewHolder(View itemView, onGroceryItemListener listener){
            super(itemView);
            GroceryItemName = itemView.findViewById(R.id.item_name_textView);
            GroceryItemPrice = itemView.findViewById(R.id.item_price_textView);
            GroceryItemDescription = itemView.findViewById(R.id.item_description_textView);
            mAddCartImage = itemView.findViewById(R.id.add_shoppingcart_img);

            itemListener = listener;
            itemView.setOnClickListener(this);

            /*mAddCartImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemListener.onAddCartClick(getAdapterPosition());
                }
            });*/
        }

        public void bindItem(GroceryItem item){
            GroceryItemName.setText(item.itemName);
            GroceryItemPrice.setText(String.valueOf(item.itemPrice));
            GroceryItemDescription.setText(item.itemDescription);
        }

        @Override
        public void onClick(View view) {
            itemListener.onGroceryItemClicked(getAdapterPosition());
        }
    }

    public interface onGroceryItemListener{
        void onGroceryItemClicked(int position);
        //void onAddCartClick(int position);
    }
}
