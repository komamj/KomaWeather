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

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.koma.weather.R;
import com.koma.weather.WeatherApplication;
import com.koma.weather.base.BaseFragment;
import com.koma.weather.data.model.DailyForecastInfo;
import com.koma.weather.data.model.Weather;
import com.koma.weather.util.LogUtils;
import com.koma.weather.widget.ScrollChildSwipeRefreshLayout;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by koma on 7/21/17.
 */

public class WeatherFragment extends BaseFragment implements WeatherContract.View {
    public static final String CITY = "city";
    private static final String TAG = WeatherFragment.class.getSimpleName();
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh_layout)
    ScrollChildSwipeRefreshLayout mRefreshLayout;
    @Inject
    WeatherPresenter mPresenter;

    private WeatherAdapter mAdapter;

    public static WeatherFragment newInstance() {
        return new WeatherFragment();
    }

    public static WeatherFragment newInstance(String city) {
        WeatherFragment weatherFragment = newInstance();

        Bundle bundle = new Bundle();
        bundle.putString(CITY, city);
        weatherFragment.setArguments(bundle);

        return weatherFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LogUtils.i(TAG, "onCreate");

        mAdapter = new WeatherAdapter(mContext);

        DaggerWeatherComponent.builder()
                .weatherRepositoryComponent(
                        ((WeatherApplication) getActivity().getApplication()).getWeatherRepositoryComponent())
                .weatherPresenterModule(new WeatherPresenterModule(this))
                .build().inject(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LogUtils.i(TAG, "onViewCreated");

        mRefreshLayout.setScrollUpChild(mRecyclerView);
        mRefreshLayout.setColorSchemeColors(
                ContextCompat.getColor(getActivity(), R.color.colorPrimary),
                ContextCompat.getColor(getActivity(), R.color.colorAccent),
                ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark)
        );
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.loadWeather();
            }
        });

        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LogUtils.i(TAG, "onActivityCreated");
    }

    @Override
    public void onResume() {
        super.onResume();

        LogUtils.i(TAG, "onResume");

        if (mPresenter != null) {
            mPresenter.subscribe();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        LogUtils.i(TAG, "onPause");

        if (mPresenter != null) {
            mPresenter.unSubscribe();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_weather;
    }

    @Override
    public void setPresenter(@NonNull WeatherContract.Presenter presenter) {
    }

    @Override
    public void setLoadingIndicator(final boolean active) {
        // Make sure setRefreshing() is called after the layout is done with everything else.
        mRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mRefreshLayout.setRefreshing(active);
            }
        });
    }

    @Override
    public void showWeather(Weather weather) {
        LogUtils.i(TAG, "showWeather : " + weather.getStatus() + "daily forecast :" + weather.getDailyForecastInfo().size());

        for (DailyForecastInfo info : weather.getDailyForecastInfo()) {
            LogUtils.i(TAG, "info :" + info.mTemperatureInfo);
        }

        if(mAdapter != null){
            mAdapter.replaceData(weather);
        }
    }

    @Override
    public boolean isActive() {
        return this.isAdded();
    }

    @Override
    public String getCity() {
        if (getArguments() != null) {
            return getArguments().getString(CITY);
        }

        return null;
    }

    @Override
    public void showSuccessfullyLoadedMessage() {

    }

    @Override
    public void showLoadingWeatherError() {

    }
}
