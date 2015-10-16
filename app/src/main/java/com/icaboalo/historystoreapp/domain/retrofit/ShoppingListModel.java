package com.icaboalo.historystoreapp.domain.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by richpolis on 16/10/15.
 */
public class ShoppingListModel {
    @SerializedName("id")
    long shoppingId;

    @SerializedName("product")
    ProductModel product;

    @SerializedName("list")
    ListsModel list;

    @SerializedName("price")
    double price;

    @SerializedName("quantity")
    int quantity;

    public long getShoppingId() {
        return shoppingId;
    }

    public ProductModel getProduct() {
        return product;
    }

    public ListsModel getList() {
        return list;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
