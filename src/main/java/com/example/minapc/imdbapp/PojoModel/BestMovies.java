
package com.example.minapc.imdbapp.PojoModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BestMovies {

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("about")
    @Expose
    private About about;

    /**
     * No args constructor for use in serialization
     * 
     */
    public BestMovies() {
    }

    /**
     * 
     * @param about
     * @param data
     */
    public BestMovies(Data data, About about) {
        super();
        this.data = data;
        this.about = about;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public About getAbout() {
        return about;
    }

    public void setAbout(About about) {
        this.about = about;
    }

}
