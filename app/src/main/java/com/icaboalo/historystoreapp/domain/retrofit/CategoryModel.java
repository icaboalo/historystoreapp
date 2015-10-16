package com.icaboalo.historystoreapp.domain.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by richpolis on 16/10/15.
 */
public class CategoryModel {
    @SerializedName("id")
    long categoryId;

    @SerializedName("name")
    String name;

    @SerializedName("image")
    String image;

    public long getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }
}
