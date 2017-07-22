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
package com.koma.weather.data.source.remote;

import com.koma.weather.data.model.HeWeather;
import com.koma.weather.data.source.WeatherApi;
import com.koma.weather.data.source.WeatherDataSource;
import com.koma.weather.util.Constants;
import com.koma.weather.util.LogUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by koma on 7/18/17.
 */
@Singleton
public class WeatherRemoteDataSource implements WeatherDataSource {
    private static final String TAG = WeatherRemoteDataSource.class.getSimpleName();

    private final WeatherApi mWeatherApi;

    @Inject
    public WeatherRemoteDataSource(WeatherApi weatherApi) {
        mWeatherApi = weatherApi;
    }

    @Override
    public Flowable<HeWeather> getWeather(String city) {
        LogUtils.i(TAG, "getWeather city : " + city);

        return mWeatherApi.getWeather(city, Constants.API_KEY);
    }
}
