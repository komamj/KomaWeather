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

public class WeatherConditionInfo implements Serializable {
    /**
     * weather code
     */
    @SerializedName("code")
    private String mCode;
    /**
     * weather description
     */
    @SerializedName("txt")
    private String mDescription;
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

    public void setCode(String code) {
        this.mCode = code;
    }

    public String getCode() {
        return this.mCode;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setCodeDay(String codeDay) {
        this.mCodeDay = codeDay;
    }

    public String getCodeDay() {
        return this.mCodeDay;
    }

    public void setCodeNight(String codeNight) {
        this.mCodeNight = codeNight;
    }

    public String getCodeNight() {
        return this.mCodeNight;
    }

    public void setDescriptionDay(String description) {
        this.mDescriptionDay = description;
    }

    public String getDescriptionDay() {
        return this.mDescriptionDay;
    }

    public void setDescriptionNight(String description) {
        this.mDescriptionNight = description;
    }

    public String getDescriptionNight() {
        return this.mDescriptionNight;
    }
}
