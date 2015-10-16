package com.icaboalo.historystoreapp.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.icaboalo.historystoreapp.R;
import com.icaboalo.historystoreapp.domain.retrofit.CategoryModel;
import com.icaboalo.historystoreapp.domain.retrofit.ProductModel;
import com.icaboalo.historystoreapp.io.ApiClient;
import com.icaboalo.historystoreapp.ui.adapter.PlacesRecyclerAdapter;
import com.icaboalo.historystoreapp.ui.adapter.ProductListRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ProductListActivity extends AppCompatActivity {

    @Bind(R.id.app_bar)
    Toolbar mToolBar;

    @Bind(R.id.product_recycler_view)
    RecyclerView mProductRecyclerView;

    ProductListRecyclerAdapter productListRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        ButterKnife.bind(this);
        setSupportActionBar(mToolBar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public void onResume() {
        super.onResume();
        setUpRecyclerView();
        executeWithRetrofit();
    }

    List<ProductModel> createProductList(){
        List<ProductModel> productList = new ArrayList<>();
        return productList;
    }

    private void setUpRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        productListRecyclerAdapter= new ProductListRecyclerAdapter(createProductList(), this);
        mProductRecyclerView.setAdapter(productListRecyclerAdapter);
        mProductRecyclerView.setLayoutManager(linearLayoutManager);
    }

    public void executeWithRetrofit(){
        ApiClient.searchProductList(new Callback<ArrayList<ProductModel>>() {
            @Override
            public void success(ArrayList<ProductModel> listsModels, Response response) {
                productListRecyclerAdapter.newData(listsModels);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

}
