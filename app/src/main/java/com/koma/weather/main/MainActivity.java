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

import android.Manifest;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.koma.weather.R;
import com.koma.weather.WeatherApplication;
import com.koma.weather.base.BasePermissionActivity;
import com.koma.weather.data.model.Weather;
import com.koma.weather.util.LogUtils;
import com.koma.weather.util.Utils;
import com.koma.weather.weathers.WeatherFragment;
import com.koma.weather.widget.CirclePageIndicator;
import com.umeng.analytics.MobclickAgent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BasePermissionActivity implements
        NavigationView.OnNavigationItemSelectedListener, AppBarLayout.OnOffsetChangedListener,
        ViewPager.OnPageChangeListener, MainContract.View {
    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.app_bar)
    AppBarLayout mAppbar;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.tv_city_name)
    TextView mCityName;
    @BindView(R.id.tv_update_info)
    TextView mUpdateInfo;
    @BindView(R.id.tv_temperature)
    TextView mTemperature;
    @BindView(R.id.circle_page_indicator)
    CirclePageIndicator mIndicator;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout mToolbarLayout;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.nav_view)
    NavigationView mNavgationView;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    @Inject
    MainPresenter mPresenter;

    WeatherFragmentPagerAdapter mAdapter;

    @OnClick(R.id.fab)
    void showSnackbar(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LogUtils.i(TAG, "onCreate");

        mToolbar.setTitle("");

        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavgationView.setNavigationItemSelectedListener(this);
        mAppbar.addOnOffsetChangedListener(this);
    }

    @Override
    public String[] getPermissions() {
        return new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
    }

    @Override
    public void onPermissonGranted() {
        DaggerMainComponent.builder().weatherRepositoryComponent(
                ((WeatherApplication) getApplication()).getWeatherRepositoryComponent())
                .mainPresenterModule(new MainPresenterModule(this))
                .build()
                .inject(this);

        mAdapter = new WeatherFragmentPagerAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mAdapter);

        mIndicator.setViewPager(mViewPager, 0);
        mIndicator.setOnPageChangeListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onResume() {
        super.onResume();

        LogUtils.i(TAG, "onResume");

        MobclickAgent.onResume(this);

        if (mPresenter != null) {
            mPresenter.subscribe();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        LogUtils.i(TAG, "onPause");

        MobclickAgent.onPause(this);

        if (mPresenter != null) {
            mPresenter.unSubscribe();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_add) {
        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_exit) {
            this.finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        LogUtils.i(TAG, "onOffsetChanged verticalOffset : " + verticalOffset);
        int maxScroll = appBarLayout.getTotalScrollRange();
        float offsetPercent = (float) Math.abs(verticalOffset) / (float) maxScroll;
        mTemperature.setAlpha(1 - offsetPercent);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        LogUtils.i(TAG, "onPageScrolled position : " + position + ",positionOffset : "
                + positionOffset + ",positionOffsetPixels :" + positionOffsetPixels);
    }

    @Override
    public void onPageSelected(int position) {
        LogUtils.i(TAG, "onPageSelected position : " + position);

        mCityName.setText(getCity());

        mPresenter.loadNowWeather();
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        LogUtils.i(TAG, "onPageScrollStateChanged state : " + state);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }

    @Override
    public void showWeather(Weather weather) {
        LogUtils.i(TAG, "showWeather");

        mCityName.setText(getCity());
        mTemperature.setText(Utils.formatTemperature(weather.getNowInfo().getTemperature()));
        mUpdateInfo.setText(weather.getBasicInfo().getUpdateInfo().getTimeLocal());
    }

    @Override
    public String getCity() {
        String city = ((WeatherFragment) mAdapter.getItem(mViewPager.getCurrentItem())).getCity();

        return city;
    }

    private class WeatherFragmentPagerAdapter extends FragmentPagerAdapter {
        public WeatherFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            WeatherFragment weatherFragment = null;
            if (position == 0) {
                weatherFragment = WeatherFragment.newInstance("深圳");
            } else if (position == 1) {
                weatherFragment = WeatherFragment.newInstance("长沙");
            } else if (position == 2) {
                weatherFragment = WeatherFragment.newInstance("成都");
            } else if (position == 3) {
                weatherFragment = WeatherFragment.newInstance("重庆");
            }
            return weatherFragment;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
