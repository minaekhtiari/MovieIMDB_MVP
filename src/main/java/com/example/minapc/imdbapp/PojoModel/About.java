
package com.example.minapc.imdbapp.PojoModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class About {

    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("serverTime")
    @Expose
    private String serverTime;

    /**
     * No args constructor for use in serialization
     * 
     */
    public About() {
    }

    /**
     * 
     * @param serverTime
     * @param version
     */
    public About(String version, String serverTime) {
        super();
        this.version = version;
        this.serverTime = serverTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

}
