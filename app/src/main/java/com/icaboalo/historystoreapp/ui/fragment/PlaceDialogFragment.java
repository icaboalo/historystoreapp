package com.icaboalo.historystoreapp.ui.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.icaboalo.historystoreapp.R;

/**
 * Created by icaboalo on 10/12/2015.
 */
public class PlaceDialogFragment extends DialogFragment {

    public PlaceDialogFragment() {

    }

    public static PlaceDialogFragment newInstance(String title){
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
        alertDialog.setCancelable(false);
        alertDialog.setTitle("Add Place");
        alertDialog.setView(view);


        return alertDialog.create();

    }
}
