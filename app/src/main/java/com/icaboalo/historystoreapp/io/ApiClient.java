package com.icaboalo.historystoreapp.io;

import com.icaboalo.historystoreapp.domain.retrofit.ListsModel;
import com.icaboalo.historystoreapp.domain.retrofit.PlaceModel;
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
    public static void postProduct(String key, String name, String categoryId, Callback<Response> productApiPost){
        getApiService().postProduct(new ProductPostModel(key, name, categoryId), productApiPost);
    }

//    list
    public static void searchList(Callback<ArrayList<ListsModel>> listApiResponse){
        getApiService().searchList(listApiResponse);
    }

    //    place Post
    public static void postPlace(PlaceModel placeModel, Callback<PlaceModel> placeApiResponse){
        getApiService().postPlace(placeModel, placeApiResponse);
    }

//    get place
    public static void searhPlace(Callback<ArrayList<PlaceModel>> placeApiResonse){
        getApiService().searchPlaces(placeApiResonse);
    }
}
