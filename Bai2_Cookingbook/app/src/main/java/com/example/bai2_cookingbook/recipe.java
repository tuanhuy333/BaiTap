package com.example.bai2_cookingbook;

public class recipe {
    int image;
    String name;
    String url;


    public recipe(int image, String name, String url) {
        this.image = image;
        this.name = name;
        this.url = url;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
