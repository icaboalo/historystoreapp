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
import com.icaboalo.historystoreapp.domain.CaptureListModel;
import com.icaboalo.historystoreapp.domain.retrofit.ListsModel;
import com.icaboalo.historystoreapp.domain.retrofit.ShoppingListModel;
import com.icaboalo.historystoreapp.io.ApiClient;
import com.icaboalo.historystoreapp.ui.adapter.CaptureRecyclerAdapter;
import com.icaboalo.historystoreapp.ui.adapter.ShoppingListRecyclerAdapter;

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

    @Bind(R.id.shopping_recycler_view)
    RecyclerView mShoppingRecyclerView;

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

    List<ShoppingListModel> createShoppingList(){
        List<ShoppingListModel> shoppingList = new ArrayList<>();
        return shoppingList;
    }

    private void setUpRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        ShoppingListRecyclerAdapter shoppingListAdapter= new ShoppingListRecyclerAdapter(createShoppingList(), this);
        mShoppingRecyclerView.setAdapter(shoppingListAdapter);
        mShoppingRecyclerView.setLayoutManager(linearLayoutManager);
    }

    public void executeWithRetrofit(){
        ApiClient.searchList(new Callback<ArrayList<ShoppingListModel>>() {
            @Override
            public void success(ArrayList<ShoppingListModel> listsModels, Response response) {
                List<ShoppingListModel> shoppingList = new ArrayList<ShoppingListModel>();
                for (int i = 0; i < shoppingList.size(); i++) {
                    String date = listsModels.get(i).getDate();
                    String vendor = listsModels.get(i).getPlace().getVendor().getVendorName();
                    String price = listsModels.get(i).getTotal();
                    captureList.add(new CaptureListModel(date, price, vendor));
                }
                mShoppingRecyclerView.newData(captureList);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

}
