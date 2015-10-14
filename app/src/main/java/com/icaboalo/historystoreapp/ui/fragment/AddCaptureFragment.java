package com.icaboalo.historystoreapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import com.icaboalo.historystoreapp.R;
import com.icaboalo.historystoreapp.io.ApiClient;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by icaboalo on 10/8/2015.
 */
public class AddCaptureFragment extends Fragment {

    @Bind(R.id.product_name_input)
    EditText mProductNameInput;

    @Bind(R.id.category_spinner)
    Spinner productCategorySpinner;

    @Bind(R.id.type_spinner)
    Spinner productTypeSpinner;

    @Bind(R.id.vendor_spinner)
    Spinner productVendorSpinner;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_product, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        ApiClient client = new ApiClient();
        client.postProduct("", "test", "", new Callback<Response>() {

            @Override
            public void success(Response response, Response response2) {

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        
    }
}
