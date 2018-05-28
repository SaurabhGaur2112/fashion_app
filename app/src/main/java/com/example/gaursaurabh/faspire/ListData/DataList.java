package com.example.gaursaurabh.faspire.ListData;

/**
 * Created by Saurabh Gaur on 2/6/2017.
 */
public class DataList {

    private String id,name,image;

    public DataList(String id,String name,String image){
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
