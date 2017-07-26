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
package com.koma.weather.util;

import com.koma.weather.data.model.DailyForecastInfo;

import org.greenrobot.greendao.converter.PropertyConverter;

/**
 * Created by koma on 7/26/17.
 */

public class TemperatureConverter implements
        PropertyConverter<DailyForecastInfo.TemperatureInfo, String> {
    @Override
    public DailyForecastInfo.TemperatureInfo convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        String[] info = databaseValue.split(",");
        DailyForecastInfo.TemperatureInfo temperatureInfo =
                new DailyForecastInfo.TemperatureInfo();
        temperatureInfo.setMaxTemperature(info[0]);
        temperatureInfo.setMinTemperature(info[1]);
        return temperatureInfo;
    }

    @Override
    public String convertToDatabaseValue(DailyForecastInfo.TemperatureInfo entityProperty) {
        if (entityProperty == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(entityProperty.getMaxTemperature()).append(",")
                .append(entityProperty.getMinTemperature());
        return builder.toString();
    }
}
