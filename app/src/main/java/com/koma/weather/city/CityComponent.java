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
package com.koma.weather.city;

import com.koma.weather.data.source.WeatherRepositoryComponent;
import com.koma.weather.util.FragmentScoped;

import dagger.Component;

/**
 * Created by koma on 8/8/17.
 */
@FragmentScoped
@Component(modules = CityPresenterModule.class, dependencies = WeatherRepositoryComponent.class)
public interface CityComponent {
    void inject(AddCityActivity addCityActivity);
}
