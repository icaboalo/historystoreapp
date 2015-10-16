package com.icaboalo.historystoreapp.io;

import com.icaboalo.historystoreapp.io.constant.Constants;
import com.icaboalo.historystoreapp.io.model.ListsModel;
import com.icaboalo.historystoreapp.io.model.PlaceModel;
import com.icaboalo.historystoreapp.io.model.ProductModel;
import com.icaboalo.historystoreapp.io.model.ShoppingsModel;
import com.icaboalo.historystoreapp.io.model.VendorModel;

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

//    @GET vendor
    public static void searchVendor(Callback<ArrayList<VendorModel>> vendorApiResponse){
        getApiService().searchVendor(vendorApiResponse);
    }


//    @GET product
    public static void searchProduct(Callback<ArrayList<ProductModel>> productApiResponse){
        getApiService().searchProducts(productApiResponse);
    }

//    @GET list
    public static void searchList(Callback<ArrayList<ListsModel>> listApiResponse){
        getApiService().searchList(listApiResponse);
    }

    //    @POST place
    public static void postPlace(PlaceModel placeModel, Callback<PlaceModel> placeApiResponse){
        getApiService().postPlace(placeModel, placeApiResponse);
    }

//    @GET place
    public static void searchPlace(Callback<ArrayList<PlaceModel>> placeApiResponse){
        getApiService().searchPlaces(placeApiResponse);
    }

//    @GET Shopping
    public static void searchShopping(Callback<ArrayList<ShoppingsModel>> shoppingApiResponse){
        getApiService().searchShoppings(shoppingApiResponse);
    }

//    @POST Shopping
    public static void postShopping(ShoppingsModel shoppingsModel, String shoppingId, Callback<ShoppingsModel> shoppingsApiResponse){
        getApiService().postShopping(shoppingsModel, shoppingId, shoppingsApiResponse);
    }
}
