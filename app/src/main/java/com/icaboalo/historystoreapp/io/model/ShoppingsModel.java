package com.icaboalo.historystoreapp.io.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by icaboalo on 10/16/2015.
 */
public class ShoppingsModel {

    @SerializedName("id")
    String shoppingId;

    @SerializedName("product")
    ProductModel product;

    @SerializedName("list")
    ListsModel lists;

    @SerializedName("Status")
    String status;

    @SerializedName("price")
    String price;

    @SerializedName("quantity")
    int quantity;

    @SerializedName("total")
    int total;
}
