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
import com.koma.weather.util.ConditionInfoConverter;
import com.koma.weather.util.WindInfoConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by koma on 7/19/17.
 */
@Entity(nameInDb = "hourly_forecast")
public class HourlyForecastInfo implements Serializable {
    private static final long serialVersionUID = 7523967970034938909L;
    @Id(autoincrement = true)
    private Long id;
    /**
     * relative humidity
     */
    @Property(nameInDb = "hum")
    @SerializedName("hum")
    public String mHumidity;
    /**
     * precipitation probability
     */
    @Property(nameInDb = "pop")
    @SerializedName("pop")
    public String mPcpnProbability;
    /**
     * air pressure
     */
    @Property(nameInDb = "pres")
    @SerializedName("pres")
    public String mAirPressure;
    /**
     * wind
     */
    @Property(nameInDb = "wind")
    @Convert(converter = WindInfoConverter.class, columnType = String.class)
    @SerializedName("wind")
    public WindInfo mWindInfo;
    /**
     * weather situation
     */
    @Convert(converter = ConditionInfoConverter.class, columnType = String.class)
    @SerializedName("cond")
    private ConditionInfo mConditionInfo;
    /**
     * date
     */
    @Property(nameInDb = "date")
    @SerializedName("date")
    private String mDate;
    /**
     * temperature
     */
    @Property(nameInDb = "tmp")
    @SerializedName("tmp")
    private String mTemperature;

    @Generated(hash = 1815536754)
    public HourlyForecastInfo(Long id, String mHumidity, String mPcpnProbability,
            String mAirPressure, WindInfo mWindInfo, ConditionInfo mConditionInfo,
            String mDate, String mTemperature) {
        this.id = id;
        this.mHumidity = mHumidity;
        this.mPcpnProbability = mPcpnProbability;
        this.mAirPressure = mAirPressure;
        this.mWindInfo = mWindInfo;
        this.mConditionInfo = mConditionInfo;
        this.mDate = mDate;
        this.mTemperature = mTemperature;
    }

    @Generated(hash = 1328045367)
    public HourlyForecastInfo() {
    }

    public ConditionInfo getConditionInfo() {
        return this.mConditionInfo;
    }

    public void setConditionInfo(ConditionInfo conditionInfo) {
        this.mConditionInfo = conditionInfo;
    }

    public WindInfo getWindInfo() {
        return this.mWindInfo;
    }

    public void setWindInfo(WindInfo windInfo) {
        this.mWindInfo = windInfo;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMHumidity() {
        return this.mHumidity;
    }

    public void setMHumidity(String mHumidity) {
        this.mHumidity = mHumidity;
    }

    public String getMPcpnProbability() {
        return this.mPcpnProbability;
    }

    public void setMPcpnProbability(String mPcpnProbability) {
        this.mPcpnProbability = mPcpnProbability;
    }

    public String getMAirPressure() {
        return this.mAirPressure;
    }

    public void setMAirPressure(String mAirPressure) {
        this.mAirPressure = mAirPressure;
    }

    public WindInfo getMWindInfo() {
        return this.mWindInfo;
    }

    public void setMWindInfo(WindInfo mWindInfo) {
        this.mWindInfo = mWindInfo;
    }

    public ConditionInfo getMConditionInfo() {
        return this.mConditionInfo;
    }

    public void setMConditionInfo(ConditionInfo mConditionInfo) {
        this.mConditionInfo = mConditionInfo;
    }

    public String getMDate() {
        return this.mDate;
    }

    public void setMDate(String mDate) {
        this.mDate = mDate;
    }

    public String getMTemperature() {
        return this.mTemperature;
    }

    public void setMTemperature(String mTemperature) {
        this.mTemperature = mTemperature;
    }
}
