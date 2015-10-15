package com.icaboalo.historystoreapp.domain;

/**
 * Created by richpolis on 12/10/15.
 */
public class Category {
    private int id;
    private String name;
    private String image;

    public Category(){
        this.id = 0;
        this.name = "";
        this.image = "";
    }

    public Category(int id, String name, String urlImage) {
        this.id = id;
        this.name = name;
        this.image = urlImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
