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
package com.koma.weather.main;

import android.support.annotation.NonNull;

import com.koma.weather.data.model.Weather;
import com.koma.weather.data.source.WeatherRepository;
import com.koma.weather.util.LogUtils;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by koma on 7/27/17.
 */

public class MainPresenter implements MainContract.Presenter {
    private static final String TAG = MainPresenter.class.getSimpleName();

    private MainContract.View mView;

    private WeatherRepository mRepository;

    private CompositeDisposable mDisposables;

    @Inject
    public MainPresenter(MainContract.View view, @NonNull WeatherRepository repository) {
        mView = view;

        mRepository = repository;

        mDisposables = new CompositeDisposable();
    }

    @Inject
    void setUpListener() {
        mView.setPresenter(this);
    }

    @Override
    public void subscribe() {
        LogUtils.i(TAG, "subscribe");

        loadNowWeather();
    }

    @Override
    public void unSubscribe() {
        LogUtils.i(TAG, "unSubscribe");

        mDisposables.clear();
    }

    @Override
    public void loadNowWeather() {
        mDisposables.clear();

        Disposable disposable = mRepository.getNowWeather(mView.getCity())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<Weather>() {
                    @Override
                    public void onNext(Weather weather) {
                        if (mView != null) {
                            mView.showWeather(weather);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        LogUtils.e(TAG, "onError :" + t.toString());
                    }

                    @Override
                    public void onComplete() {
                        LogUtils.i(TAG, "complete");
                    }
                });

        mDisposables.add(disposable);
    }
}
