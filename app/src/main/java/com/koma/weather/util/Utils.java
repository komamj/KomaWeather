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

import android.os.Build;

/**
 * Created by koma on 7/22/17.
 */

public class Utils {
    /**
     * API 21
     *
     * @see Build.VERSION_CODES#LOLLIPOP
     */
    public static boolean hasLollipop() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    /**
     * API 23
     *
     * @see Build.VERSION_CODES#M
     */
    public static boolean hasMarshmallow() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    /**
     * API 24
     *
     * @see Build.VERSION_CODES#N
     */
    public static boolean hasNougat() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.N;
    }

    public static String getHourTime(String date) {
        return date.substring(date.length() - 5, date.length());
    }

    public static String formatTemperature(String temperature) {
        return String.format("%s℃", temperature);
    }

    public static String formatHumidity(String humidity) {
        return String.format("%s%%", humidity);
    }

    public static String formatAqi(String aqi) {
        return String.format("%sμg/m³", aqi);
    }

    public static String formatPcpn(String pcpn) {
        return String.format("%smm", pcpn);
    }

    public static String formatVisibility(String visibily) {
        return String.format("%skm", visibily);
    }
}
