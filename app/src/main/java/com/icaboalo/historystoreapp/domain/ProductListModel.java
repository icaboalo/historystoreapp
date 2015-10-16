package com.icaboalo.historystoreapp.domain;

/**
 * Created by icaboalo on 10/15/2015.
 */
public class ProductListModel {

    public ProductListModel(String productName, String productType, String productQuantity, String productPrice) {
        this.productName = productName;
        this.productType = productType;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    String productName;
    String productType;
    String productQuantity;
    String productPrice;
    String productImage;

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }
}
