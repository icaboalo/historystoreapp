package com.icaboalo.historystoreapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.icaboalo.historystoreapp.R;
import com.icaboalo.historystoreapp.domain.PlaceListModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by icaboalo on 10/12/2015.
 */
public class PlacesRecyclerAdapter extends RecyclerView.Adapter<PlacesRecyclerAdapter.MyViewHolder> {

    List<PlaceListModel> mPlaceList = new ArrayList<>();
    Context mContext;
    LayoutInflater mInflater;
    MyViewHolder.MyViewHolderClick clickListener;

    public PlacesRecyclerAdapter(List<PlaceListModel> placeList, Context context, MyViewHolder.MyViewHolderClick clickListener) {
        mPlaceList = placeList;
        mContext = context;
        mInflater = LayoutInflater.from(context);
        this.clickListener = clickListener;
    }

    public void newData(List<PlaceListModel> newList){
        mPlaceList = newList;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = mInflater.inflate(R.layout.place_list_item_row, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(view, R.id.place, R.id.vendor, clickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PlaceListModel placeList = mPlaceList.get(position);
        holder.setPlace(placeList.getPlace());
        holder.setVendor(placeList.getVendor());
    }

    @Override
    public int getItemCount() {
        return mPlaceList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mPlace, mVendor;
        MyViewHolderClick mMyViewHolderClick;

        public MyViewHolder(View itemView, int placeTextId, int vendorTextId, MyViewHolderClick clickListener) {
            super(itemView);
            mPlace = (TextView) itemView.findViewById(placeTextId);
            mVendor = (TextView) itemView.findViewById(vendorTextId);
            mMyViewHolderClick = clickListener;
            itemView.setOnClickListener(this);
        }

        public void setPlace(String place) {
            mPlace.setText(place);
        }

        public void setVendor(String vendor){
            mVendor.setText(vendor);
        }

        @Override
        public void onClick(View v) {
            mMyViewHolderClick.onMyClick(v);
        }
        public interface MyViewHolderClick{
            void onMyClick(View item);
        }
    }
}
