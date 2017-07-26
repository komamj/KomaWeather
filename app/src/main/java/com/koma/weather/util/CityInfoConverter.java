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

import com.koma.weather.data.model.AqiInfo;

import org.greenrobot.greendao.converter.PropertyConverter;

/**
 * Created by koma on 7/26/17.
 */

public class CityInfoConverter implements PropertyConverter<AqiInfo.CityInfo, String> {
    @Override
    public AqiInfo.CityInfo convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            LogUtils.e("CityInfoConverter", "databaseValue is null");

            return null;
        }
        String[] info = databaseValue.split(",");
        AqiInfo.CityInfo cityInfo =
                new AqiInfo.CityInfo();
        cityInfo.setAqi(info[0]);
        cityInfo.setCo(info[1]);
        cityInfo.setNo2(info[2]);
        cityInfo.setO3(info[3]);
        cityInfo.setPm10(info[4]);
        cityInfo.setPm25(info[5]);
        cityInfo.setQuality(info[6]);
        cityInfo.setSo2(info[7]);
        return cityInfo;
    }

    @Override
    public String convertToDatabaseValue(AqiInfo.CityInfo entityProperty) {
        if (entityProperty == null) {
            LogUtils.e("CityInfoConverter", "entityProperty is null");

            return null;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(entityProperty.getAqi()).append(",").append(entityProperty.getCo())
                .append(",").append(entityProperty.getNo2()).append(",")
                .append(entityProperty.getO3()).append(",").append(entityProperty.getPm10())
                .append(",").append(entityProperty.getPm25()).append(",")
                .append(entityProperty.getQuality()).append(",")
                .append(entityProperty.getSo2());
        return builder.toString();
    }
}
