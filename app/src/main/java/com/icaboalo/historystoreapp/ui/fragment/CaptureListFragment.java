package com.icaboalo.historystoreapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icaboalo.historystoreapp.R;

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
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, getActivity());
    }
}
