package com.example.groceryapp;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "groceryItem_table"/*, foreignKeys = {@ForeignKey(
        entity = UserCart.class,
        parentColumns = "id",
        childColumns = "userCartIdFk"
)}*/)
public class GroceryItem {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    protected int groceryItemId;

    //Foreign key
    //@ColumnInfo(name = "userCart_ForeignKey")
    protected int userCartId;

    @ColumnInfo(name = "Item_Name")
    protected String itemName;

    @ColumnInfo(name = "Item_Price")
    protected double itemPrice;

    @ColumnInfo(name = "Item_Category")
    protected String itemCategory;

    @ColumnInfo(name = "Item_Description")
    protected String itemDescription;

    public GroceryItem(String itemName, double itemPrice, String itemCategory, String itemDescription) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCategory = itemCategory;
        this.itemDescription = itemDescription;
    }

    //    public GroceryItem(@NonNull String name, @NonNull double price, @NonNull String description){
//        itemName        = name;
//        itemPrice       = price;
//        itemDescription = description;
//    }


//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getItemName(){
//        return itemName;
//    }
//
//    public double getItemPrice(){
//        return itemPrice;
//    }
//
//    public String getItemCategory(){
//        return itemCategory;
//    }
//
//    public String getItemDescription(){
//        return itemDescription;
//    }
//
//
//    public void setItemName(String newName){
//        itemName =  newName;
//    }
//
//    public void setItemPrice(double newPrice){
//        itemPrice = newPrice;
//    }
//
//    public void setItemCategory(String newCategory){
//        itemCategory = newCategory;
//    }
//
//    public void setItemDescription(String newDescription){
//        itemDescription = newDescription;
//    }
}
