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

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;
import com.koma.weather.util.WindInfoConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by koma on 7/19/17.
 */
public class NowInfo implements Serializable {
    private static final long serialVersionUID = 7523967970034938910L;
    /**
     * weather condition info
     */
    @SerializedName("cond")
    private ConditionInfo conditionInfo;
    /**
     * sendible temperature
     */
    @SerializedName("fl")
    private String sendibleTemp;
    /**
     * relative humidity
     */
    @SerializedName("hum")
    private String humidity;
    /**
     * amount of precipitation
     */
    @SerializedName("pcpn")
    private String precipitation;
    /**
     * air pressure
     */
    @SerializedName("pres")
    private String airPressure;
    /**
     * temperature
     */
    @SerializedName("tmp")
    private String temperature;
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("cond :").append(this.conditionInfo.toString())
                .append(",fl :").append(this.sendibleTemp)
                .append(",hum :").append(this.humidity)
                .append(",pcpn :").append(this.precipitation)
                .append(",pres :").append(this.airPressure)
                .append(",temp :").append(this.temperature)
                .append(",vis :").append(this.mVisibility)
                .append(",wind :").append(this.mWindInfo.toString());

        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NowInfo nowInfo = (NowInfo) o;

        return conditionInfo.equals(nowInfo.conditionInfo)
                && TextUtils.equals(temperature, nowInfo.temperature)
                && TextUtils.equals(sendibleTemp, nowInfo.sendibleTemp)
                && TextUtils.equals(humidity, nowInfo.humidity)
                && TextUtils.equals(precipitation, nowInfo.precipitation)
                && TextUtils.equals(airPressure, nowInfo.airPressure)
                && TextUtils.equals(temperature, nowInfo.temperature)
                && TextUtils.equals(mVisibility, nowInfo.mVisibility)
                && mWindInfo.equals(nowInfo.mWindInfo);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[]{conditionInfo, sendibleTemp, humidity, precipitation,
                airPressure, temperature, mVisibility, mWindInfo});
    }

    public String getSendibleTemp() {
        return this.sendibleTemp;
    }

    public void setSendibleTemp(String sendibleTemp) {
        this.sendibleTemp = sendibleTemp;
    }

    public String getHumidity() {
        return this.humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPrecipitation() {
        return this.precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    public String getAirPressure() {
        return this.airPressure;
    }

    public void setAirPressure(String airPressure) {
        this.airPressure = airPressure;
    }

    public String getTemperature() {
        return this.temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getVisibility() {
        return this.mVisibility;
    }

    public void setVisibility(String mVisibility) {
        this.mVisibility = mVisibility;
    }

    public WindInfo getMWindInfo() {
        return this.mWindInfo;
    }

    public void setMWindInfo(WindInfo mWindInfo) {
        this.mWindInfo = mWindInfo;
    }

    public void setConditionInfo(ConditionInfo conditionInfo) {
        this.conditionInfo = conditionInfo;
    }

    public ConditionInfo getConditionInfo() {
        return this.conditionInfo;
    }

    public String getMVisibility() {
        return this.mVisibility;
    }

    public void setMVisibility(String mVisibility) {
        this.mVisibility = mVisibility;
    }
}
