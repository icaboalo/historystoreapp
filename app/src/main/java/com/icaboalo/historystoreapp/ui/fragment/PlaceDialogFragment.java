package com.icaboalo.historystoreapp.ui.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.icaboalo.historystoreapp.R;
import com.icaboalo.historystoreapp.util.VUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by icaboalo on 10/12/2015.
 */
public class PlaceDialogFragment extends DialogFragment implements AdapterView.OnItemSelectedListener {

    @Bind(R.id.new_place_input)
    EditText mNewPlaceInput;

    @Bind(R.id.vendor_spinner)
    Spinner mVendorSpinner;

    Communicator mCommunicator;

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
        mVendorSpinner.setOnItemSelectedListener(this);
        arrayAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item, vendorList);
        setUpVendorSpinner();
        alertDialog.setCancelable(true)
                .setView(view)
                .setTitle("Add Place");
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newPlace = VUtil.extractText(mNewPlaceInput);
                mCommunicator.respond(newPlace, vendorId);
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

    public void setSpinnerData (List<String> newDataList, List<String> vendorIdList){
        vendorList = newDataList;
        this.vendorIdList = vendorIdList;
    }

    ArrayAdapter<String> arrayAdapter;
    List<String> vendorList = new ArrayList<>();
    List<String> vendorIdList = new ArrayList<>();
    String vendorId;

    public void setUpVendorSpinner(){
        mVendorSpinner.setAdapter(arrayAdapter);
    }

    public void setCommunicator(Communicator communicator) {
        mCommunicator = communicator;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        vendorId = vendorIdList.get(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
