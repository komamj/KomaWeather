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

public class HourlyForecastInfo implements Serializable {
    /**
     * weather situation
     */
    @SerializedName("cond")
    private WeatherConditionInfo mConditionInfo;
    /**
     * date
     */
    @SerializedName("date")
    private String mDate;
    /**
     * relative humidity
     */
    @SerializedName("hum")
    public String mHumidity;
    /**
     * precipitation probability
     */
    @SerializedName("pop")
    public String mPcpnProbability;
    /**
     * air pressure
     */
    @SerializedName("pres")
    public String mAirPressure;
    /**
     * temperature
     */
    @SerializedName("tmp")
    private String mTemperature;

    @SerializedName("wind")
    public WindInfo mWindInfo;

    public void setConditionInfo(WeatherConditionInfo conditionInfo) {
        this.mConditionInfo = conditionInfo;
    }

    public WeatherConditionInfo getConditionInfo() {
        return this.mConditionInfo;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public String getDate() {
        return this.mDate;
    }

    public void setHumidity(String humidity) {
        this.mHumidity = humidity;
    }

    public String getHumidity() {
        return this.mHumidity;
    }

    public void setPcpnProbability(String pcpnProbability) {
        this.mPcpnProbability = pcpnProbability;
    }

    public String getPcpnProbability() {
        return this.mPcpnProbability;
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

    public void setWindInfo(WindInfo windInfo) {
        this.mWindInfo = windInfo;
    }

    public WindInfo getWindInfo() {
        return this.mWindInfo;
    }
}
