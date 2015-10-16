package com.icaboalo.historystoreapp.ui.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.icaboalo.historystoreapp.R;

import butterknife.ButterKnife;

/**
 * Created by icaboalo on 10/16/2015.
 */
public class ProductDialogFragment extends DialogFragment {

    public ProductDialogFragment() {
    }

    public static ProductDialogFragment newInstance(){
        ProductDialogFragment fragment = new ProductDialogFragment();
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_add_product, null, false);
        ButterKnife.bind(this, view);
        alertDialog.setView(view).setCancelable(false)
                .setTitle("Add Product")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        return alertDialog.create();
    }
}
