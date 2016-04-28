package com.icaboalo.historystoreapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.icaboalo.historystoreapp.R;
import com.icaboalo.historystoreapp.domain.CaptureListModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by icaboalo on 10/6/2015.
 */
public class CaptureRecyclerAdapter extends RecyclerView.Adapter<CaptureRecyclerAdapter.MyViewHolder> {

    List<CaptureListModel> mCapturedList = new ArrayList<>();
    Context mContext;
    LayoutInflater mInflater;
    MyViewHolder.MyViewHolderClick mClickListener;

    public CaptureRecyclerAdapter(List<CaptureListModel> capturedList, Context context, MyViewHolder.MyViewHolderClick clickListener) {
        mCapturedList = capturedList;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mClickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_row_capture_list, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view, R.id.capture_date, R.id.capture_price, R.id.capture_place, R.id.capture_finished, mClickListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CaptureListModel capturedList = mCapturedList.get(position);
        holder.setCaptureDate(capturedList.getCaptureDate());
        holder.setCapturePrice(capturedList.getCapturePrice());
        holder.setCapturePlace(capturedList.getCapturePlace());
    }

    public void newData(List<CaptureListModel> newList){
        mCapturedList = newList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mCapturedList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mCaptureDate, mCapturePrice, mCapturePlace;
        ImageView mCaptureImage;
        MyViewHolderClick mMyOnClick;

        public MyViewHolder(View itemView, int captureDateId, int capturePriceId, int capturePlaceId, int captureImageId, MyViewHolderClick clickListener) {
            super(itemView);
            mCaptureDate = (TextView) itemView.findViewById(captureDateId);
            mCapturePrice = (TextView) itemView.findViewById(capturePriceId);
            mCapturePlace = (TextView) itemView.findViewById(capturePlaceId);
            mCaptureImage = (ImageView) itemView.findViewById(captureImageId);
            mMyOnClick = clickListener;
            itemView.setOnClickListener(this);
        }

        public void setCaptureDate(String captureDate) {
            mCaptureDate.setText(captureDate);
        }

        public void setCapturePrice(String capturePrice) {
            mCapturePrice.setText(capturePrice);
        }

        public void setCapturePlace(String capturePlace) {
            mCapturePlace.setText(capturePlace);
        }

        @Override
        public void onClick(View v) {
            mMyOnClick.onClick(v);
        }
        public interface MyViewHolderClick{
            void onClick(View view);
        }
    }
}
