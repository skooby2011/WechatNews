package com.skooby.wechanews.entity;

/**
 * Created by lenovo on 2016/8/19.
 */
public class News {
    private String id;
    private String title;
    private String source;
    private String image;

    public News() {}

    public News(String id, String title,String source, String image) {
        this.id = id;
        this.title = title;
        this.source = source;
        this.image = image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSource(String source){this.source = source;}

    public void setImage(String image) {
        this.image = image;
    }

    public String getId() {return id;}

    public String getTitle() {
        return title;
    }

    public String getSource(){return  source;}

    public String getImage() {
        return image;
    }

}
