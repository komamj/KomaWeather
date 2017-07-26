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

import com.koma.weather.data.model.ConditionInfo;

import org.greenrobot.greendao.converter.PropertyConverter;

/**
 * Created by koma on 7/26/17.
 */

public class ConditionInfoConverter implements PropertyConverter<ConditionInfo, String> {
    @Override
    public ConditionInfo convertToEntityProperty(String databaseValue) {
        if (databaseValue == null) {
            LogUtils.i("ConditionInfoConverter", "databaseValue is null");

            return null;
        }
        String[] info = databaseValue.split(",");
        ConditionInfo conditionInfo =
                new ConditionInfo();
        conditionInfo.setCode(info[0]);
        conditionInfo.setDescription(info[1]);
        return conditionInfo;
    }

    @Override
    public String convertToDatabaseValue(ConditionInfo entityProperty) {
        if (entityProperty == null) {
            LogUtils.i("ConditionInfoConverter", "entityProperty is null");

            return null;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(entityProperty.getCode()).append(",")
                .append(entityProperty.getDescription());
        return builder.toString();
    }
}
