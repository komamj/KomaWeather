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
package com.koma.weather.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by koma on 7/20/17.
 */

public class CarWashInfo implements Serializable{
    @SerializedName("brf")
    private String mBriefDescription;
    @SerializedName("txt")
    private String mDetail;

    public void setBriefDescription(String briefDescription) {
        this.mBriefDescription = briefDescription;
    }

    public String getBriefDescription() {
        return this.mBriefDescription;
    }

    public void setDetail(String detail) {
        this.mDetail = detail;
    }

    public String getDetail() {
        return this.mDetail;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("brief :").append(this.mBriefDescription)
                .append(",txt :").append(this.mBriefDescription);

        return builder.toString();
    }
}
