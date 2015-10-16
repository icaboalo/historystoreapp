package com.icaboalo.historystoreapp.domain.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by icaboalo on 10/16/2015.
 */
public class ProductModel {

    @SerializedName("id")
    String productId;

    @SerializedName("key")
    String productKey;

    @SerializedName("name")
    String productName;

    @SerializedName("type_uom")
    String productTypeUOM;

    @SerializedName("conversion")
    String productConversion;

    @SerializedName("category")
    CategoryModel category;

    public String getProductId() {
        return productId;
    }

    public String getProductKey() {
        return productKey;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductTypeUOM() {
        return productTypeUOM;
    }

    public String getProductConversion() {
        return productConversion;
    }

    public CategoryModel getCategory() {
        return category;
    }
}
