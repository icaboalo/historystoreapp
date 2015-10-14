package com.icaboalo.historystoreapp.domain.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by icaboalo on 10/14/2015.
 */
public class PlaceModel {

    @SerializedName("id")
    String placeId;

    @SerializedName("name")
    String placeName;

    @SerializedName("image")
    String placeImage;

    @SerializedName("latitude")
    String placeLatitude;

    @SerializedName("Longitude")
    String placeLongitude;

    public String getPlaceId() {
        return placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceImage() {
        return placeImage;
    }

    public String getPlaceLatitude() {
        return placeLatitude;
    }

    public String getPlaceLongitude() {
        return placeLongitude;
    }
}
