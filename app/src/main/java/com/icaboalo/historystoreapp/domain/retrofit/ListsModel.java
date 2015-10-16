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

    @SerializedName("user")
    UserModel user;

    @SerializedName("status")
    boolean placeListStatus;

    @SerializedName("total")
    String total;

    @SerializedName("date_shopping")
    String date;

    public String getPlaceListId() {
        return placeListId;
    }

    public PlaceModel getPlace() {
        return place;
    }

    public UserModel getUser() {
        return user;
    }

    public boolean isPlaceListStatus() {
        return placeListStatus;
    }

    public String getTotal() {
        return total;
    }

    public String getDate() {
        return date;
    }
}
