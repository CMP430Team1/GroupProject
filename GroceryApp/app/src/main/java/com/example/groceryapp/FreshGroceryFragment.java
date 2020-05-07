package com.example.groceryapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FreshGroceryFragment extends Fragment {

    View view;
    private GroceryViewModel mGroceryViewModel;
    RecyclerView recyclerView;

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

        final GroceryListAdapter adapter = new GroceryListAdapter(getActivity());
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
}
