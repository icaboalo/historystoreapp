package com.icaboalo.historystoreapp.domain;

/**
 * Created by icaboalo on 10/12/2015.
 */
public class PlaceListModel {

    public PlaceListModel(String place) {
        mPlace = place;
    }

    String mPlace;

    public String getPlace() {
        return mPlace;
    }

    public void setPlace(String place) {
        mPlace = place;
    }
}
