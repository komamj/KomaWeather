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

import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.koma.weather.R;
import com.koma.weather.base.BaseViewHolder;
import com.koma.weather.data.model.HeWeather;
import com.koma.weather.data.model.HourlyForecastInfo;
import com.koma.weather.util.LogUtils;
import com.koma.weather.util.Utils;

import butterknife.BindView;

/**
 * Created by koma on 7/22/17.
 */

public class HourlyForecastAdapter extends RecyclerView.Adapter<HourlyForecastAdapter.HourlyForecastVH> {
    private Context mContext;

    private HeWeather mData;

    public HourlyForecastAdapter(Context context) {
        mContext = context;
    }

    public void replaceData(final HeWeather data) {
        if (mData == null) {
            mData = data;

            notifyItemRangeInserted(0, data.getWeather().get(0).getHourlyForecastInfo().size());
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mData.getWeather().get(0).getHourlyForecastInfo().size();
                }

                @Override
                public int getNewListSize() {
                    return data.getWeather().get(0).getHourlyForecastInfo().size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return false;
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    return false;
                }
            });
            mData = data;

            result.dispatchUpdatesTo(this);
        }
    }

    @Override
    public HourlyForecastVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_hourly_forecast, parent, false);

        return new HourlyForecastVH(view);
    }

    @Override
    public void onBindViewHolder(HourlyForecastVH holder, int position) {
        HourlyForecastInfo hourlyForecastInfo = mData.getWeather().get(0)
                .getHourlyForecastInfo().get(position);

        holder.mTime.setText(Utils.getHourTime(hourlyForecastInfo.getDate()));
        holder.mHumidity.setText(Utils.formatHumidity(hourlyForecastInfo.getPcpnProbability()));
        holder.mTemperature.setText(Utils.formatTemperature(hourlyForecastInfo.getTemperature()));
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.getWeather().get(0).getHourlyForecastInfo().size();
    }

    static class HourlyForecastVH extends BaseViewHolder {
        @BindView(R.id.tv_time)
        TextView mTime;
        @BindView(R.id.tv_humidity)
        TextView mHumidity;
        @BindView(R.id.iv_weather)
        ImageView mWeatherIcon;
        @BindView(R.id.tv_temperature)
        TextView mTemperature;

        HourlyForecastVH(View itemView) {
            super(itemView);
        }
    }
}
