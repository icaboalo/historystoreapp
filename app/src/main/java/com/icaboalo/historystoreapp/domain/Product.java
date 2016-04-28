package com.icaboalo.historystoreapp.domain;

/**
 * Created by richpolis on 12/10/15.
 */
public class Product {

    private int id;
    private String key;
    private String name;
    private Category category;

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
}
