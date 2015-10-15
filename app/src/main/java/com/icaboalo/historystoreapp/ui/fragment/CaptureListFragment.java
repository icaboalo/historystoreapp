package com.icaboalo.historystoreapp.ui.fragment;

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
import com.icaboalo.historystoreapp.ui.adapter.CaptureRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by icaboalo on 10/6/2015.
 */
public class CaptureListFragment extends Fragment {

    @Bind(R.id.capture_recycler_view)
    RecyclerView mCaptureRecyclerView;



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
    }

    List<CaptureListModel> createCaptureList(){
        List<CaptureListModel> captureList = new ArrayList<>();
        captureList.add(new CaptureListModel("13-10-2015", "$200", "Comercial Mexicana"));
        captureList.add(new CaptureListModel("13-10-2015", "$200", "Comercial Mexicana"));
        captureList.add(new CaptureListModel("13-10-2015", "$200", "Comercial Mexicana"));
        return captureList;
    }

    private void setUpRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        CaptureRecyclerAdapter captureRecyclerAdapter = new CaptureRecyclerAdapter(createCaptureList(), getActivity());
        mCaptureRecyclerView.setAdapter(captureRecyclerAdapter);
        mCaptureRecyclerView.setLayoutManager(linearLayoutManager);
    }
}
