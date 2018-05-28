package com.example.gaursaurabh.faspire.ListData;

/**
 * Created by Saurabh Gaur on 2/6/2017.
 */
public class FeedItem {

    private String id,image,headline,description,link,imageVideo,represent;

    public FeedItem(){

    }

    public FeedItem(String id,String image,String headline,String description,String link,String imageVideo,String represent){
        this.id = id;
        this.image = image;
        this.headline = headline;
        this.description = description;
        this.link = link;
        this.imageVideo = imageVideo;
        this.represent = represent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImageVideo() {
        return imageVideo;
    }

    public void setImageVideo(String imageVideo) {
        this.imageVideo = imageVideo;
    }

    public String getRepresent() {
        return represent;
    }

    public void setRepresent(String represent) {
        this.represent = represent;
    }
}
