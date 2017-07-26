/*
 * Copyright 2017 Koma
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.koma.weather.data.model;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by koma on 7/19/17.
 */
public class WindInfo implements Serializable {
    private static final long serialVersionUID = 7523967970034938920L;
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

    public WindInfo(String mWindDegree, String mWindDirection, String mWindPower,
            String mWindSpeed) {
        this.mWindDegree = mWindDegree;
        this.mWindDirection = mWindDirection;
        this.mWindPower = mWindPower;
        this.mWindSpeed = mWindSpeed;
    }

    public WindInfo() {
    }

    public String getWindDegree() {
        return this.mWindDegree;
    }

    public void setWindDegree(String windDegree) {
        this.mWindDegree = windDegree;
    }

    public String getWindDirection() {
        return this.mWindDirection;
    }

    public void setWindDirection(String windDirection) {
        this.mWindDirection = windDirection;
    }

    public String getWindPower() {
        return this.mWindPower;
    }

    public void setWindPower(String windPower) {
        this.mWindPower = windPower;
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
