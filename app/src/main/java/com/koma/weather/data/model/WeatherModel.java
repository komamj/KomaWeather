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

//import android.arch.persistence.room.ColumnInfo;
//import android.arch.persistence.room.PrimaryKey;

import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;

/**
 * Created by koma on 7/25/17.
 */
//@android.arch.persistence.room.Entity(tableName = "weather")
public class WeatherModel {
    //alarmsinfo
    /**
     * warning level
     */
    @Property(nameInDb = "level")
    private String level;
    /**
     * warning status
     */
    @Property(nameInDb = "status")
    private String status;
    /**
     * warning title
     */
    @Property(nameInDb = "title")
    private String title;
    /**
     * warning details
     */
    @Property(nameInDb = "warning_description")
    private String warningDescription;
    /**
     * warning type
     */
    @Property(nameInDb = "warning_type")
    private String type;

    //aqi
    @Property(nameInDb = "aqi")
    private String aqi;
    @Property(nameInDb = "co")
    private String co;
    @Property(nameInDb = "no2")
    private String no2;
    @Property(nameInDb = "o3")
    private String o3;
    @Property(nameInDb = "pm10")
    private String pm10;
    @Property(nameInDb = "pm25")
    private String pm25;
    @Property(nameInDb = "qlty")
    private String quality;
    @Property(nameInDb = "so2")
    private String so2;

    //basic info
    /**
     * city name
     */
    @Property(nameInDb = "city_name")
    private String mCityName;
    /**
     * id
     */
   /* @PrimaryKey
    @ColumnInfo(name = "city_id")*/
    private String cityId;

    @Property(nameInDb = "local_time")
    private String localTime;

    @Property(nameInDb = "utc_time")
    private String utcTime;
    @Transient
    private List<DailyForecastInfo> mDailyForecastInfos;

    //WeatherConditionInfo
    /**
     * weather code
     */
    @Property(nameInDb = "code")
    private String code;
    /**
     * weather description
     */
    @Property(nameInDb = "txt")
    private String description;
    /**
     * weather code for day
     */
    @Property(nameInDb = "code_d")
    private String codeDay;
    /**
     * weather code for night
     */
    @Property(nameInDb = "code_n")
    private String codeNight;
    /**
     * weather description for day
     */
    @Property(nameInDb = "txt_d")
    private String descriptionDay;
    /**
     * weather description for night
     */
    @Property(nameInDb = "txt_n")
    private String descriptionNight;

    //nowinfo
    @Property(nameInDb = "fl")
    private String sendibleTemp;
    /**
     * relative humidity
     */
    @Property(nameInDb = "hum")
    private String humidity;
    /**
     * amount of precipitation
     */
    @Property(nameInDb = "pcpn")
    private String precipitation;
    /**
     * air pressure
     */
    @Property(nameInDb = "pres")
    private String airPressure;
    /**
     * temperature
     */
    @Property(nameInDb = "tmp")
    private String temperature;
    /**
     * visibility
     */
    @Property(nameInDb = "vis")
    private String visibility;
    //wind info
    /**
     * the degree of wind direction
     */
    @Property(nameInDb = "deg")
    private String windDegree;
    /**
     * wind direction
     */
    @Property(nameInDb = "dir")
    private String windDirection;
    /**
     * wind power
     */
    @Property(nameInDb = "sc")
    private String windPower;
    /**
     * wind speed
     */
    @Property(nameInDb = "spd")
    private String windSpeed;

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWarningDescription() {
        return this.warningDescription;
    }

    public void setWarningDescription(String warningDescription) {
        this.warningDescription = warningDescription;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAqi() {
        return this.aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
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

    public String getO3() {
        return this.o3;
    }

    public void setO3(String o3) {
        this.o3 = o3;
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

    public String getQuality() {
        return this.quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getSo2() {
        return this.so2;
    }

    public void setSo2(String so2) {
        this.so2 = so2;
    }

    public String getMCityName() {
        return this.mCityName;
    }

    public void setMCityName(String mCityName) {
        this.mCityName = mCityName;
    }

    public String getCityId() {
        return this.cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getLocalTime() {
        return this.localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }

    public String getUtcTime() {
        return this.utcTime;
    }

    public void setUtcTime(String utcTime) {
        this.utcTime = utcTime;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodeDay() {
        return this.codeDay;
    }

    public void setCodeDay(String codeDay) {
        this.codeDay = codeDay;
    }

    public String getCodeNight() {
        return this.codeNight;
    }

    public void setCodeNight(String codeNight) {
        this.codeNight = codeNight;
    }

    public String getDescriptionDay() {
        return this.descriptionDay;
    }

    public void setDescriptionDay(String descriptionDay) {
        this.descriptionDay = descriptionDay;
    }

    public String getDescriptionNight() {
        return this.descriptionNight;
    }

    public void setDescriptionNight(String descriptionNight) {
        this.descriptionNight = descriptionNight;
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
        return this.visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getWindDegree() {
        return this.windDegree;
    }

    public void setWindDegree(String windDegree) {
        this.windDegree = windDegree;
    }

    public String getWindDirection() {
        return this.windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindPower() {
        return this.windPower;
    }

    public void setWindPower(String windPower) {
        this.windPower = windPower;
    }

    public String getWindSpeed() {
        return this.windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
}
