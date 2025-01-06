package com.example.recordshop.model;

import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

public class Album {
    private long id;
    private String title;
    private String artist;
    private String genre;
    private int stock;
    private Double price;

    public Album(long id, Double price, String title, String artist, String genre, int stock) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.stock = stock;
    }
    public Album() {
    }

    @Bindable
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Bindable
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Bindable
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Bindable
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}


