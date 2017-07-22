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

public class SuggestionInfo implements Serializable {
    @SerializedName("comf")
    private ComfortInfo mComforInfo;
    @SerializedName("cw")
    private CarWashInfo mCarWashInfo;
    @SerializedName("drsg")
    private DressInfo mDressInfo;
    @SerializedName("flu")
    private ColdInfo mColdInfo;
    @SerializedName("sport")
    private SportInfo mSportInfo;
    @SerializedName("trav")
    private TravelInfo mTravelInfo;
    @SerializedName("uv")
    private UltravioletInfo mUltravioletInfo;

    public void setComfortInfo(ComfortInfo comfortInfo) {
        this.mComforInfo = comfortInfo;
    }

    public ComfortInfo getComfortInfo() {
        return this.mComforInfo;
    }

    public void setCarWashInfo(CarWashInfo carWashInfo) {
        this.mCarWashInfo = carWashInfo;
    }

    public CarWashInfo getCarWashInfo() {
        return this.mCarWashInfo;
    }

    public void setDressInfo(DressInfo dressInfo) {
        this.mDressInfo = dressInfo;
    }

    public DressInfo getDressInfo() {
        return this.mDressInfo;
    }

    public void setColdInfo(ColdInfo coldInfo) {
        this.mColdInfo = coldInfo;
    }

    public ColdInfo getColdInfo() {
        return this.mColdInfo;
    }

    public void setSportInfo(SportInfo sportInfo) {
        this.mSportInfo = sportInfo;
    }

    public SportInfo getSportInfo() {
        return this.mSportInfo;
    }

    public void setTravelInfo(TravelInfo travelInfo) {
        this.mTravelInfo = travelInfo;
    }

    public TravelInfo getTravelInfo() {
        return this.mTravelInfo;
    }

    public void setUltravioletInfo(UltravioletInfo ultravioletInfo) {
        this.mUltravioletInfo = ultravioletInfo;
    }

    public UltravioletInfo getUltravioletInfo() {
        return this.mUltravioletInfo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Suggestion comf :").append(this.mComforInfo.toString())
                .append(",cw :").append(this.mComforInfo.toString()).append(",drsg")
                .append(this.mDressInfo.toString()).append(",flu :")
                .append(this.mColdInfo.toString()).append(",sport :")
                .append(this.mSportInfo.toString()).append(",trav :")
                .append(this.mTravelInfo.toString()).append(",uv :")
                .append(this.mUltravioletInfo.toString());

        return builder.toString();
    }
}
