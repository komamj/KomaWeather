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
package com.koma.weather.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.koma.weather.data.model.AqiInfo;

/**
 * Created by koma on 7/27/17.
 */

public class AqiView extends View {
    private TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    private RectF rectF = new RectF();
    private AqiInfo.CityInfo mCityInfo;

    public AqiView(Context context, AttributeSet attrs) {
        super(context, attrs);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        final float w = getWidth();
        final float h = getHeight();
        if (w <= 0 || h <= 0) {
            return;
        }
        final float lineSize = h / 10f;// 大约是12dp
        if (mCityInfo == null) {
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setTextSize(lineSize * 1.25f);
            textPaint.setColor(0xaaffffff);
            canvas.drawText("暂无数据", w / 2f, h / 2f, textPaint);
            return;
        }
        float currAqiPercent = -1f;
        try {
            currAqiPercent = Float.valueOf(mCityInfo.getAqi()) / 500f;// 污染%
            currAqiPercent = Math.min(currAqiPercent, 1f);
        } catch (Exception e) {
            e.printStackTrace();
        }

        float aqiArcRadius = lineSize * 4f;
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setStrokeWidth(lineSize * 1);
        textPaint.setColor(0x55ffffff);
        rectF.set(-aqiArcRadius, -aqiArcRadius, aqiArcRadius, aqiArcRadius);
        final int saveCount = canvas.save();
        canvas.translate(w / 2f, h / 2f);
        // draw aqi restPercent arc
        final float startAngle = -210f;
        final float sweepAngle = 240f;
        canvas.drawArc(rectF, startAngle + sweepAngle * currAqiPercent, sweepAngle * (1f - currAqiPercent), false,
                textPaint);
        if (currAqiPercent >= 0f) {
            // draw aqi aqiPercent arc
            textPaint.setColor(0x99ffffff);
            canvas.drawArc(rectF, startAngle, sweepAngle * currAqiPercent, false, textPaint);
            // draw aqi arc center circle
            textPaint.setColor(0xffffffff);
            textPaint.setStrokeWidth(lineSize / 8f);
            canvas.drawCircle(0, 0, lineSize / 3f, textPaint);
            // draw aqi number and text
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setTextSize(lineSize * 1.5f);
            textPaint.setColor(0xffffffff);
            try {
                canvas.drawText(mCityInfo.getAqi() + "", 0, lineSize * 3, textPaint);
            } catch (Exception e) {
            }
            textPaint.setTextSize(lineSize * 1f);
            textPaint.setColor(0x88ffffff);
            try {
                canvas.drawText(mCityInfo.getQuality() + "", 0, lineSize * 4.25f, textPaint);
            } catch (Exception e) {
            }

            // draw the aqi line
            canvas.rotate(startAngle + sweepAngle * currAqiPercent - 180f);
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setColor(0xffffffff);
            float startX = lineSize / 3f;
            canvas.drawLine(-startX, 0, -lineSize * 4.5f, 0, textPaint);
        }
        canvas.restoreToCount(saveCount);
    }

    public void setData(AqiInfo aqiInfo) {
        if (aqiInfo != null && aqiInfo.getCityInfo() != null) {
            this.mCityInfo = aqiInfo.getCityInfo();
            invalidate();
        }
    }
}
