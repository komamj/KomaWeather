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
package com.koma.weather.util;

import android.support.annotation.Nullable;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;

import java.io.InputStream;

/**
 * Created by koma on 8/5/17.
 */

public class WeatherModelLoader implements ModelLoader<String,InputStream> {
    @Nullable
    @Override
    public LoadData<InputStream> buildLoadData(String s, int width, int height, Options options) {
        return null;
    }

    @Override
    public boolean handles(String s) {
        return false;
    }
}
