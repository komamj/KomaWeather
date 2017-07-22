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

public class TemperatureInfo implements Serializable {
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

    public void setMaxTemperature(String temperature) {
        this.mMaxTemperature = temperature;
    }

    public String getMaxTemperature() {
        return this.mMaxTemperature;
    }

    public void setMinTemperature(String temperature) {
        this.mMinTemperature = temperature;
    }

    public String getMinTemperature() {
        return this.mMinTemperature;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("temperature max :").append(this.mMaxTemperature)
                .append(",min :").append(this.mMinTemperature);

        return builder.toString();
    }
}
