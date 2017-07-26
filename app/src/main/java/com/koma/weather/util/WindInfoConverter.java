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

import com.koma.weather.data.model.WindInfo;

import org.greenrobot.greendao.converter.PropertyConverter;

/**
 * Created by koma on 7/26/17.
 */

public class WindInfoConverter implements PropertyConverter<WindInfo, String> {
    @Override
    public WindInfo convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            return null;
        }
        String[] info = databaseValue.split(",");
        WindInfo windInfo = new WindInfo();
        windInfo.setWindDegree(info[0]);
        windInfo.setWindDirection(info[1]);
        windInfo.setWindPower(info[2]);
        windInfo.setWindSepeed(info[3]);
        return windInfo;
    }

    @Override
    public String convertToDatabaseValue(WindInfo entityProperty) {
        if (entityProperty == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(entityProperty.getWindDegree()).append(",")
                .append(entityProperty.getWindDirection()).append(",")
                .append(entityProperty.getWindPower()).append(",")
                .append(entityProperty.getWindSpeed());
        return builder.toString();
    }
}
