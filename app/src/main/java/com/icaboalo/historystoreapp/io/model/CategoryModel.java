package com.icaboalo.historystoreapp.io.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by icaboalo on 10/16/2015.
 */
public class CategoryModel {

    @SerializedName("id")
    String categoryId;

    @SerializedName("name")
    String categoryName;

    @SerializedName("image")
    String categoryImage;

    public String getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }
}
