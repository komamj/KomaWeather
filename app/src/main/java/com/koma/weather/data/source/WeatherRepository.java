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
package com.koma.weather.data.source;

import com.koma.weather.data.model.Weather;
import com.koma.weather.data.source.local.WeatherLocalDataSource;
import com.koma.weather.data.source.remote.WeatherRemoteDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;

/**
 * Created by koma on 7/18/17.
 */
@Singleton
public class WeatherRepository implements WeatherDataSource {
    private final WeatherLocalDataSource mLocalDataSource;

    private final WeatherRemoteDataSource mRemoteDataSource;

    @Inject
    public WeatherRepository(@Local WeatherLocalDataSource localDataSource,
                             @Remote WeatherRemoteDataSource remoteDataSource) {
        this.mLocalDataSource = localDataSource;

        this.mRemoteDataSource = remoteDataSource;
    }

    @Override
    public Flowable<Weather> getWeather(String city) {
        return mRemoteDataSource.getWeather(city);
    }

    @Override
    public Flowable<Weather> getNowWeather(String city) {
        return mRemoteDataSource.getNowWeather(city);
    }
}
