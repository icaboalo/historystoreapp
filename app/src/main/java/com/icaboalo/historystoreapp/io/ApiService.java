package com.icaboalo.historystoreapp.io;

import com.icaboalo.historystoreapp.domain.retrofit.ListsModel;
import com.icaboalo.historystoreapp.domain.retrofit.PlaceModel;
import com.icaboalo.historystoreapp.domain.retrofit.VendorModel;
import com.icaboalo.historystoreapp.io.constant.Constants;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by icaboalo on 10/10/2015.
 */
public interface ApiService {

    @GET(Constants.PATH_LISTS)
    void searchList(Callback<ArrayList<ListsModel>> listsApiResponse);

    @GET(Constants.PATH_VENDORS)
    void searchVendor(Callback<ArrayList<VendorModel>> vendorApiResponse);

    @GET(Constants.PATH_PLACES)
    void searchPlaces(Callback<ArrayList<PlaceModel>> placeApiResponse);

    @POST(Constants.PATH_PLACES + "/")
    void postPlace(@Body PlaceModel placeModel, Callback<PlaceModel> placeApiResponse);
}
