package com.icaboalo.historystoreapp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icaboalo.historystoreapp.R;
import com.icaboalo.historystoreapp.domain.CaptureListModel;
import com.icaboalo.historystoreapp.io.ApiClient;
import com.icaboalo.historystoreapp.io.model.ListsModel;
import com.icaboalo.historystoreapp.ui.activity.EmptyFragmentActivity;
import com.icaboalo.historystoreapp.ui.adapter.CaptureRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by icaboalo on 10/6/2015.
 */
public class CaptureListFragment extends Fragment implements CaptureRecyclerAdapter.MyViewHolder.MyViewHolderClick {

    @Bind(R.id.capture_recycler_view)
    RecyclerView mCaptureRecyclerView;

    CaptureRecyclerAdapter captureRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return
                inflater.inflate(R.layout.fragment_capture_list, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onResume() {
        super.onResume();
        setUpRecyclerView();
        executeWithRetrofit();
    }

    @OnClick(R.id.add_capture)
    void addCapture(){
            Intent goToAddCapture = new Intent(getActivity(), EmptyFragmentActivity.class);
            startActivity(goToAddCapture);
    }

    List<CaptureListModel> createCaptureList(){
        List<CaptureListModel> captureList = new ArrayList<>();
        return captureList;
    }

    private void setUpRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        captureRecyclerAdapter = new CaptureRecyclerAdapter(createCaptureList(), getActivity(), this);
        mCaptureRecyclerView.setAdapter(captureRecyclerAdapter);
        mCaptureRecyclerView.setLayoutManager(linearLayoutManager);
    }

    public void executeWithRetrofit(){
        ApiClient.searchList(new Callback<ArrayList<ListsModel>>() {
            @Override
            public void success(ArrayList<ListsModel> listsModels, Response response) {
                List<CaptureListModel> captureList = new ArrayList<CaptureListModel>();
                for (int i = 0; i < listsModels.size(); i++) {
                    String date = listsModels.get(i).getDate();
                    String vendor = listsModels.get(i).getPlace().getVendor().getVendorName();
                    String price = listsModels.get(i).getTotal();
                    captureList.add(new CaptureListModel(date, price, vendor));
                }
                captureRecyclerAdapter.newData(captureList);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public void onClick(View view) {
//        Toast.makeText(getActivity(), "clicked " + view.toString(), Toast.LENGTH_SHORT).show();
    }
}
