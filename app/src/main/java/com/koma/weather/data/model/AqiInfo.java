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

public class AqiInfo implements Serializable {
    @SerializedName("city")
    private CityInfo mCityInfo;

    public void setCityInfo(CityInfo cityInfo) {
        this.mCityInfo = cityInfo;
    }

    public CityInfo getCityInfo() {
        return this.mCityInfo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("aqi :").append(this.mCityInfo.toString());

        return builder.toString();
    }
}
