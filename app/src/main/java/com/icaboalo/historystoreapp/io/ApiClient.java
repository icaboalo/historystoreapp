package com.icaboalo.historystoreapp.io;

import com.icaboalo.historystoreapp.domain.retrofit.ListsModel;
import com.icaboalo.historystoreapp.domain.retrofit.ProductPostModel;
import com.icaboalo.historystoreapp.domain.retrofit.VendorModel;
import com.icaboalo.historystoreapp.io.constant.Constants;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.Response;

/**
 * Created by icaboalo on 10/10/2015.
 */
public class ApiClient {
//    vendor
    private static ApiService vendorApiService;

    public static ApiService getVendorApiService(){
        if (vendorApiService == null){
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(Constants.BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();
            vendorApiService = restAdapter.create(ApiService.class);
        }
        return vendorApiService;
    }

    public static void searchVendor(Callback<ArrayList<VendorModel>> vendorApiResponse){
        getVendorApiService().searchVendor(vendorApiResponse);
    }


//    product
    public static ApiService productApiService;

    public static ApiService postProductApiService(){
        if (postProductApiService() == null){
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(Constants.BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();
            productApiService = restAdapter.create(ApiService.class);
        }

        return productApiService;
    }

    public static void postProduct(String key, String name, String categoryId, Callback<Response> productApiPost){
        postProductApiService().postProduct(new ProductPostModel(key, name, categoryId), productApiPost);
    }

//    list
    public static ApiService listApiService;
    public static ApiService getListApiService(){
        if (listApiService == null){
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(Constants.BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.BASIC)
                    .build();
            listApiService = restAdapter.create(ApiService.class);
        }

        return listApiService;
    }

    public static void searchList(Callback<ArrayList<ListsModel>> listApiResponse){
        getListApiService().searchList(listApiResponse);
    }
}
