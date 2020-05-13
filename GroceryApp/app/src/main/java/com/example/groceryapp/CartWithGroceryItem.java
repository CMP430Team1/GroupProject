package com.example.groceryapp;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class CartWithGroceryItem {
    @Embedded
    public UserCart userCart;

    @Relation(
            parentColumn = "cartId",
            entityColumn = "userCartId"
    )
    public List<GroceryItem> groceryItems;
}
