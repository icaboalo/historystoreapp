package com.icaboalo.historystoreapp.domain.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by icaboalo on 10/14/2015.
 */
public class ListsModel {

    @SerializedName("id")
    String placeListId;

    @SerializedName("place")
    String place;

    @SerializedName("vendor")
    String vendor;

    @SerializedName("user")
    String user;

    @SerializedName("status")
    boolean placeListStatus;

    public String getPlaceListId() {
        return placeListId;
    }

    public String getPlace() {
        return place;
    }

    public String getVendor() {
        return vendor;
    }

    public String getUser() {
        return user;
    }

    public boolean isPlaceListStatus() {
        return placeListStatus;
    }
}
