package com.icaboalo.historystoreapp.domain;

/**
 * Created by richpolis on 12/10/15.
 */
public class Shopping {
    private int id;
    private Product product;
    private double price;
    private int quantity;

    public Shopping(){
        this.id = 0;
        this.product = new Product();
        this.price = 0.0;
        this.quantity = 0;
    }

    public Shopping(Product product) {
        this.id = 0;
        this.product = product;
        this.price = 0.0;
        this.quantity = 0;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
