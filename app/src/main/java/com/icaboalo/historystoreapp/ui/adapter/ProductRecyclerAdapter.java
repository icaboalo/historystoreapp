package com.icaboalo.historystoreapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.icaboalo.historystoreapp.R;
import com.icaboalo.historystoreapp.domain.ProductListModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by icaboalo on 10/15/2015.
 */
public class ProductRecyclerAdapter extends RecyclerView.Adapter<ProductRecyclerAdapter.MyViewHolder> {

    List<ProductListModel> mProductList = new ArrayList<>();
    Context mContext;
    LayoutInflater mInflater;

    public ProductRecyclerAdapter(List<ProductListModel> productList, Context context) {
        mProductList = productList;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_row_product_list, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view, R.id.product_name, R.id.product_category, R.id.product_quantity,
                R.id.product_price, R.id.product_image);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ProductListModel productListModel = mProductList.get(position);
        holder.setProductName(productListModel.getProductName());
        holder.setProductType(productListModel.getProductCategory());
        holder.setProductQuantity(productListModel.getProductQuantity());
        holder.setProductPrice(productListModel.getProductPrice());
    }

    @Override
    public int getItemCount() {
        return mProductList.size();
    }

    public void newData(List<ProductListModel> newDataList){
        mProductList = newDataList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView mProductImage;
        TextView mProductName, mProductType, mProductQuantity, mProductPrice;

        public MyViewHolder(View itemView, int productNameId, int productTypeId, int productQuantityId, int productPriceId, int productImageId) {
            super(itemView);
            mProductName = (TextView) itemView.findViewById(productNameId);
            mProductType = (TextView) itemView.findViewById(productTypeId);
            mProductQuantity = (TextView) itemView.findViewById(productQuantityId);
            mProductPrice = (TextView) itemView.findViewById(productPriceId);
            mProductImage = (ImageView) itemView.findViewById(productImageId);
        }

        public void setProductName(String name){
            mProductName.setText(name);
        }

        public void setProductType(String type){
            mProductType.setText(type);
        }

        public void setProductQuantity(String quantity){
            mProductQuantity.setText(quantity);
        }

        public void setProductPrice(String price){
            mProductPrice.setText(price);
        }
    }
}
