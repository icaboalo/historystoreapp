package com.icaboalo.historystoreapp.io;

import com.icaboalo.historystoreapp.domain.VendorModel;
import com.icaboalo.historystoreapp.io.constant.VendorConstants;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by icaboalo on 10/10/2015.
 */
public interface ApiService {
    @GET(VendorConstants.PATH_VENDORS)
    void searchVendor(Callback<VendorModel> vendorApiResponse);
}
