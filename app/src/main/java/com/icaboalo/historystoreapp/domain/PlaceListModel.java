package com.icaboalo.historystoreapp.domain;

/**
 * Created by icaboalo on 10/12/2015.
 */
public class PlaceListModel {

    private String mVendor;

    public PlaceListModel(String place, String vendor, String image) {
        mPlace = place;
        mVendor = vendor;
        mImage = image;
    }

    String mImage;

    String mPlace;

    public String getPlace() {
        return mPlace;
    }

    public String getVendor() {
        return mVendor;
    }

    public String getImage() {
        return mImage;
    }
}
