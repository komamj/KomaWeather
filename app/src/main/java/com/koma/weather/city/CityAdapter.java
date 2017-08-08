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

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.koma.weather.base.BaseViewHolder;

/**
 * Created by koma on 8/8/17.
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityVH> {
    @Override
    public CityVH onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CityVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class CityVH extends BaseViewHolder {

        public CityVH(View itemView) {
            super(itemView);
        }
    }
}
