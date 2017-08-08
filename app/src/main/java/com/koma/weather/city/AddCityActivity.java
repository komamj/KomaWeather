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

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;

import com.koma.weather.R;
import com.koma.weather.WeatherApplication;
import com.koma.weather.base.BaseActivity;
import com.koma.weather.util.LogUtils;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by koma on 8/8/17.
 */

public class AddCityActivity extends BaseActivity implements SearchView.OnQueryTextListener {
    private static final String TAG = AddCityActivity.class.getSimpleName();

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    private SearchView mSearchView;

    @Inject
    CityPresenter mPresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LogUtils.i(TAG, "onCreate");

        init();
    }

    private void init() {
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        CityFragment cityFragment = (CityFragment) getSupportFragmentManager()
                .findFragmentById(R.id.city_fragment);

        DaggerCityComponent.builder().cityPresenterModule(new CityPresenterModule(cityFragment))
                .weatherRepositoryComponent(
                        ((WeatherApplication) getApplication()).getWeatherRepositoryComponent())
                .build().inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        LogUtils.i(TAG, "onStart");

        if (mPresenter != null) {
            mPresenter.subscribe();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        LogUtils.i(TAG, "onStop");

        if (mPresenter != null) {
            mPresenter.unSubscribe();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_city, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchItem = menu.findItem(R.id.action_search);
            MenuItemCompat.setOnActionExpandListener(
                    searchItem, new MenuItemCompat.OnActionExpandListener() {
                        @Override
                        public boolean onMenuItemActionExpand(MenuItem item) {
                            return true;
                        }

                        @Override
                        public boolean onMenuItemActionCollapse(MenuItem item) {

                            return true;
                        }
                    });
            mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
            mSearchView.setInputType(InputType.TYPE_TEXT_VARIATION_FILTER);
            mSearchView.setImeOptions(EditorInfo.IME_ACTION_DONE | EditorInfo.IME_FLAG_NO_FULLSCREEN);
            mSearchView.setQueryHint(getString(R.string.action_search));
            mSearchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            mSearchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // If SearchView is visible, back key cancels search and iconify it
        if (mSearchView != null && !mSearchView.isIconified()) {
            mSearchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_city;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
