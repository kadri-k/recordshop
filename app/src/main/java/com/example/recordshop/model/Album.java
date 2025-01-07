package com.example.recordshop.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.recordshop.BR;
import com.google.gson.annotations.SerializedName;

public class Album extends BaseObservable {

    @SerializedName("id")
    private long id;
    @SerializedName("title")
    private String title;
    @SerializedName("artist")
    private String artist;
    @SerializedName("genre")
    private String genre;
    @SerializedName("stock")
    private int stock;
    @SerializedName("price")
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
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
        notifyPropertyChanged(BR.artist);
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    @Bindable
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
        notifyPropertyChanged(BR.stock);
    }

    @Bindable
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
        notifyPropertyChanged(BR.price);
    }

    @Bindable
    public String getFormattedPrice() {
        if (price != null) {
            return String.format("£%.2f", price); // Formats the price
        } else {
            return "£0.00"; // Default value if price is null
        }
    }
}


