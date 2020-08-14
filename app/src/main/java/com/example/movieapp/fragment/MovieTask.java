package com.example.movieapp.fragment;

import java.io.Serializable;

public class MovieTask implements Serializable {

    private int img_movie;
    private String tv_title, tv_desc;


    public MovieTask(int img_movie, String tv_title, String tv_desc) {
        this.img_movie = img_movie;
        this.tv_title = tv_title;
        this.tv_desc = tv_desc;
    }


    public int getImg_movie() {
        return img_movie;
    }

    public void setImg_movie(int img_movie) {
        this.img_movie = img_movie;
    }

    public String getTv_title() {
        return tv_title;
    }

    public void setTv_title(String tv_title) {
        this.tv_title = tv_title;
    }

    public String getTv_desc() {
        return tv_desc;
    }

    public void setTv_desc(String tv_desc) {
        this.tv_desc = tv_desc;
    }
}
