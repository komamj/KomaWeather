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

import com.koma.weather.data.model.HeWeather;
import com.koma.weather.data.source.WeatherRepository;
import com.koma.weather.util.LogUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by koma on 7/21/17.
 */

public class WeatherPresenter implements WeatherContract.Presenter {
    private static final String TAG = WeatherPresenter.class.getSimpleName();
    private final WeatherContract.View mView;

    private final WeatherRepository mRepository;

    private final CompositeDisposable mDisposables;

    @Inject
    public WeatherPresenter(WeatherContract.View view, WeatherRepository repository) {
        mView = view;

        mRepository = repository;

        mDisposables = new CompositeDisposable();
    }

    @Inject
    void setupListeners() {
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        LogUtils.i(TAG, "subscribe");

        loadWeather();
    }

    @Override
    public void loadWeather() {
        mView.setLoadingIndicator(true);

        mDisposables.clear();

        Disposable disposable = mRepository.getWeather(mView.getCity())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<HeWeather>() {
                    @Override
                    public void onNext(HeWeather heWeather) {
                        LogUtils.i(TAG, "onNext");
                        if (mView.isActive()) {
                            mView.setLoadingIndicator(false);
                            mView.showWeather(heWeather);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        LogUtils.e(TAG, "loadWeather error : " + t.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        mDisposables.add(disposable);
    }

    @Override
    public void unSubscribe() {
        LogUtils.i(TAG, "unSubscribe");
        mDisposables.clear();
    }
}
