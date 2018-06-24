
package com.example.minapc.imdbapp.PojoModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Director {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Director() {
    }

    /**
     * 
     * @param id
     * @param name
     */
    public Director(String name, String id) {
        super();
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
