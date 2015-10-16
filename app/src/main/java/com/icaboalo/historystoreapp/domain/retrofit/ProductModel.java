package com.icaboalo.historystoreapp.domain.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by richpolis on 16/10/15.
 */
public class ProductModel {
    @SerializedName("id")
    long productId;

    @SerializedName("key")
    String key;

    @SerializedName("name")
    String name;

    @SerializedName("type_uom")
    String typeUom;

    @SerializedName("conversion")
    double conversion;

    @SerializedName("category")
    CategoryModel category;

    public long getProductId() {
        return productId;
    }

    public String getKey() {
        return key;
    }

    public String getName() {
        return name;
    }

    public String getTypeUom() {
        return typeUom;
    }

    public double getConversion() {
        return conversion;
    }

    public CategoryModel getCategory() {
        return category;
    }
}
