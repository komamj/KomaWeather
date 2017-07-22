package com.koma.weather.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by koma on 7/19/17.
 */

public class WindInfo implements Serializable {
    /**
     * the degree of wind direction
     */
    @SerializedName("deg")
    private String mWindDegree;
    /**
     * wind direction
     */
    @SerializedName("dir")
    private String mWindDirection;
    /**
     * wind power
     */
    @SerializedName("sc")
    private String mWindPower;
    /**
     * wind speed
     */
    @SerializedName("spd")
    private String mWindSpeed;

    public void setWindDegree(String windDegree) {
        this.mWindDegree = windDegree;
    }

    public String getWindDegree() {
        return this.mWindDegree;
    }

    public void setWindDirection(String windDirection) {
        this.mWindDirection = windDirection;
    }

    public String getWindDirection() {
        return this.mWindDirection;
    }

    public void setWindPower(String windPower) {
        this.mWindPower = windPower;
    }

    public String getWindPower() {
        return this.mWindPower;
    }

    public void setWindSepeed(String windSepeed) {
        this.mWindSpeed = windSepeed;
    }

    public String getWindSpeed() {
        return this.mWindSpeed;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("degree :").append(this.mWindDegree).append(",direction :")
                .append(this.mWindDirection).append(",power :").append(this.mWindPower)
                .append(",speed :").append(this.mWindSpeed);
        return builder.toString();
    }
}
