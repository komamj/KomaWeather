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
import com.koma.weather.util.UpdateInfoConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by koma on 7/19/17.
 */
public final class BasicInfo implements Serializable {
    private static final long serialVersionUID = 7523967970034938901L;
    /**
     * city_id
     */
    @SerializedName("id")
    private String cityId;
    /**
     * city name
     */
    @SerializedName("city")
    private String cityName;
    /**
     * country name
     */
    @SerializedName("cnty")
    private String countryName;
    /**
     * latitude
     */
    @SerializedName("lat")
    private String latitude;
    /**
     * longitude
     */
    @SerializedName("lon")
    private String longitude;
    /**
     * province name
     */
    @SerializedName("prov")
    private String provinceName;
    /**
     * update info
     */
    @SerializedName("update")
    private UpdateInfo updateInfo;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("city :").append(this.cityName).append(",country :")
                .append(this.countryName).append(",cityId :").append(this.cityId).append(",latitude :")
                .append(this.latitude).append(",longgitude :").append(this.longitude)
                .append(",province :").append(this.provinceName).append(",update info :")
                .append(this.updateInfo.toString());
        return builder.toString();
    }

    public String getCityId() {
        return this.cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return this.cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getProvinceName() {
        return this.provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public UpdateInfo getUpdateInfo() {
        return this.updateInfo;
    }

    public void setUpdateInfo(UpdateInfo updateInfo) {
        this.updateInfo = updateInfo;
    }

    public static class UpdateInfo implements Serializable {
        private static final long serialVersionUID = 7523967970034938916L;
        @SerializedName("loc")
        private String timeLocal;
        @SerializedName("utc")
        private String timeUTC;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("local time :").append(this.timeLocal).append(",utc time :")
                    .append(this.timeUTC);
            return builder.toString();
        }

        public String getTimeLocal() {
            return this.timeLocal;
        }


        public void setTimeLocal(String timeLocal) {
            this.timeLocal = timeLocal;
        }


        public String getTimeUTC() {
            return this.timeUTC;
        }


        public void setTimeUTC(String timeUTC) {
            this.timeUTC = timeUTC;
        }
    }
}
