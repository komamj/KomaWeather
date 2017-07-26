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
import com.koma.weather.util.WindInfoConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

import java.io.Serializable;

/**
 * Created by koma on 7/19/17.
 */
@Entity(nameInDb = "now_info")
public class NowInfo implements Serializable {
    private static final long serialVersionUID = 7523967970034938910L;
    @Id(autoincrement = true)
    private Long id;

    /**
     * weather condition info
     */
    @Transient
    @SerializedName("cond")
    private ConditionInfo conditionInfo;
    /**
     * sendible temperature
     */
    @Property(nameInDb = "fl")
    @SerializedName("fl")
    private String sendibleTemp;
    /**
     * relative humidity
     */
    @Property(nameInDb = "hum")
    @SerializedName("hum")
    private String humidity;
    /**
     * amount of precipitation
     */
    @Property(nameInDb = "pcpn")
    @SerializedName("pcpn")
    private String precipitation;
    /**
     * air pressure
     */
    @Property(nameInDb = "pres")
    @SerializedName("pres")
    private String airPressure;
    /**
     * temperature
     */
    @Property(nameInDb = "tmp")
    @SerializedName("tmp")
    private String temperature;
    /**
     * visibility
     */
    @Property(nameInDb = "vis")
    @SerializedName("vis")
    private String mVisibility;
    /**
     * wind info
     */
    @Convert(converter = WindInfoConverter.class, columnType = String.class)
    @SerializedName("wind")
    private WindInfo mWindInfo;

    @Generated(hash = 333988543)
    public NowInfo(Long id, String sendibleTemp, String humidity,
                   String precipitation, String airPressure, String temperature,
                   String mVisibility, WindInfo mWindInfo) {
        this.id = id;
        this.sendibleTemp = sendibleTemp;
        this.humidity = humidity;
        this.precipitation = precipitation;
        this.airPressure = airPressure;
        this.temperature = temperature;
        this.mVisibility = mVisibility;
        this.mWindInfo = mWindInfo;
    }

    @Generated(hash = 289332803)
    public NowInfo() {
    }

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

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMVisibility() {
        return this.mVisibility;
    }

    public void setMVisibility(String mVisibility) {
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
}
