package com.icaboalo.historystoreapp.domain.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by icaboalo on 10/10/2015.
 */
public class VendorModel {

    public VendorModel(String vendorName) {
        this.vendorName = vendorName;
    }

    @SerializedName("id")
    String vendorId;

    @SerializedName("name")
    String vendorName;

    @SerializedName("image")
    String vendorImage;

    public String getVendorId() {
        return vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public String getVendorImage() {
        return vendorImage;
    }
}
