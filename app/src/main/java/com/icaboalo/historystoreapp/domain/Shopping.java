package com.icaboalo.historystoreapp.domain;

/**
 * Created by richpolis on 12/10/15.
 */
public class Shopping {
    private int id;
    private Product product;
    private String type_uom;
    private double price;
    private float conversion;
    private int quantity;
    private double total;

    public Shopping(){
        this.id = 0;
        this.product = new Product();
        this.type_uom = "";
        this.price = 0.0;
        this.conversion = 0;
        this.quantity = 0;
        this.total = 0;
    }

    public Shopping(Product product) {
        this.id = 0;
        this.product = product;
        this.type_uom = "";
        this.price = 0.0;
        this.conversion = 0;
        this.quantity = 0;
        this.total = 0;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getType_uom() {
        return type_uom;
    }

    public void setType_uom(String type_uom) {
        this.type_uom = type_uom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getConversion() {
        return conversion;
    }

    public void setConversion(float conversion) {
        this.conversion = Math.round(conversion);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getConversionString() {
        if(this.type_uom.compareTo("kilogram")==0){
            if(this.conversion >= 1){
                return this.conversion + "kg";
            }else{
                return (this.conversion * 1000) + "gr";
            }
        }else if(this.type_uom.compareTo("liter")==0){
            if(this.conversion >= 1){
                return this.conversion + "lt";
            }else{
                return (this.conversion * 1000) + "ml";
            }
        }else{
            return this.conversion + "pz";
        }
    }
}
