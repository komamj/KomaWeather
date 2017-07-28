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
import com.koma.weather.data.model.Weather;
import com.koma.weather.util.Utils;
import com.koma.weather.widget.AqiView;

import butterknife.BindView;

/**
 * Created by koma on 7/26/17.
 */

public class WeatherAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final int VIEW_TYPE_NOW_INFO = 0;
    private static final int VIEW_TYPE_AQI_INFO = VIEW_TYPE_NOW_INFO + 1;
    private static final int VIEW_TYPE_SUGGESTION_INFO = VIEW_TYPE_AQI_INFO + 1;
    private static final int VIEW_TYPE_WIND_INFO = VIEW_TYPE_SUGGESTION_INFO + 1;

    private Context mContext;

    private Weather mData;

    public WeatherAdapter(Context context) {
        mContext = context;
    }

    public void replaceData(final Weather weather) {
        if (mData == null) {
            mData = weather;

            //notifyItemRangeInserted(0, 4);
            notifyDataSetChanged();
        } else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return 4;
                }

                @Override
                public int getNewListSize() {
                    return 4;
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
            mData = weather;

            result.dispatchUpdatesTo(this);
        }
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder = null;
        if (viewType == VIEW_TYPE_NOW_INFO) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_now_info, parent, false);
            viewHolder = new NowInfoVH(view);
        } else if (viewType == VIEW_TYPE_AQI_INFO) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_aqi_info, parent, false);
            viewHolder = new AqiInfoVH(view);
        } else if (viewType == VIEW_TYPE_SUGGESTION_INFO) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_suggestion_info, parent, false);
            viewHolder = new SuggestionVH(view);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_now_info, parent, false);
            viewHolder = new NowInfoVH(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        if (viewType == VIEW_TYPE_NOW_INFO) {
            NowInfoVH nowInfoVH = (NowInfoVH) holder;
            nowInfoVH.mTxt.setText(mData.getNowInfo().getConditionInfo().getDescription());
            nowInfoVH.mFl.setText(Utils.formatTemperature(mData.getNowInfo().getSendibleTemp()));
            nowInfoVH.mHum.setText(Utils.formatHumidity(mData.getNowInfo().getHumidity()));
            nowInfoVH.mTemp.setText(Utils.formatTemperature(mData.getNowInfo().getTemperature()));
            nowInfoVH.mPcpn.setText(Utils.formatPcpn(mData.getNowInfo().getPrecipitation()));
            nowInfoVH.mVis.setText(Utils.formatVisibility(mData.getNowInfo().getVisibility()));
        } else if (viewType == VIEW_TYPE_AQI_INFO) {
            AqiInfoVH aqiInfoVH = (AqiInfoVH) holder;
            aqiInfoVH.mAqiView.setData(mData.getAqiInfo());
            aqiInfoVH.mCO.setText(Utils.formatAqi(mData.getAqiInfo().getCityInfo().getCo()));
            aqiInfoVH.mNO2.setText(Utils.formatAqi(mData.getAqiInfo().getCityInfo().getNo2()));
            aqiInfoVH.mO3.setText(Utils.formatAqi(mData.getAqiInfo().getCityInfo().getO3()));
            aqiInfoVH.mPM10.setText(Utils.formatAqi(mData.getAqiInfo().getCityInfo().getPm10()));
            aqiInfoVH.mPM25.setText(Utils.formatAqi(mData.getAqiInfo().getCityInfo().getPm25()));
            aqiInfoVH.mSO2.setText(Utils.formatAqi(mData.getAqiInfo().getCityInfo().getSo2()));
        } else if (viewType == VIEW_TYPE_SUGGESTION_INFO) {
            SuggestionVH suggestionVH = (SuggestionVH) holder;
            suggestionVH.mComfBrf.setText(mData.getSuggerstionInfo().getComforInfo().getBriefDescription());
            suggestionVH.mComfTxt.setText(mData.getSuggerstionInfo().getComforInfo().getDetail());
            suggestionVH.mCwBrf.setText(mData.getSuggerstionInfo().getCarWashInfo().getBriefDescription());
            suggestionVH.mCwTxt.setText(mData.getSuggerstionInfo().getCarWashInfo().getDetail());
            suggestionVH.mDrsgBrf.setText(mData.getSuggerstionInfo().getDressInfo().getBriefDescription());
            suggestionVH.mDrsgTxt.setText(mData.getSuggerstionInfo().getDressInfo().getDetail());
            suggestionVH.mFluBrf.setText(mData.getSuggerstionInfo().getColdInfo().getBriefDescription());
            suggestionVH.mFluTxt.setText(mData.getSuggerstionInfo().getColdInfo().getDetail());
            suggestionVH.mSportBrf.setText(mData.getSuggerstionInfo().getSportInfo().getBriefDescription());
            suggestionVH.mSportTxt.setText(mData.getSuggerstionInfo().getSportInfo().getDetail());
            suggestionVH.mTravBrf.setText(mData.getSuggerstionInfo().getTravelInfo().getBriefDescription());
            suggestionVH.mTravTxt.setText(mData.getSuggerstionInfo().getTravelInfo().getDetail());
            suggestionVH.mUvBrf.setText(mData.getSuggerstionInfo().getUltravioletInfo().getBriefDescription());
            suggestionVH.mUvTxt.setText(mData.getSuggerstionInfo().getUltravioletInfo().getDetail());
        } else {
        }
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_NOW_INFO;
        } else if (position == 1) {
            return VIEW_TYPE_AQI_INFO;
        } else if (position == 2) {
            return VIEW_TYPE_SUGGESTION_INFO;
        } else {
            return VIEW_TYPE_WIND_INFO;
        }
    }

    static class AqiInfoVH extends BaseViewHolder {
        @BindView(R.id.aqi_view)
        AqiView mAqiView;
        @BindView(R.id.tv_aqi_co)
        TextView mCO;
        @BindView(R.id.tv_aqi_no2)
        TextView mNO2;
        @BindView(R.id.tv_aqi_o3)
        TextView mO3;
        @BindView(R.id.tv_aqi_pm10)
        TextView mPM10;
        @BindView(R.id.tv_aqi_pm25)
        TextView mPM25;
        @BindView(R.id.tv_aqi_so2)
        TextView mSO2;
        public AqiInfoVH(View itemView) {
            super(itemView);
        }
    }

    static class NowInfoVH extends BaseViewHolder {
        @BindView(R.id.tv_now_txt)
        TextView mTxt;
        @BindView(R.id.tv_now_temp)
        TextView mTemp;
        @BindView(R.id.iv_now)
        ImageView mNowImage;
        @BindView(R.id.tv_now_fl)
        TextView mFl;
        @BindView(R.id.tv_now_hum)
        TextView mHum;
        @BindView(R.id.tv_now_pcpn)
        TextView mPcpn;
        @BindView(R.id.tv_now_vis)
        TextView mVis;

        public NowInfoVH(View itemView) {
            super(itemView);
        }
    }

    static class SuggestionVH extends BaseViewHolder {
        @BindView(R.id.tv_comf_brf)
        TextView mComfBrf;
        @BindView(R.id.tv_comf_txt)
        TextView mComfTxt;
        @BindView(R.id.tv_cw_brf)
        TextView mCwBrf;
        @BindView(R.id.tv_cw_txt)
        TextView mCwTxt;
        @BindView(R.id.tv_drsg_brf)
        TextView mDrsgBrf;
        @BindView(R.id.tv_drsg_txt)
        TextView mDrsgTxt;
        @BindView(R.id.tv_flu_brf)
        TextView mFluBrf;
        @BindView(R.id.tv_flu_txt)
        TextView mFluTxt;
        @BindView(R.id.tv_sport_brf)
        TextView mSportBrf;
        @BindView(R.id.tv_sport_txt)
        TextView mSportTxt;
        @BindView(R.id.tv_trav_brf)
        TextView mTravBrf;
        @BindView(R.id.tv_trav_txt)
        TextView mTravTxt;
        @BindView(R.id.tv_uv_brf)
        TextView mUvBrf;
        @BindView(R.id.tv_uv_txt)
        TextView mUvTxt;

        public SuggestionVH(View itemView) {
            super(itemView);
        }
    }
}
