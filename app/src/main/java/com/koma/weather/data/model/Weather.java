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
import java.util.List;

/**
 * Created by koma on 7/18/17.
 */

public class Weather implements Serializable {
    private static final long serialVersionUID = 7523967970034938918L;
    /**
     * warning info
     **/
    @SerializedName("alarms")
    private List<WarningInfo> mWaringInfo;
    /**
     * aqi info
     */
    @SerializedName("aqi")
    private AqiInfo mAqiInfo;
    /**
     * basic info
     */
    @SerializedName("basic")
    private BasicInfo mBasicInfo;
    /**
     * dailyforecast info
     **/
    @SerializedName("daily_forecast")
    private List<DailyForecastInfo> mDailyForecastInfo;
    /**
     * hourlyforecast info
     **/
    @SerializedName("hourly_forecast")
    private List<HourlyForecastInfo> mHourlyForecastInfo;
    /**
     * now info
     **/
    @SerializedName("now")
    private NowInfo mNowInfo;
    /**
     * status
     */
    @SerializedName("status")
    private String mStatus;
    /**
     * suggestion info
     **/
    @SerializedName("suggestion")
    private SuggestionInfo mSuggerstionInfo;

    public List<WarningInfo> getWarningInfo() {
        return this.mWaringInfo;
    }

    public void setWarningInfo(List<WarningInfo> warningInfo) {
        this.mWaringInfo = warningInfo;
    }

    public AqiInfo getAqiInfo() {
        return this.mAqiInfo;
    }

    public void setAqiInfo(AqiInfo aqiInfo) {
        this.mAqiInfo = aqiInfo;
    }

    public BasicInfo getBasicInfo() {
        return this.mBasicInfo;
    }

    public void setBasicInfo(BasicInfo basicInfo) {
        this.mBasicInfo = basicInfo;
    }

    public List<DailyForecastInfo> getDailyForecastInfo() {
        return this.mDailyForecastInfo;
    }

    public void setDailyForecastInfo(List<DailyForecastInfo> dailyForecastInfo) {
        this.mDailyForecastInfo = dailyForecastInfo;
    }

    public List<HourlyForecastInfo> getHourlyForecastInfo() {
        return this.mHourlyForecastInfo;
    }

    public void setHourlyForecastInfo(List<HourlyForecastInfo> hourlyForecastInfo) {
        this.mHourlyForecastInfo = hourlyForecastInfo;
    }

    public NowInfo getNowInfo() {
        return this.mNowInfo;
    }

    public void setNowInfo(NowInfo nowInfo) {
        this.mNowInfo = nowInfo;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String status) {
        this.mStatus = status;
    }

    public SuggestionInfo getSuggerstionInfo() {
        return this.mSuggerstionInfo;
    }

    public void setSuggerstionInfo(SuggestionInfo suggerstionInfo) {
        this.mSuggerstionInfo = suggerstionInfo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        return builder.toString();
    }
}
