package com.example.groceryapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FreshGroceryFragment extends Fragment implements GroceryListAdapter.onGroceryItemListener{

    View view;
    private GroceryViewModel mGroceryViewModel;
    RecyclerView recyclerView;
//    /*final*/ GroceryListAdapter adapter;

    public FreshGroceryFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.freshitems_fragment, container, false);
        recyclerView = view.findViewById(R.id.fresh_recyclerView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final GroceryListAdapter adapter = new GroceryListAdapter(getActivity(),this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mGroceryViewModel = ViewModelProviders.of(this).get(GroceryViewModel.class);
        mGroceryViewModel.getAllFreshItems().observe(getActivity(), new Observer<List<GroceryItem>>(){
            @Override
            public void onChanged(List<GroceryItem> groceryItems) {
                adapter.setGroceryItems(groceryItems);
            }
        });
    }

    @Override
    public void onGroceryItemClicked(int position) {
        Toast.makeText(getActivity(), "on click works", Toast.LENGTH_SHORT).show();
    }

    /*@Override
    public void onAddCartClick(int position) {
        mGroceryViewModel.insertToCart(adapter.getGroceryItemAt(position));
        Toast.makeText(getActivity(), "clicked the cart image", Toast.LENGTH_SHORT).show();
    }*/
}
