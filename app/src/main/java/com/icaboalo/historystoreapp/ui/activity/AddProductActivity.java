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
import com.icaboalo.historystoreapp.domain.ProductListModel;
import com.icaboalo.historystoreapp.ui.adapter.ProductRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddProductActivity extends AppCompatActivity {

    @Bind(R.id.app_bar)
    Toolbar mToolbar;

    @Bind(R.id.product_recycler_view)
    RecyclerView mProductRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpRecyclerView();
    }

    List<ProductListModel> addProduct(){
        List<ProductListModel> productList = new ArrayList<>();
        productList.add(new ProductListModel("Test", "Test", "test", "test"));
        return productList;
    }

    private void setUpRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ProductRecyclerAdapter recyclerAdapter = new ProductRecyclerAdapter(addProduct(), this);
        mProductRecyclerView.setLayoutManager(linearLayoutManager);
        mProductRecyclerView.setAdapter(recyclerAdapter);
    }
}
