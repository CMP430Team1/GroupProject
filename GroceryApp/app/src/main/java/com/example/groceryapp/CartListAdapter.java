package com.example.groceryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.CartViewHolder> {

    private LayoutInflater inflator;
    private List<UserCart> mUserCart;

    CartListAdapter(Context context){
        inflator = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public CartListAdapter.CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflator.inflate(R.layout.cart_recyclerviewitem, parent, false);
        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartListAdapter.CartViewHolder holder, int position) {
        if(mUserCart != null){
            UserCart current = mUserCart.get(position);
            holder.itemName.setText(current.item);
            holder.itemPrice.setText(String.valueOf(current.price));
        }

    }

    void setGroceryItems(List<UserCart> uItems){
        mUserCart = uItems;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mUserCart != null)
            return mUserCart.size();// <-----Finish this method
        else return 0;
    }

    class CartViewHolder extends RecyclerView.ViewHolder{

        private TextView itemName;
        private TextView itemPrice;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.cart_itemName_textView);
            itemPrice = itemView.findViewById(R.id.cart_itemPrice_textView);
        }
    }
}
