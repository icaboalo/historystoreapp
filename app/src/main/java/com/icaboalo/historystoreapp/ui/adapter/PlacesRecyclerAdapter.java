package com.icaboalo.historystoreapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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

    public PlacesRecyclerAdapter(List<PlaceListModel> placeList, Context context) {
        mPlaceList = placeList;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.place_list_item_row, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view, R.id.place, new MyViewHolder.MyViewHolderClick() {
            @Override
            public void onMyClick(View item) {
                Toast.makeText(mContext, "success", Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PlaceListModel placeList = mPlaceList.get(position);
        holder.setPlace(placeList.getPlace());
    }

    @Override
    public int getItemCount() {
        return mPlaceList.size();
    }

    public void setData(List<PlaceListModel> newList) {
        mPlaceList = newList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mPlace;
        MyViewHolderClick mMyViewHolderClick;

        public MyViewHolder(View itemView, int placeTextId, MyViewHolderClick clickListener) {
            super(itemView);
            mPlace = (TextView) itemView.findViewById(placeTextId);
            mMyViewHolderClick = clickListener;
            itemView.setOnClickListener(this);
        }

        public void setPlace(String place) {
            mPlace.setText(place);
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
