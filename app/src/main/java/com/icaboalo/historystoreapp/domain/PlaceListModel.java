package com.icaboalo.historystoreapp.domain;

/**
 * Created by icaboalo on 10/12/2015.
 */
public class PlaceListModel {

    private String mVendor;

    public PlaceListModel(String place, String vendor) {
        mPlace = place;
        mVendor = vendor;
    }

    String mPlace;

    public String getPlace() {
        return mPlace;
    }

    public void setPlace(String place) {
        mPlace = place;
    }

    public String getVendor() {
        return mVendor;
    }
}
