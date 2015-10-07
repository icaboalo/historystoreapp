package com.icaboalo.historystoreapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by icaboalo on 10/6/2015.
 */
public class CaptureRecyclerAdapter extends RecyclerView.Adapter<CaptureRecyclerAdapter.MyViewHolder> {

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mCaptureDate, mCapturePrice, mCapturePlace;
        ImageView mCaptureImage;

        public MyViewHolder(View itemView, int captureDateId, int capturePriceId, int capturePlaceId, int captureImageId) {
            super(itemView);
            mCaptureDate = (TextView) itemView.findViewById(captureDateId);
            mCapturePrice = (TextView) itemView.findViewById(capturePriceId);
            mCapturePlace = (TextView) itemView.findViewById(capturePlaceId);
            mCaptureImage = (ImageView) itemView.findViewById(captureImageId);
        }


    }
}
