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
import com.koma.weather.util.DailyForcastConditionConverter;
import com.koma.weather.util.TemperatureConverter;
import com.koma.weather.util.WindInfoConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;

/**
 * Created by koma on 7/19/17.
 */
@Entity(nameInDb = "daily_forcast")
public class DailyForecastInfo implements Serializable {
    private static final long serialVersionUID = 7523967970034938906L;
    @Id(autoincrement = true)
    private Long id;
    /**
     * relative humidity
     */
    @Property(nameInDb = "hum")
    @SerializedName("hum")
    public String humidity;
    /**
     * precipitation
     */
    @Property(nameInDb = "pcpn")
    @SerializedName("pcpn")
    public String mPrecipitation;
    /**
     * precipitation probability
     */
    @Property(nameInDb = "pop")
    @SerializedName("pop")
    public String mPcpnProbability;
    /**
     * air pressure
     */
    @Property(nameInDb = "press")
    @SerializedName("pres")
    public String mAirPressure;
    /**
     * temperature
     */
    @Convert(converter = TemperatureConverter.class, columnType = String.class)
    @SerializedName("tmp")
    public TemperatureInfo mTemperatureInfo;
    /**
     * weather situation
     */
    @Convert(converter = DailyForcastConditionConverter.class, columnType = String.class)
    @SerializedName("cond")
    private DailyForecastCondition mConditionInfo;
    /**
     * date
     */
    @Property(nameInDb = "date")
    @SerializedName("date")
    private String mDate;
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

    @Generated(hash = 810926863)
    public DailyForecastInfo(Long id, String humidity, String mPrecipitation,
            String mPcpnProbability, String mAirPressure, TemperatureInfo mTemperatureInfo,
            DailyForecastCondition mConditionInfo, String mDate, String mVisibility,
            WindInfo mWindInfo) {
        this.id = id;
        this.humidity = humidity;
        this.mPrecipitation = mPrecipitation;
        this.mPcpnProbability = mPcpnProbability;
        this.mAirPressure = mAirPressure;
        this.mTemperatureInfo = mTemperatureInfo;
        this.mConditionInfo = mConditionInfo;
        this.mDate = mDate;
        this.mVisibility = mVisibility;
        this.mWindInfo = mWindInfo;
    }

    @Generated(hash = 315318944)
    public DailyForecastInfo() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHumidity() {
        return this.humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getMPrecipitation() {
        return this.mPrecipitation;
    }

    public void setMPrecipitation(String mPrecipitation) {
        this.mPrecipitation = mPrecipitation;
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

    public TemperatureInfo getMTemperatureInfo() {
        return this.mTemperatureInfo;
    }

    public void setMTemperatureInfo(TemperatureInfo mTemperatureInfo) {
        this.mTemperatureInfo = mTemperatureInfo;
    }

    public DailyForecastCondition getMConditionInfo() {
        return this.mConditionInfo;
    }

    public void setMConditionInfo(DailyForecastCondition mConditionInfo) {
        this.mConditionInfo = mConditionInfo;
    }

    public String getMDate() {
        return this.mDate;
    }

    public void setMDate(String mDate) {
        this.mDate = mDate;
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

    public static class DailyForecastCondition implements Serializable {
        private static final long serialVersionUID = 7523967970034938921L;
        /**
         * weather code for day
         */
        @SerializedName("code_d")
        private String mCodeDay;
        /**
         * weather code for night
         */
        @SerializedName("code_n")
        private String mCodeNight;
        /**
         * weather description for day
         */
        @SerializedName("txt_d")
        private String mDescriptionDay;
        /**
         * weather description for night
         */
        @SerializedName("txt_n")
        private String mDescriptionNight;

        public String getCodeDay() {
            return this.mCodeDay;
        }

        public void setCodeDay(String codeDay) {
            this.mCodeDay = codeDay;
        }

        public String getCodeNight() {
            return this.mCodeNight;
        }

        public void setCodeNight(String codeNight) {
            this.mCodeNight = codeNight;
        }

        public String getDescriptionDay() {
            return this.mDescriptionDay;
        }

        public void setDescriptionDay(String description) {
            this.mDescriptionDay = description;
        }

        public String getDescriptionNight() {
            return this.mDescriptionNight;
        }

        public void setDescriptionNight(String description) {
            this.mDescriptionNight = description;
        }
    }

    public static class TemperatureInfo implements Serializable {
        private static final long serialVersionUID = 7523967970034938913L;
        /**
         * max temperature
         */
        @SerializedName("max")
        private String mMaxTemperature;
        /**
         * min temperature
         */
        @SerializedName("min")
        private String mMinTemperature;

        public String getMaxTemperature() {
            return this.mMaxTemperature;
        }

        public void setMaxTemperature(String temperature) {
            this.mMaxTemperature = temperature;
        }

        public String getMinTemperature() {
            return this.mMinTemperature;
        }

        public void setMinTemperature(String temperature) {
            this.mMinTemperature = temperature;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("temperature max :").append(this.mMaxTemperature)
                    .append(",min :").append(this.mMinTemperature);

            return builder.toString();
        }
    }
}
