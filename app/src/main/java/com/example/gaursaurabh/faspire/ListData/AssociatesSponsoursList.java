package com.example.gaursaurabh.faspire.ListData;

/**
 * Created by Saurabh Gaur on 2/10/2017.
 */
public class AssociatesSponsoursList {

    private String image,name,link;

    public AssociatesSponsoursList(String image,String name,String link){

        this.image = image;
        this.name = name;
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
