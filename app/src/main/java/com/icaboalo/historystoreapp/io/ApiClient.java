package com.icaboalo.historystoreapp.io;

import com.icaboalo.historystoreapp.domain.VendorModel;
import com.icaboalo.historystoreapp.io.constant.VendorConstants;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by icaboalo on 10/10/2015.
 */
public class ApiClient {
//    vendor
    private static ApiService vendorApiService;

    public static ApiService getVendorApiService(){
        if (vendorApiService == null){
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(VendorConstants.BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();
            vendorApiService = restAdapter.create(ApiService.class);
        }
        return vendorApiService;
    }

    public static void searchVendor(Callback<VendorModel> vendorApiResponse){
        getVendorApiService().searchVendor(vendorApiResponse);
    }
}
