package com.icaboalo.historystoreapp.ui.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.icaboalo.historystoreapp.R;
import com.icaboalo.historystoreapp.util.VUtil;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by icaboalo on 10/12/2015.
 */
public class PlaceDialogFragment extends DialogFragment {

    @Bind(R.id.new_place_input)
    EditText mNewPlaceInput;

    @Bind(R.id.new_vendor_input)
    EditText mNewVendorInput;

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
        alertDialog.setCancelable(true)
                .setView(view)
                .setTitle("Add Place");
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String newPlace = VUtil.extractText(mNewPlaceInput);
                Toast.makeText(getActivity(), newPlace, Toast.LENGTH_SHORT).show();

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
}
