package com.icaboalo.historystoreapp.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by icaboalo on 10/12/2015.
 */
public class ProductPostModel {

    @SerializedName("key")
    String productKey;

    @SerializedName("name")
    String productName;

    @SerializedName("category_id")
    String productCategoryId;

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(String productCategoryId) {
        this.productCategoryId = productCategoryId;
    }
}
