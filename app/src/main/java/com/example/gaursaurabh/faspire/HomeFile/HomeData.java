package com.example.gaursaurabh.faspire.HomeFile;

/**
 * Created by Saurabh Gaur on 2/6/2017.
 */
public class HomeData {

    private String name,category,image;

    public HomeData(String name,String category,String image){
        this.name = name;
        this.category = category;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
