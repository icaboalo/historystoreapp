package com.icaboalo.historystoreapp.io.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by icaboalo on 10/14/2015.
 */
public class PlaceModel {

    public PlaceModel(String placeName, String vendorId) {
        this.placeName = placeName;
        this.vendorId = vendorId;
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

    @SerializedName("vendor_id")
    String vendorId;

    @SerializedName("vendor")
    VendorModel vendor;

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

    public String getVendorId() {
        return vendorId;
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

    public VendorModel getVendor() {
        return vendor;
    }
}
