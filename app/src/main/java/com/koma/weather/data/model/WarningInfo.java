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

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by koma on 7/20/17.
 */

@Entity(nameInDb = "alarms")
public class WarningInfo implements Serializable {
    private static final long serialVersionUID = 7523967970034938917L;
    @Id(autoincrement = true)
    private Long id;
    /**
     * warning level
     */
    @Property(nameInDb = "level")
    @SerializedName("level")
    private String level;
    /**
     * warning status
     */
    @Property(nameInDb = "stat")
    @SerializedName("stat")
    private String status;
    /**
     * warning title
     */
    @Property(nameInDb = "title")
    @SerializedName("title")
    private String title;
    /**
     * warning details
     */
    @Property(nameInDb = "txt")
    @SerializedName("txt")
    private String description;
    /**
     * warning type
     */
    @Property(nameInDb = "type")
    @SerializedName("type")
    private String type;

    @Generated(hash = 202920188)
    public WarningInfo(Long id, String level, String status, String title, String description,
            String type) {
        this.id = id;
        this.level = level;
        this.status = status;
        this.title = title;
        this.description = description;
        this.type = type;
    }

    @Generated(hash = 1235338532)
    public WarningInfo() {
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("level :").append(this.level).append(",status :").append(this.status)
                .append("title :").append(this.title).append(",description :").append(this.description)
                .append(",type :").append(this.type);
        return builder.toString();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
