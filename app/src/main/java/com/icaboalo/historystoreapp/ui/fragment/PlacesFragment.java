package com.icaboalo.historystoreapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.icaboalo.historystoreapp.R;
import com.icaboalo.historystoreapp.domain.PlaceListModel;
import com.icaboalo.historystoreapp.ui.adapter.PlacesRecyclerAdapter;
import com.icaboalo.historystoreapp.util.VUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by icaboalo on 10/12/2015.
 */
public class PlacesFragment extends Fragment implements PlacesRecyclerAdapter.MyViewHolder.MyViewHolderClick {

    @Bind(R.id.places_list)
    RecyclerView mPlacesRecyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

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
        place.add(new PlaceListModel("Av. Magnocentro", "Walmart"));
        place.add(new PlaceListModel("Blv. Anahuac", "Comercial Mexicana"));
        return place;
    }

    private void setUpRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        PlacesRecyclerAdapter placesRecyclerAdapter = new PlacesRecyclerAdapter(addPlace(), getActivity(), this);
        mPlacesRecyclerView.setLayoutManager(linearLayoutManager);
        mPlacesRecyclerView.setAdapter(placesRecyclerAdapter);
    }

    @Override
    public void onMyClick(View item) {
        VUtil.replaceFragment(new AddCaptureFragment(), getFragmentManager());
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_settings:
                return true;
            case R.id.action_add_place:
                showDialog();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showDialog() {
        FragmentManager fragmentManager = getFragmentManager();
        PlaceDialogFragment placeDialogFragment = new PlaceDialogFragment().newInstance("Add Place");
        placeDialogFragment.show(fragmentManager, "fragment_add_place");
    }
}
