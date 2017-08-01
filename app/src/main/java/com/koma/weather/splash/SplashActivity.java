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
package com.koma.weather.splash;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;

import com.koma.weather.R;
import com.koma.weather.base.BasePermissionActivity;
import com.koma.weather.main.MainActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by koma on 7/19/17.
 */

public class SplashActivity extends BasePermissionActivity {
    private static final int DEFAULT_TIME = 2;

    private CompositeDisposable mDisposables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public String[] getPermissions() {
        return new String[]{
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_PHONE_STATE
        };
    }

    @Override
    public void onPermissonGranted() {
        mDisposables = new CompositeDisposable();

        Disposable disposable = Flowable.timer(DEFAULT_TIME, TimeUnit.SECONDS)
                .subscribeWith(new DisposableSubscriber<Long>() {
                    @Override
                    public void onNext(Long aLong) {
                        launchMainActivity();
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {
                    }
                });

        mDisposables.add(disposable);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void launchMainActivity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        this.finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mDisposables != null) {
            mDisposables.clear();
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void onBackPressed() {
        //do nothing
    }
}
