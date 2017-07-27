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
package com.koma.weather.data.source.local;

import android.content.Context;

import com.koma.weather.data.model.BasicInfoDao;
import com.koma.weather.data.model.DaoSession;
import com.koma.weather.data.model.Weather;
import com.koma.weather.data.source.WeatherDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by koma on 7/18/17.
 */
@Singleton
public class WeatherLocalDataSource implements WeatherDataSource {
    private static final String TAG = WeatherLocalDataSource.class.getSimpleName();

    private final Context mContext;

    private final DaoSession mDaoSession;

    @Inject
    public WeatherLocalDataSource(Context context, DaoSession daoSession) {
        mContext = context;

        mDaoSession = daoSession;
    }

    @Override
    public Flowable<Weather> getWeather(String city) {
        mDaoSession.getBasicInfoDao().queryBuilder().where(BasicInfoDao.Properties.CityName.eq(city)).build();
        return null;
    }

    @Override
    public Flowable<Weather> getNowWeather(String city) {
        return null;
    }
}
