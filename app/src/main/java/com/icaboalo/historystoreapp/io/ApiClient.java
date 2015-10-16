package com.icaboalo.historystoreapp.io;

import com.icaboalo.historystoreapp.domain.retrofit.ListsModel;
import com.icaboalo.historystoreapp.domain.retrofit.PlaceModel;
import com.icaboalo.historystoreapp.domain.retrofit.VendorModel;
import com.icaboalo.historystoreapp.io.constant.Constants;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by icaboalo on 10/10/2015.
 */
public class ApiClient {

    public static ApiService getApiService(){
        if (mApiService == null){
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(Constants.BASE_URL)
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();
            mApiService = restAdapter.create(ApiService.class);
        }
        return mApiService;
    }
    public static ApiService mApiService;

//    vendor
    public static void searchVendor(Callback<ArrayList<VendorModel>> vendorApiResponse){
        getApiService().searchVendor(vendorApiResponse);
    }


//    product


//    list
    public static void searchList(Callback<ArrayList<ListsModel>> listApiResponse){
        getApiService().searchList(listApiResponse);
    }

    //    place Post
    public static void postPlace(PlaceModel placeModel, Callback<PlaceModel> placeApiResponse){
        getApiService().postPlace(placeModel, placeApiResponse);
    }

//    get place
    public static void searchPlace(Callback<ArrayList<PlaceModel>> placeApiResponse){
        getApiService().searchPlaces(placeApiResponse);
    }
}
