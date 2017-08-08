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

import com.koma.weather.R;

/**
 * Created by koma on 8/7/17.
 */

public class ImageLoader {

    private static final String CODE_SUNNY = "100";
    private static final String CODE_CLOUDY = "101";
    private static final String CODE_FEW_CLOUDS = "102";
    private static final String CODE_PARTLY_CLOUDY = "103";
    private static final String CODE_OVERCAST = "104";
    //wind
    private static final String CODE_WINDY = "200";
    private static final String CODE_CALM = "201";
    private static final String CODE_LIGHT_BREEZE = "202";
    private static final String CODE_MODERATE = "203";
    private static final String CODE_FRESH_BREEZE = "204";
    private static final String CODE_STRONG_BREEZE = "205";
    private static final String CODE_HIGY_WIND = "206";
    private static final String CODE_GALE = "207";
    private static final String CODE_STRONG_GALE = "208";
    private static final String CODE_STORM = "209";
    private static final String CODE_VIOLENT_STORM = "210";
    private static final String CODE_HURRICANE = "211";
    private static final String CODE_TORNADO = "212";
    private static final String CODE_TROPICAL_STORM = "213";
    //rain
    private static final String CODE_SHOWER_RAIN = "300";
    private static final String CODE_HEAVY_SHOWER_RAIN = "301";
    private static final String CODE_THUNDERSHOWER = "302";
    private static final String CODE_HEAVY_THUNDERSTORM = "303";
    private static final String CODE_HAIL = "304";
    private static final String CODE_LIGHT_RAIN = "305";
    private static final String CODE_MODRATE_RAIN = "306";
    private static final String CODE_HEAVY_RAIN = "307";
    private static final String CODE_EXTREME_RAIN = "308";
    private static final String CODE_DRIZZLE_RAIN = "309";
    private static final String CODE_STORM_RAIN = "310";
    private static final String CODE_HEAVY_STORM = "311";
    private static final String CODE_SEVERE_STORM = "312";
    private static final String CODE_FREEZING_RAIN = "313";
    //snow
    private static final String CODE_LIGHT_SNOW = "400";
    private static final String CODE_MODERATE_SNOW = "401";
    private static final String CODE_HEAVY_SNOW = "402";
    private static final String CODE_SNOW_STORM = "403";
    private static final String CODE_SNOW_SLEET = "404";
    private static final String CODE_SNOW_AND_RAIN = "405";
    private static final String CODE_SHOWER_SNOW = "406";
    private static final String CODE_FLURRY_SNOW = "407";

    private static final String CODE_MIST = "500";
    private static final String CODE_FOGGY = "501";
    private static final String CODE_HAZE = "502";
    private static final String CODE_SAND = "503";
    private static final String CODE_DUST = "504";
    private static final String CODE_DUST_STORM = "507";
    private static final String CODE_SAND_STORM = "508";

    private static final String CODE_HOT = "900";
    private static final String CODE_COLD = "901";

    private static final String CODE_UNKNOWN = "999";


    public static int getResourceId(String weatherCode) {
        int resourceId;
        switch (weatherCode) {
            case CODE_SUNNY:
                resourceId = R.drawable.ic_sunny;
                break;
            case CODE_CLOUDY:
            case CODE_FEW_CLOUDS:
            case CODE_OVERCAST:
                resourceId = R.drawable.ic_cloudy;
                break;
            case CODE_PARTLY_CLOUDY:
                resourceId = R.drawable.ic_partly_cloudy;
                break;

            case CODE_WINDY:
            case CODE_CALM:
            case CODE_LIGHT_BREEZE:
            case CODE_MODERATE:
            case CODE_FRESH_BREEZE:
            case CODE_STRONG_BREEZE:
            case CODE_HIGY_WIND:
            case CODE_GALE:
            case CODE_STRONG_GALE:
            case CODE_STORM:
            case CODE_VIOLENT_STORM:
                resourceId = R.drawable.ic_violent_storm;
                break;
            case CODE_HURRICANE:
                resourceId = R.drawable.ic_hurricane;
                break;
            case CODE_TORNADO:
                resourceId = R.drawable.ic_tornado;
                break;
            case CODE_TROPICAL_STORM:
                resourceId = R.drawable.ic_tropical_storm;
                break;

            case CODE_SHOWER_RAIN:
                resourceId = R.drawable.ic_shower_rain;
                break;
            case CODE_HEAVY_SHOWER_RAIN:
                resourceId = R.drawable.ic_heavy_rain;
                break;
            case CODE_THUNDERSHOWER:
            case CODE_HEAVY_THUNDERSTORM:
                resourceId = R.drawable.ic_thunderstorm;
                break;
            case CODE_HAIL:
                resourceId = R.drawable.ic_hail;
                break;
            case CODE_LIGHT_RAIN:
            case CODE_MODRATE_RAIN:
                resourceId = R.drawable.ic_light_rain;
                break;
            case CODE_HEAVY_RAIN:
                resourceId = R.drawable.ic_heavy_rain;
                break;
            case CODE_EXTREME_RAIN:
            case CODE_DRIZZLE_RAIN:
            case CODE_STORM_RAIN:
            case CODE_HEAVY_STORM:
                resourceId = R.drawable.ic_rainstorm;
                break;
            case CODE_SEVERE_STORM:
                resourceId = R.drawable.ic_severe_rainstorm;
                break;
            case CODE_FREEZING_RAIN:
                resourceId = R.drawable.ic_hail;
                break;

            case CODE_LIGHT_SNOW:
            case CODE_MODERATE_SNOW:
                resourceId = R.drawable.ic_light_snow;
                break;
            case CODE_HEAVY_SNOW:
                resourceId = R.drawable.ic_heavy_snow;
                break;
            case CODE_SNOW_STORM:
                resourceId = R.drawable.ic_snowstorm;
                break;
            case CODE_SNOW_SLEET:
            case CODE_SNOW_AND_RAIN:
            case CODE_SHOWER_SNOW:
            case CODE_FLURRY_SNOW:
                resourceId = R.drawable.ic_rain_and_snow;
                break;

            case CODE_MIST:
            case CODE_FOGGY:
                resourceId = R.drawable.ic_foggy;
                break;
            case CODE_HAZE:
            case CODE_SAND:
                resourceId = R.drawable.ic_haze;
                break;
            case CODE_DUST:
            case CODE_DUST_STORM:
            case CODE_SAND_STORM:
                resourceId = R.drawable.ic_dust;
                break;

            case CODE_HOT:
            case CODE_COLD:
                //break;
            default:
                resourceId = R.drawable.ic_unknown;
        }
        return resourceId;
    }
}
