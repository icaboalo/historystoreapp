package com.icaboalo.historystoreapp.ui.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.icaboalo.historystoreapp.R;
import com.icaboalo.historystoreapp.domain.retrofit.PlaceModel;
import com.icaboalo.historystoreapp.domain.retrofit.VendorModel;
import com.icaboalo.historystoreapp.io.ApiClient;
import com.icaboalo.historystoreapp.util.VUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by icaboalo on 10/12/2015.
 */
public class PlaceDialogFragment extends DialogFragment implements AdapterView.OnItemSelectedListener {

    @Bind(R.id.new_place_input)
    EditText mNewPlaceInput;

    @Bind(R.id.vendor_spinner)
    Spinner mVendorSpinner;

    public PlaceDialogFragment() {

    }

    public static PlaceDialogFragment newInstance(String title) {
        PlaceDialogFragment fragment = new PlaceDialogFragment();
        Bundle args = new Bundle();
        args.putString("Add Place", title);
        fragment.setArguments(args);
        return fragment;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_places_dialog, null);
        ButterKnife.bind(this, view);
        executeWithRetrofit();
        mVendorSpinner.setOnItemSelectedListener(this);
        alertDialog.setCancelable(true)
                .setView(view)
                .setTitle("Add Place");
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String newPlace = VUtil.extractText(mNewPlaceInput);

//                postPlace(newPlace);
                dialog.dismiss();
            }
        });

        alertDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        return alertDialog.create();
    }


    private void postPlace(String placeName, String vendorId) {
        ApiClient.postPlace(new PlaceModel(placeName, vendorId), new Callback<PlaceModel>() {
            @Override
            public void success(PlaceModel placeModel, Response response) {
                Log.d("post response", placeModel.toString());
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
            }
        });
    }


    ArrayAdapter<String> arrayAdapter;
    public void setUpVendorSpinner(){
        mVendorSpinner.setAdapter(arrayAdapter);
    }

    public void executeWithRetrofit(){
        ApiClient.searchVendor(new Callback<ArrayList<VendorModel>>() {
            @Override
            public void success(ArrayList<VendorModel> vendorModels, Response response) {
                List<String> vendorList = new ArrayList<>();
                for (int i = 0; i < vendorModels.size(); i++) {
                    String vendorName = vendorModels.get(i).getVendorName();
                    vendorList.add(vendorName);
                    Log.d("vendorName", vendorName);
                }
                arrayAdapter = new ArrayAdapter<>(getActivity(),
                        android.R.layout.simple_spinner_dropdown_item, vendorList);
                setUpVendorSpinner();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
