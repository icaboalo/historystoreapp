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
import com.icaboalo.historystoreapp.domain.PlaceListModel;
import com.icaboalo.historystoreapp.ui.adapter.PlacesRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by icaboalo on 10/12/2015.
 */
public class PlacesFragment extends Fragment {

    @Bind(R.id.places_list)
    RecyclerView mPlacesRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_places_list, container, false);
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

    List<PlaceListModel> addPlace(){
        List<PlaceListModel> place = new ArrayList<>();
        place.add(new PlaceListModel("Bodega Aurrera"));
        place.add(new PlaceListModel("Comercial Mexicana"));
        return place;
    }

    private void setUpRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        PlacesRecyclerAdapter placesRecyclerAdapter = new PlacesRecyclerAdapter(addPlace(), getActivity());
        mPlacesRecyclerView.setLayoutManager(linearLayoutManager);
        mPlacesRecyclerView.setAdapter(placesRecyclerAdapter);
    }
}
