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

import java.io.Serializable;

/**
 * Created by koma on 7/19/17.
 */

public class NowInfo implements Serializable {
    /**
     * weather condition info
     */
    @SerializedName("cond")
    private WeatherConditionInfo mConditionInfo;
    /**
     * sendible temperature
     */
    @SerializedName("fl")
    private String mSendibleTemp;
    /**
     * relative humidity
     */
    @SerializedName("hum")
    private String mHumidity;
    /**
     * amount of precipitation
     */
    @SerializedName("pcpn")
    private String mPrecipitation;
    /**
     * air pressure
     */
    @SerializedName("pres")
    private String mAirPressure;
    /**
     * temperature
     */
    @SerializedName("tmp")
    private String mTemperature;
    /**
     * visibility
     */
    @SerializedName("vis")
    private String mVisibility;
    /**
     * wind info
     */
    @SerializedName("wind")
    private WindInfo mWindInfo;

    public void setConditionInfo(WeatherConditionInfo conditionInfo) {
        this.mConditionInfo = conditionInfo;
    }

    public WeatherConditionInfo getConditionInfo() {
        return mConditionInfo;
    }

    public void setSendibleTemp(String temperature) {
        this.mSendibleTemp = temperature;
    }

    public String getSendibleTemp() {
        return this.mSendibleTemp;
    }

    public void setHumidity(String humidity) {
        this.mHumidity = humidity;
    }

    public String getHumidity() {
        return this.mHumidity;
    }

    public void setPrecipitation(String precipitation) {
        this.mPrecipitation = precipitation;
    }

    public String getPrecipitation() {
        return this.mPrecipitation;
    }

    public void setAirPressure(String airPressure) {
        this.mAirPressure = airPressure;
    }

    public String getAirPressure() {
        return this.mAirPressure;
    }

    public void setTemperature(String temperature) {
        this.mTemperature = temperature;
    }

    public String getTemperature() {
        return this.mTemperature;
    }

    public void setVisibility(String visibility) {
        this.mVisibility = visibility;
    }

    public String getVisibility() {
        return this.mVisibility;
    }

    public void setWindInfo(WindInfo windInfo) {
        this.mWindInfo = windInfo;
    }

    public WindInfo getWindInfo() {
        return this.mWindInfo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("cond :").append(this.mConditionInfo.toString())
                .append(",fl :").append(this.mSendibleTemp)
                .append(",hum :").append(this.mHumidity)
                .append(",pcpn :").append(this.mPrecipitation)
                .append(",pres :").append(this.mAirPressure)
                .append(",temp :").append(this.mTemperature)
                .append(",vis :").append(this.mVisibility)
                .append(",wind :").append(this.mWindInfo.toString());

        return builder.toString();
    }
}
