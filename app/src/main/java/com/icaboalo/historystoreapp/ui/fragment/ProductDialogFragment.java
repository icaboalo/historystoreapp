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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.icaboalo.historystoreapp.R;
import com.icaboalo.historystoreapp.domain.Shopping;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by icaboalo on 10/16/2015.
 */
public class ProductDialogFragment extends DialogFragment implements AdapterView.OnItemSelectedListener{

    private Shopping mShopping = new Shopping();

    @Bind(R.id.product_name_input)
    EditText mProductNameInput;

    @Bind(R.id.category_spinner)
    Spinner productCategorySpinner;

    @Bind(R.id.type_spinner)
    Spinner productTypeSpinner;

    @Bind(R.id.conversion_text)
    TextView productConversionText;

    @Bind(R.id.product_price_input)
    EditText productPriceInput;

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
        View view = inflater.inflate(R.layout.fragment_add_product, null);
        ButterKnife.bind(this, view);
        productConversionText.setText("");
        productTypeSpinner.setOnItemSelectedListener(this);
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.mShopping.setConversion(1);
        if(parent.getItemAtPosition(position).toString().compareTo("Kilogramo")==0){
            this.mShopping.setType_uom("kilogram");
        }else if(parent.getItemAtPosition(position).toString().compareTo("Litro")==0){
            this.mShopping.setType_uom("liter");
        }else if(parent.getItemAtPosition(position).toString().compareTo("Pieza")==0){
            this.mShopping.setType_uom("piece");
        }
        productConversionText.setText(this.mShopping.getConversionString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @OnClick(R.id.image_more_conversion)
    protected void onClickImageMoreConversion(){
        float conversion = this.mShopping.getConversion();
        this.mShopping.setConversion((float) (conversion + 1.00));
        productConversionText.setText(this.mShopping.getConversionString());
    }

    @OnClick(R.id.image_less_conversion)
    protected void onClickImageLessConversion(){
        float conversion = this.mShopping.getConversion();
        if(conversion > 1){
            this.mShopping.setConversion((float) (conversion - 1.00));
        }
        productConversionText.setText(this.mShopping.getConversionString());
    }

    public void setProductKey(String key){
        this.mShopping.getProduct().setKey(key);

    }
}
