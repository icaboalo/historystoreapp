package com.icaboalo.historystoreapp.domain.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by icaboalo on 10/14/2015.
 */
public class PlaceModel {

    public PlaceModel(String placeName) {
        this.placeName = placeName;
        this.placeImage = "test.jpg";
    }

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

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setPlaceImage(String placeImage) {
        this.placeImage = placeImage;
    }

    public void setPlaceLatitude(String placeLatitude) {
        this.placeLatitude = placeLatitude;
    }

    public void setPlaceLongitude(String placeLongitude) {
        this.placeLongitude = placeLongitude;
    }

    @Override
    public String toString() {
        return "PlaceModel{" +
                "placeId='" + placeId + '\'' +
                ", placeName='" + placeName + '\'' +
                ", placeImage='" + placeImage + '\'' +
                ", placeLatitude='" + placeLatitude + '\'' +
                ", placeLongitude='" + placeLongitude + '\'' +
                '}';
    }
}
