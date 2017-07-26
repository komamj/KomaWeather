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
import com.koma.weather.util.CityInfoConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by koma on 7/19/17.
 */
@Entity(nameInDb = "aqi_info")
public class AqiInfo implements Serializable {
    private static final long serialVersionUID = 7523967970034938900L;
    @Id(autoincrement = true)
    private Long id;
    @Convert(converter = CityInfoConverter.class, columnType = String.class)
    @SerializedName("city")
    private CityInfo cityInfo;

    @Generated(hash = 1548455190)
    public AqiInfo(Long id, CityInfo cityInfo) {
        this.id = id;
        this.cityInfo = cityInfo;
    }

    @Generated(hash = 489475186)
    public AqiInfo() {
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("aqi :").append(this.cityInfo.toString());

        return builder.toString();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CityInfo getCityInfo() {
        return this.cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo) {
        this.cityInfo = cityInfo;
    }

    public static class CityInfo implements Serializable {
        private static final long serialVersionUID = 7523967970034938903L;

        @SerializedName("aqi")
        private String aqi;
        @SerializedName("co")
        private String co;
        @SerializedName("no2")
        private String no2;
        @SerializedName("o3")
        private String o3;
        @SerializedName("pm10")
        private String pm10;
        @SerializedName("pm25")
        private String pm25;
        @SerializedName("qlty")
        private String quality;
        @SerializedName("so2")
        private String so2;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("aqi :").append(this.aqi).append(",co :").append(this.co).append(",no2 :")
                    .append(this.no2).append(",o3 : ").append(this.o3).append(",pm10 :")
                    .append(this.pm10).append(",pm25 :").append(this.pm25).append(",quality : ")
                    .append(this.quality).append(",so2 :").append(this.so2);
            return builder.toString();
        }

        public String getCo() {
            return this.co;
        }

        public void setCo(String co) {
            this.co = co;
        }

        public String getNo2() {
            return this.no2;
        }

        public void setNo2(String no2) {
            this.no2 = no2;
        }

        public String getPm10() {
            return this.pm10;
        }

        public void setPm10(String pm10) {
            this.pm10 = pm10;
        }

        public String getPm25() {
            return this.pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public String getSo2() {
            return this.so2;
        }

        public void setSo2(String so2) {
            this.so2 = so2;
        }

        public String getAqi() {
            return this.aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public String getO3() {
            return this.o3;
        }

        public void setO3(String o3) {
            this.o3 = o3;
        }

        public String getQuality() {
            return this.quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }
    }
}
