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

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by koma on 7/25/17.
 */
@Entity(indexes = {
        @Index(value = "mCityId", unique = true)}, nameInDb = "weather")

public class WeatherModel {
    @Id(autoincrement = true)
    private Long mId;
    //basic info
    /**
     * city name
     */
    @Property(nameInDb = "city_name")
    private String mCityName;
    /**
     * id
     */
    @Property(nameInDb = "city_id")
    private String mCityId;

    @Property(nameInDb = "date_local")
    private String mLocalTime;

    @Property(nameInDb = "date_utc")
    private String mUtcTime;
    //WeatherConditionInfo
    /**
     * weather code
     */
    @Property(nameInDb = "code")
    private String mCode;
    /**
     * weather description
     */
    @Property(nameInDb = "txt")
    private String mDescription;
    /**
     * weather code for day
     */
    @Property(nameInDb = "code_d")
    private String mCodeDay;
    /**
     * weather code for night
     */
    @Property(nameInDb = "code_n")
    private String mCodeNight;
    /**
     * weather description for day
     */
    @Property(nameInDb = "txt_d")
    private String mDescriptionDay;
    /**
     * weather description for night
     */
    @Property(nameInDb = "txt_n")
    private String mDescriptionNight;

    //nowinfo
    @Property(nameInDb = "fl")
    private String mSendibleTemp;
    /**
     * relative humidity
     */
    @Property(nameInDb = "hum")
    private String mHumidity;
    /**
     * amount of precipitation
     */
    @Property(nameInDb = "pcpn")
    private String mPrecipitation;
    /**
     * air pressure
     */
    @Property(nameInDb = "pres")
    private String mAirPressure;
    /**
     * temperature
     */
    @Property(nameInDb = "tmp")
    private String mTemperature;
    /**
     * visibility
     */
    @Property(nameInDb = "vis")
    private String mVisibility;
    //wind info
    /**
     * the degree of wind direction
     */
    @Property(nameInDb = "deg")
    private String mWindDegree;
    /**
     * wind direction
     */
    @Property(nameInDb = "dir")
    private String mWindDirection;
    /**
     * wind power
     */
    @Property(nameInDb = "sc")
    private String mWindPower;
    /**
     * wind speed
     */
    @Property(nameInDb = "spd")
    private String mWindSpeed;
    //cityinfo
    @Property(nameInDb = "aqi")
    private String mAqi;
    @Property(nameInDb = "co")
    private String mCO;
    @Property(nameInDb = "no2")
    private String mNO2;
    @Property(nameInDb = "o3")
    private String mO3;
    @Property(nameInDb = "pm10")
    private String mPM10;
    @Property(nameInDb = "pm25")
    private String mPM25;
    @Property(nameInDb = "qlty")
    private String mQuality;
    @Property(nameInDb = "so2")
    private String mSO2;
    //alarmsinfo
    /**
     * warning level
     */
    private String mLevel;
    /**
     * warning status
     */
    private String mStatus;
    /**
     * warning title
     */
    private String mTitle;
    /**
     * warning details
     */
    private String mWarningDescription;
    /**
     * warning type
     */
    private String mType;
@Generated(hash = 10749052)
public WeatherModel(Long mId, String mCityName, String mCityId,
        String mLocalTime, String mUtcTime, String mCode, String mDescription,
        String mCodeDay, String mCodeNight, String mDescriptionDay,
        String mDescriptionNight, String mSendibleTemp, String mHumidity,
        String mPrecipitation, String mAirPressure, String mTemperature,
        String mVisibility, String mWindDegree, String mWindDirection,
        String mWindPower, String mWindSpeed, String mAqi, String mCO,
        String mNO2, String mO3, String mPM10, String mPM25, String mQuality,
        String mSO2, String mLevel, String mStatus, String mTitle,
        String mWarningDescription, String mType) {
    this.mId = mId;
    this.mCityName = mCityName;
    this.mCityId = mCityId;
    this.mLocalTime = mLocalTime;
    this.mUtcTime = mUtcTime;
    this.mCode = mCode;
    this.mDescription = mDescription;
    this.mCodeDay = mCodeDay;
    this.mCodeNight = mCodeNight;
    this.mDescriptionDay = mDescriptionDay;
    this.mDescriptionNight = mDescriptionNight;
    this.mSendibleTemp = mSendibleTemp;
    this.mHumidity = mHumidity;
    this.mPrecipitation = mPrecipitation;
    this.mAirPressure = mAirPressure;
    this.mTemperature = mTemperature;
    this.mVisibility = mVisibility;
    this.mWindDegree = mWindDegree;
    this.mWindDirection = mWindDirection;
    this.mWindPower = mWindPower;
    this.mWindSpeed = mWindSpeed;
    this.mAqi = mAqi;
    this.mCO = mCO;
    this.mNO2 = mNO2;
    this.mO3 = mO3;
    this.mPM10 = mPM10;
    this.mPM25 = mPM25;
    this.mQuality = mQuality;
    this.mSO2 = mSO2;
    this.mLevel = mLevel;
    this.mStatus = mStatus;
    this.mTitle = mTitle;
    this.mWarningDescription = mWarningDescription;
    this.mType = mType;
}
@Generated(hash = 802490738)
public WeatherModel() {
}
public Long getMId() {
    return this.mId;
}
public void setMId(Long mId) {
    this.mId = mId;
}
public String getMCityName() {
    return this.mCityName;
}
public void setMCityName(String mCityName) {
    this.mCityName = mCityName;
}
public String getMCityId() {
    return this.mCityId;
}
public void setMCityId(String mCityId) {
    this.mCityId = mCityId;
}
public String getMLocalTime() {
    return this.mLocalTime;
}
public void setMLocalTime(String mLocalTime) {
    this.mLocalTime = mLocalTime;
}
public String getMUtcTime() {
    return this.mUtcTime;
}
public void setMUtcTime(String mUtcTime) {
    this.mUtcTime = mUtcTime;
}
public String getMCode() {
    return this.mCode;
}
public void setMCode(String mCode) {
    this.mCode = mCode;
}
public String getMDescription() {
    return this.mDescription;
}
public void setMDescription(String mDescription) {
    this.mDescription = mDescription;
}
public String getMCodeDay() {
    return this.mCodeDay;
}
public void setMCodeDay(String mCodeDay) {
    this.mCodeDay = mCodeDay;
}
public String getMCodeNight() {
    return this.mCodeNight;
}
public void setMCodeNight(String mCodeNight) {
    this.mCodeNight = mCodeNight;
}
public String getMDescriptionDay() {
    return this.mDescriptionDay;
}
public void setMDescriptionDay(String mDescriptionDay) {
    this.mDescriptionDay = mDescriptionDay;
}
public String getMDescriptionNight() {
    return this.mDescriptionNight;
}
public void setMDescriptionNight(String mDescriptionNight) {
    this.mDescriptionNight = mDescriptionNight;
}
public String getMSendibleTemp() {
    return this.mSendibleTemp;
}
public void setMSendibleTemp(String mSendibleTemp) {
    this.mSendibleTemp = mSendibleTemp;
}
public String getMHumidity() {
    return this.mHumidity;
}
public void setMHumidity(String mHumidity) {
    this.mHumidity = mHumidity;
}
public String getMPrecipitation() {
    return this.mPrecipitation;
}
public void setMPrecipitation(String mPrecipitation) {
    this.mPrecipitation = mPrecipitation;
}
public String getMAirPressure() {
    return this.mAirPressure;
}
public void setMAirPressure(String mAirPressure) {
    this.mAirPressure = mAirPressure;
}
public String getMTemperature() {
    return this.mTemperature;
}
public void setMTemperature(String mTemperature) {
    this.mTemperature = mTemperature;
}
public String getMVisibility() {
    return this.mVisibility;
}
public void setMVisibility(String mVisibility) {
    this.mVisibility = mVisibility;
}
public String getMWindDegree() {
    return this.mWindDegree;
}
public void setMWindDegree(String mWindDegree) {
    this.mWindDegree = mWindDegree;
}
public String getMWindDirection() {
    return this.mWindDirection;
}
public void setMWindDirection(String mWindDirection) {
    this.mWindDirection = mWindDirection;
}
public String getMWindPower() {
    return this.mWindPower;
}
public void setMWindPower(String mWindPower) {
    this.mWindPower = mWindPower;
}
public String getMWindSpeed() {
    return this.mWindSpeed;
}
public void setMWindSpeed(String mWindSpeed) {
    this.mWindSpeed = mWindSpeed;
}
public String getMAqi() {
    return this.mAqi;
}
public void setMAqi(String mAqi) {
    this.mAqi = mAqi;
}
public String getMCO() {
    return this.mCO;
}
public void setMCO(String mCO) {
    this.mCO = mCO;
}
public String getMNO2() {
    return this.mNO2;
}
public void setMNO2(String mNO2) {
    this.mNO2 = mNO2;
}
public String getMO3() {
    return this.mO3;
}
public void setMO3(String mO3) {
    this.mO3 = mO3;
}
public String getMPM10() {
    return this.mPM10;
}
public void setMPM10(String mPM10) {
    this.mPM10 = mPM10;
}
public String getMPM25() {
    return this.mPM25;
}
public void setMPM25(String mPM25) {
    this.mPM25 = mPM25;
}
public String getMQuality() {
    return this.mQuality;
}
public void setMQuality(String mQuality) {
    this.mQuality = mQuality;
}
public String getMSO2() {
    return this.mSO2;
}
public void setMSO2(String mSO2) {
    this.mSO2 = mSO2;
}
public String getMLevel() {
    return this.mLevel;
}
public void setMLevel(String mLevel) {
    this.mLevel = mLevel;
}
public String getMStatus() {
    return this.mStatus;
}
public void setMStatus(String mStatus) {
    this.mStatus = mStatus;
}
public String getMTitle() {
    return this.mTitle;
}
public void setMTitle(String mTitle) {
    this.mTitle = mTitle;
}
public String getMWarningDescription() {
    return this.mWarningDescription;
}
public void setMWarningDescription(String mWarningDescription) {
    this.mWarningDescription = mWarningDescription;
}
public String getMType() {
    return this.mType;
}
public void setMType(String mType) {
    this.mType = mType;
}
}
