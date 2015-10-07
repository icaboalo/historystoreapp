package com.icaboalo.historystoreapp.domain;

/**
 * Created by icaboalo on 10/7/2015.
 */
public class CaptureListModel {

    String mCaptureDate;
    String mCapturePrice;
    String mCapturePlace;

    public String getCaptureDate() {
        return mCaptureDate;
    }

    public String getCapturePrice() {
        return mCapturePrice;
    }

    public String getCapturePlace() {
        return mCapturePlace;
    }

    public void setCaptureDate(String captureDate) {
        mCaptureDate = captureDate;
    }

    public void setCapturePrice(String capturePrice) {
        mCapturePrice = capturePrice;
    }

    public void setCapturePlace(String capturePlace) {
        mCapturePlace = capturePlace;
    }
}
