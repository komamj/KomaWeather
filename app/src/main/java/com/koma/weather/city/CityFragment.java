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

import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;

import com.koma.weather.R;
import com.koma.weather.base.BaseFragment;
import com.koma.weather.data.model.City;
import com.koma.weather.util.LogUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by koma on 8/8/17.
 */

public class CityFragment extends BaseFragment implements CityContract.View {
    private static final String TAG = CityFragment.class.getSimpleName();

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.view_stub)
    ViewStub mViewStub;
    private ContentLoadingProgressBar mProgressBar;

    private CityContract.Presenter mPresenter;

    private CityAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

        mAdapter = new CityAdapter();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewStub.inflate();

        mProgressBar = (ContentLoadingProgressBar) view.findViewById(R.id.progress_bar);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_city;
    }

    @Override
    public void setPresenter(CityContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        LogUtils.i(TAG, "setLoadingIndicator active : " + active);

        if (active) {
            if (mProgressBar != null) {
                mProgressBar.show();
            }
        } else {
            if (mProgressBar != null) {
                mProgressBar.hide();
            }
        }
    }

    @Override
    public void showCities(List<City> cities) {

    }

    @Override
    public boolean isActive() {
        return this.isAdded();
    }

    @Override
    public void showSuccessfullyLoadedMessage() {

    }

    @Override
    public void showLoadingCitiesError() {

    }
}
