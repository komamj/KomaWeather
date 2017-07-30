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
package com.koma.weather;

import android.app.Application;
import android.os.StrictMode;

import com.koma.weather.data.source.DaggerWeatherRepositoryComponent;
import com.koma.weather.data.source.WeatherRepositoryComponent;
import com.koma.weather.data.source.WeatherRepositoryModule;
import com.koma.weather.util.Constants;
import com.koma.weather.util.LogUtils;
import com.squareup.leakcanary.LeakCanary;

import net.youmi.android.AdManager;
import net.youmi.android.nm.sp.SpotManager;
import net.youmi.android.nm.sp.SpotRequestListener;

/**
 * Created by koma on 7/18/17.
 */

public class WeatherApplication extends Application {
    private static final String TAG = WeatherApplication.class.getSimpleName();

    private WeatherRepositoryComponent mWeatherRepositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        LogUtils.i(TAG, "onCreate");

        if (BuildConfig.DEBUG) {
            enableStrictMode();

            if (LeakCanary.isInAnalyzerProcess(this)) {
                // This process is dedicated to LeakCanary for heap analysis.
                // You should not init your app in this process.
                return;
            }
            LeakCanary.install(this);
        }

        AdManager.getInstance(getApplicationContext()).init(Constants.YOU_MI_ID,
                Constants.YOU_MI_KEY, true);
        SpotManager.getInstance(getApplicationContext()).requestSpot(new SpotRequestListener() {
            @Override
            public void onRequestSuccess() {

            }

            @Override
            public void onRequestFailed(int i) {

            }
        });

        mWeatherRepositoryComponent = DaggerWeatherRepositoryComponent.builder()
                .applicationModule(new ApplicationModule(getApplicationContext()))
                .weatherRepositoryModule(new WeatherRepositoryModule(Constants.WEATHER_HOST))
                .build();

        mWeatherRepositoryComponent.getWeatherRepository();
    }

    public WeatherRepositoryComponent getWeatherRepositoryComponent() {
        return mWeatherRepositoryComponent;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        LogUtils.i(TAG, "onLowMemory");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

        LogUtils.i(TAG, "onTrimMemory level : " + level);
    }

    private void enableStrictMode() {
        final StrictMode.ThreadPolicy.Builder threadPolicyBuilder = new StrictMode.ThreadPolicy.Builder()
                .detectAll().penaltyLog();
        final StrictMode.VmPolicy.Builder vmPolicyBuilder = new StrictMode.VmPolicy.Builder()
                .detectAll().penaltyLog();

        threadPolicyBuilder.penaltyFlashScreen();
        StrictMode.setThreadPolicy(threadPolicyBuilder.build());
        StrictMode.setVmPolicy(vmPolicyBuilder.build());
    }
}
