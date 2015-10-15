package com.icaboalo.historystoreapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.icaboalo.historystoreapp.R;
import com.icaboalo.historystoreapp.domain.Product;
import com.icaboalo.historystoreapp.domain.Shopping;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by icaboalo on 10/8/2015.
 */
public class AddCaptureFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private Shopping shopping;

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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.shopping = new Shopping();

        return inflater.inflate(R.layout.fragment_add_product, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        productConversionText.setText("");
        productTypeSpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.shopping.setConversion(1);
        if(parent.getItemAtPosition(position).toString().compareTo("Kilogramo")==0){
            this.shopping.setType_uom("kilogram");
        }else if(parent.getItemAtPosition(position).toString().compareTo("Litro")==0){
            this.shopping.setType_uom("liter");
        }else if(parent.getItemAtPosition(position).toString().compareTo("Pieza")==0){
            this.shopping.setType_uom("piece");
        }
        productConversionText.setText(this.shopping.getConversionString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // TODO Auto-generated method stub


    }

    @OnClick(R.id.image_more_conversion)
    protected void onClickImageMoreConversion(){
        float conversion = this.shopping.getConversion();
        this.shopping.setConversion((float) (conversion + 1.00));
        productConversionText.setText(this.shopping.getConversionString());
    }

    @OnClick(R.id.image_less_conversion)
    protected void onClickImageLessConversion(){
        float conversion = this.shopping.getConversion();
        if(conversion > 1){
            this.shopping.setConversion((float) (conversion - 1.00));
        }
        productConversionText.setText(this.shopping.getConversionString());
    }

    public void setProductKey(String key){
        this.shopping.getProduct().setKey(key);
    }
}
