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
package com.koma.weather.weathers;

import com.koma.weather.base.BasePresenter;
import com.koma.weather.base.BaseView;
import com.koma.weather.data.model.Weather;

/**
 * Created by koma on 7/21/17.
 */

public interface WeatherContract {
    interface View extends BaseView<Presenter> {
        void setLoadingIndicator(boolean active);

        void showWeather(Weather weather);

        boolean isActive();

        String getCity();

        void showSuccessfullyLoadedMessage();

        void showLoadingWeatherError();
    }

    interface Presenter extends BasePresenter {
        void loadWeather();
    }
}
