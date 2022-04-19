package com.mohamed.healthyfood;

public class FruitModule {

    private String fruit_name, image_url, info;

    public FruitModule() {}

    public String getFruit_name() { return fruit_name; }

    public void setFruit_name(String fruit_name) {
        this.fruit_name = fruit_name;
    }

    public String getImage_url() { return image_url; }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getInfo() { return info; }

    public void setInfo(String info) {
        this.info = info;
    }
}
