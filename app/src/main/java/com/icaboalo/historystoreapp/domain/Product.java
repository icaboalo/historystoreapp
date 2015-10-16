package com.icaboalo.historystoreapp.domain;

/**
 * Created by richpolis on 12/10/15.
 */
public class Product {

    private int id;
    private String key;
    private String name;
    private Category category;
    private String type_uom;
    private float conversion;


    public Product(){
        this.id = 0;
        this.key = "";
        this.name = "";
        this.category = new Category();
    }

    public Product(String key, String name, Category category) {
        this.key = key;
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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
