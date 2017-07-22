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

public class CityInfo implements Serializable {
    @SerializedName("aqi")
    private String mAqi;
    @SerializedName("co")
    private String mCO;
    @SerializedName("no2")
    private String mNO2;
    @SerializedName("o3")
    private String mO3;
    @SerializedName("pm10")
    private String mPM10;
    @SerializedName("pm25")
    private String mPM25;
    @SerializedName("qlty")
    private String mQuality;
    @SerializedName("so2")
    private String mSO2;

    public void setAqi(String aqi) {
        this.mAqi = aqi;
    }

    public String getAqi() {
        return this.mAqi;
    }

    public void setCO(String co) {
        this.mCO = co;
    }

    public String getCO() {
        return this.mCO;
    }

    public void setNO2(String no2) {
        this.mNO2 = no2;
    }

    public String getNO2() {
        return this.mNO2;
    }

    public void setO3(String o3) {
        this.mO3 = o3;
    }

    public String getO3() {
        return this.mO3;
    }

    public void setPM10(String pm10) {
        this.mPM10 = pm10;
    }

    public String getPM10() {
        return this.mPM10;
    }

    public void setPM25(String pm25) {
        this.mPM25 = pm25;
    }

    public String getPM25() {
        return this.mPM25;
    }

    public void setQuality(String quality) {
        this.mQuality = quality;
    }

    public String getQuality() {
        return this.mQuality;
    }

    public void setSO2(String so2) {
        this.mSO2 = so2;
    }

    public String getSO2() {
        return this.mSO2;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("aqi :").append(this.mAqi).append(",co :").append(this.mCO).append(",no2 :")
                .append(this.mNO2).append(",o3 : ").append(this.mO3).append(",pm10 :")
                .append(this.mPM10).append(",pm25 :").append(this.mPM25).append(",quality : ")
                .append(this.mQuality).append(",so2 :").append(this.mSO2);
        return builder.toString();
    }
}
