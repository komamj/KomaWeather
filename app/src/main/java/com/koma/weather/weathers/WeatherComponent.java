package com.koma.weather.weathers;

import com.koma.weather.data.source.WeatherRepositoryComponent;
import com.koma.weather.util.FragmentScoped;

import dagger.Component;

/**
 * Created by koma on 7/21/17.
 */
@FragmentScoped
@Component(dependencies = WeatherRepositoryComponent.class, modules = WeatherPresenterModule.class)
public interface WeatherComponent {
    void inject(WeatherFragment weatherFragment);
}
