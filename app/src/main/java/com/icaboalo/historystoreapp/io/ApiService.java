package com.icaboalo.historystoreapp.io;

import com.icaboalo.historystoreapp.domain.ProductPostModel;
import com.icaboalo.historystoreapp.domain.VendorModel;
import com.icaboalo.historystoreapp.io.constant.Constants;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by icaboalo on 10/10/2015.
 */
public interface ApiService {

    @GET(Constants.PATH_VENDORS)
    void searchVendor(Callback<ArrayList<VendorModel>> vendorApiResponse);

    @POST(Constants.PATH_PRODUCTS)
    void postProduct(@Field("name") String productName,
                     Callback<ProductPostModel> productApiPost);
}
