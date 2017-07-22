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

import java.io.Serializable;

/**
 * Created by koma on 7/20/17.
 */

public class WarningInfo implements Serializable {
    /**
     * warning level
     */
    private String mLevel;
    /**
     * warning status
     */
    private String mStatus;
    /**
     * warning title
     */
    private String mTitle;
    /**
     * warning details
     */
    private String mDescription;
    /**
     * warning type
     */
    private String mType;

    public void setLevel(String level) {
        this.mLevel = level;
    }

    public String getLevel() {
        return this.mLevel;
    }

    public void setStatus(String status) {
        this.mStatus = status;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setType(String type) {
        this.mType = type;
    }

    public String getType() {
        return this.mType;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("level :").append(this.mLevel).append(",status :").append(this.mStatus)
                .append("title :").append(this.mTitle).append(",description :").append(this.mDescription)
                .append(",type :").append(this.mType);
        return builder.toString();
    }
}
