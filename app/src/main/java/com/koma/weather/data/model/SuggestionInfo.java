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
import com.koma.weather.util.BaseInfoConverter;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by koma on 7/19/17.
 */
@Entity(nameInDb = "suggestion_info")
public class SuggestionInfo implements Serializable {
    private static final long serialVersionUID = 7523967970034938912L;
    @Id(autoincrement = true)
    private Long id;
    @Convert(converter = BaseInfoConverter.class, columnType = String.class)
    @SerializedName("comf")
    private BaseInfo comforInfo;
    @Convert(converter = BaseInfoConverter.class, columnType = String.class)
    @SerializedName("cw")
    private BaseInfo carWashInfo;
    @Convert(converter = BaseInfoConverter.class, columnType = String.class)
    @SerializedName("drsg")
    private BaseInfo dressInfo;
    @Convert(converter = BaseInfoConverter.class, columnType = String.class)
    @SerializedName("flu")
    private BaseInfo coldInfo;
    @Convert(converter = BaseInfoConverter.class, columnType = String.class)
    @SerializedName("sport")
    private BaseInfo sportInfo;
    @Convert(converter = BaseInfoConverter.class, columnType = String.class)
    @SerializedName("trav")
    private BaseInfo travelInfo;
    @Convert(converter = BaseInfoConverter.class, columnType = String.class)
    @SerializedName("uv")
    private BaseInfo ultravioletInfo;


    @Generated(hash = 60063877)
    public SuggestionInfo(Long id, BaseInfo comforInfo, BaseInfo carWashInfo,
            BaseInfo dressInfo, BaseInfo coldInfo, BaseInfo sportInfo,
            BaseInfo travelInfo, BaseInfo ultravioletInfo) {
        this.id = id;
        this.comforInfo = comforInfo;
        this.carWashInfo = carWashInfo;
        this.dressInfo = dressInfo;
        this.coldInfo = coldInfo;
        this.sportInfo = sportInfo;
        this.travelInfo = travelInfo;
        this.ultravioletInfo = ultravioletInfo;
    }

    @Generated(hash = 1403800140)
    public SuggestionInfo() {
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Suggestion comf :").append(this.comforInfo.toString())
                .append(",cw :").append(this.carWashInfo.toString()).append(",drsg")
                .append(this.dressInfo.toString()).append(",flu :")
                .append(this.coldInfo.toString()).append(",sport :")
                .append(this.sportInfo.toString()).append(",trav :")
                .append(this.travelInfo.toString()).append(",uv :")
                .append(this.ultravioletInfo.toString());

        return builder.toString();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BaseInfo getComforInfo() {
        return this.comforInfo;
    }

    public void setComforInfo(BaseInfo comforInfo) {
        this.comforInfo = comforInfo;
    }

    public BaseInfo getCarWashInfo() {
        return this.carWashInfo;
    }

    public void setCarWashInfo(BaseInfo carWashInfo) {
        this.carWashInfo = carWashInfo;
    }

    public BaseInfo getDressInfo() {
        return this.dressInfo;
    }

    public void setDressInfo(BaseInfo dressInfo) {
        this.dressInfo = dressInfo;
    }

    public BaseInfo getColdInfo() {
        return this.coldInfo;
    }

    public void setColdInfo(BaseInfo coldInfo) {
        this.coldInfo = coldInfo;
    }

    public BaseInfo getSportInfo() {
        return this.sportInfo;
    }

    public void setSportInfo(BaseInfo sportInfo) {
        this.sportInfo = sportInfo;
    }

    public BaseInfo getTravelInfo() {
        return this.travelInfo;
    }

    public void setTravelInfo(BaseInfo travelInfo) {
        this.travelInfo = travelInfo;
    }

    public BaseInfo getUltravioletInfo() {
        return this.ultravioletInfo;
    }

    public void setUltravioletInfo(BaseInfo ultravioletInfo) {
        this.ultravioletInfo = ultravioletInfo;
    }

   /* public static class ComfortInfo implements Serializable {
        private static final long serialVersionUID = 7523967970034938905L;
        @SerializedName("brf")
        private String mBriefDescription;
        @SerializedName("txt")
        private String mDetail;

        public String getBriefDescription() {
            return this.mBriefDescription;
        }

        public void setBriefDescription(String briefDescription) {
            this.mBriefDescription = briefDescription;
        }

        public String getDetail() {
            return this.mDetail;
        }

        public void setDetail(String detail) {
            this.mDetail = detail;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("brief :").append(this.mBriefDescription)
                    .append(",txt :").append(this.mBriefDescription);

            return builder.toString();
        }

        public String getMBriefDescription() {
            return this.mBriefDescription;
        }

        public void setMBriefDescription(String mBriefDescription) {
            this.mBriefDescription = mBriefDescription;
        }

        public String getMDetail() {
            return this.mDetail;
        }

        public void setMDetail(String mDetail) {
            this.mDetail = mDetail;
        }
    }

    public static class CarWashInfo implements Serializable {
        private static final long serialVersionUID = 7523967970034938902L;
        @SerializedName("brf")
        private String briefDescription;
        @SerializedName("txt")
        private String detail;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("brief :").append(this.briefDescription)
                    .append(",txt :").append(this.detail);

            return builder.toString();
        }

        public String getBriefDescription() {
            return this.briefDescription;
        }

        public void setBriefDescription(String briefDescription) {
            this.briefDescription = briefDescription;
        }

        public String getDetail() {
            return this.detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }

    public static class DressInfo implements Serializable {
        private static final long serialVersionUID = 7523967970034938907L;
        @SerializedName("brf")
        private String mBriefDescription;
        @SerializedName("txt")
        private String mDetail;

        public String getBriefDescription() {
            return this.mBriefDescription;
        }

        public void setBriefDescription(String briefDescription) {
            this.mBriefDescription = briefDescription;
        }

        public String getDetail() {
            return this.mDetail;
        }

        public void setDetail(String detail) {
            this.mDetail = detail;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("brief :").append(this.mBriefDescription)
                    .append(",txt :").append(this.mBriefDescription);

            return builder.toString();
        }
    }

    public static class ColdInfo implements Serializable {
        private static final long serialVersionUID = 7523967970034938904L;

        @SerializedName("brf")
        private String briefDescription;
        @SerializedName("txt")
        private String detail;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("brief :").append(this.briefDescription)
                    .append(",txt :").append(this.detail);

            return builder.toString();
        }

        public String getBriefDescription() {
            return this.briefDescription;
        }

        public void setBriefDescription(String briefDescription) {
            this.briefDescription = briefDescription;
        }

        public String getDetail() {
            return this.detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }

    public static class SportInfo implements Serializable {
        private static final long serialVersionUID = 7523967970034938911L;

        @SerializedName("brf")
        private String mBriefDescription;
        @SerializedName("txt")
        private String mDetail;

        public String getBriefDescription() {
            return this.mBriefDescription;
        }

        public void setBriefDescription(String briefDescription) {
            this.mBriefDescription = briefDescription;
        }

        public String getDetail() {
            return this.mDetail;
        }

        public void setDetail(String detail) {
            this.mDetail = detail;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("brief :").append(this.mBriefDescription)
                    .append(",txt :").append(this.mBriefDescription);

            return builder.toString();
        }
    }

    public static class TravelInfo implements Serializable {
        private static final long serialVersionUID = 7523967970034938914L;
        @SerializedName("brf")
        private String mBriefDescription;
        @SerializedName("txt")
        private String mDetail;

        public String getBriefDescription() {
            return this.mBriefDescription;
        }

        public void setBriefDescription(String briefDescription) {
            this.mBriefDescription = briefDescription;
        }

        public String getDetail() {
            return this.mDetail;
        }

        public void setDetail(String detail) {
            this.mDetail = detail;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("brief :").append(this.mBriefDescription)
                    .append(",txt :").append(this.mBriefDescription);

            return builder.toString();
        }
    }

    public static class UltravioletInfo implements Serializable {
        private static final long serialVersionUID = 7523967970034938915L;
        @SerializedName("brf")
        private String mBriefDescription;
        @SerializedName("txt")
        private String mDetail;

        public String getBriefDescription() {
            return this.mBriefDescription;
        }

        public void setBriefDescription(String briefDescription) {
            this.mBriefDescription = briefDescription;
        }

        public String getDetail() {
            return this.mDetail;
        }

        public void setDetail(String detail) {
            this.mDetail = detail;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("brief :").append(this.mBriefDescription)
                    .append(",txt :").append(this.mBriefDescription);

            return builder.toString();
        }
    }*/

    public static class BaseInfo implements Serializable {
        private static final long serialVersionUID = 7523967970034938915L;
        @SerializedName("brf")
        private String mBriefDescription;
        @SerializedName("txt")
        private String mDetail;

        public String getBriefDescription() {
            return this.mBriefDescription;
        }

        public void setBriefDescription(String briefDescription) {
            this.mBriefDescription = briefDescription;
        }

        public String getDetail() {
            return this.mDetail;
        }

        public void setDetail(String detail) {
            this.mDetail = detail;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("brief :").append(this.mBriefDescription)
                    .append(",txt :").append(this.mBriefDescription);

            return builder.toString();
        }
    }
}
