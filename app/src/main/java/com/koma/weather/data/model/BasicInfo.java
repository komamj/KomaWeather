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

public class BasicInfo implements Serializable {
    /**
     * city name
     */
    @SerializedName("city")
    private String mCityName;
    /**
     * country name
     */
    @SerializedName("cnty")
    private String mCountryName;
    /**
     * id
     */
    @SerializedName("id")
    private String mId;
    /**
     * latitude
     */
    @SerializedName("lat")
    private String mLatitude;
    /**
     * longitude
     */
    @SerializedName("lon")
    private String mLongitude;
    /**
     * province name
     */
    @SerializedName("prov")
    private String mProvinceName;

    @SerializedName("update")
    private UpdateInfo mUpdateInfo;

    public void setCityName(String cityName) {
        this.mCityName = cityName;
    }

    public String getCityName() {
        return this.mCityName;
    }

    public void setCountryName(String countryName) {
        this.mCountryName = countryName;
    }

    public String getCountryName() {
        return this.mCountryName;
    }

    public void setId(String id) {
        this.mId = id;
    }

    public String getId() {
        return this.mId;
    }

    public void setLatitude(String latitude) {
        this.mLatitude = latitude;
    }

    public String getLatitude() {
        return this.mLatitude;
    }

    public void setLongitude(String longitude) {
        this.mLongitude = longitude;
    }

    public String getLongitude() {
        return this.mLongitude;
    }

    public void setProvinceName(String provinceName) {
        this.mProvinceName = provinceName;
    }

    public String getProvinceName() {
        return this.mProvinceName;
    }

    public void setUpdateInfo(UpdateInfo updateInfo) {
        this.mUpdateInfo = updateInfo;
    }

    public UpdateInfo getUpdateInfo() {
        return this.mUpdateInfo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("city :").append(this.mCityName).append(",country :")
                .append(this.mCountryName).append(",id :").append(this.mId).append(",latitude :")
                .append(this.mLatitude).append(",longgitude :").append(this.mLongitude)
                .append(",province :").append(this.mProvinceName).append(",update info :")
                .append(this.mUpdateInfo.toString());
        return builder.toString();
    }
}
