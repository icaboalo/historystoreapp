package com.icaboalo.historystoreapp.domain.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by icaboalo on 10/14/2015.
 */
public class ListsModel {

    @SerializedName("id")
    String placeListId;

    @SerializedName("place")
    PlaceModel place;

    @SerializedName("vendor")
    VendorModel vendor;

    @SerializedName("user")
    UserModel user;

    @SerializedName("status")
    boolean placeListStatus;

    public String getPlaceListId() {
        return placeListId;
    }

    public PlaceModel getPlace() {
        return place;
    }

    public VendorModel getVendor() {
        return vendor;
    }

    public UserModel getUser() {
        return user;
    }

    public boolean isPlaceListStatus() {
        return placeListStatus;
    }
}
