package com.icaboalo.historystoreapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.icaboalo.historystoreapp.R;
import com.icaboalo.historystoreapp.domain.Shopping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by richpolis on 15/10/15.
 */
public class ShoppingListRecyclerAdapter extends RecyclerView.Adapter<ShoppingListRecyclerAdapter.ShoppingListViewHolder> {

    List<Shopping> mShoppingList = new ArrayList<>();
    Context mContext;
    LayoutInflater mInflater;

    public ShoppingListRecyclerAdapter(List<Shopping> shoppingList, Context context) {
        mShoppingList = shoppingList;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ShoppingListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.product_list_item, parent, false);
        ShoppingListViewHolder viewHolder = new ShoppingListViewHolder(view,
                R.id.product_category_image, R.id.product_name_label, R.id.product_category_label,
                R.id.product_price_label, R.id.product_quantity_label);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ShoppingListViewHolder holder, int position) {
        Shopping shopping = mShoppingList.get(position);

        holder.setProductName(shopping.getProduct().getName());
        holder.setProductCategory(shopping.getProduct().getCategory().getName());
        holder.setProductPrice(shopping.getPrice());
        holder.setProductQuantity(shopping.getQuantity());
    }

    @Override
    public int getItemCount() {
        return mShoppingList.size();
    }

    public class ShoppingListViewHolder extends RecyclerView.ViewHolder{

        TextView mProductName;
        TextView mProductCategory;
        TextView mProductPrice;
        TextView mProductQuantity;
        ImageView mCategoryImage;

        public ShoppingListViewHolder(View itemView,
                                      int productCategoryImageId, int productNameId,
                                      int productCategoryLabelId, int productPriceLabelId,
                                      int productQuantityLabelId) {
            super(itemView);
            mProductName = (TextView) itemView.findViewById(productNameId);
            mProductCategory = (TextView) itemView.findViewById(productCategoryLabelId);
            mProductPrice = (TextView) itemView.findViewById(productPriceLabelId);
            mProductQuantity = (TextView) itemView.findViewById(productQuantityLabelId);
            mCategoryImage = (ImageView) itemView.findViewById(productCategoryImageId);
        }

        public void setProductName(String product_name) {
            this.mProductName.setText(product_name);
        }

        public void setProductCategory(String category) {
            this.mProductCategory.setText(category);
        }

        public void setProductPrice(double price) {
            this.mProductPrice.setText(String.valueOf(price));
        }

        public void setProductQuantity(int quantity) {
            this.mProductQuantity.setText(String.valueOf(quantity));
        }



    }
}

