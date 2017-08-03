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

import com.koma.weather.R;
import com.koma.weather.data.model.AqiInfo;
import com.koma.weather.util.LogUtils;

import butterknife.BindArray;
import butterknife.ButterKnife;

/**
 * Created by koma on 7/27/17.
 */

public class AqiView extends View {
    @BindArray(R.array.indicator_colors)
    int[] mIndicatorColors;

    private Float mCurrentPercent;
    private TextPaint mPaint;
    private RectF rectF = new RectF();
    private AqiInfo.CityInfo mCityInfo;

    private float mRadius;

    public AqiView(Context context) {
        super(context);

        init();
    }

    public AqiView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AqiView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public AqiView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();

        ButterKnife.bind(this, this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        final float w = getWidth();
        final float h = getHeight();
        if (w <= 0 || h <= 0) {
            return;
        }
        final float lineSize = w / 10f;// 大约是12dp
        if (mCityInfo == null) {
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setTextSize(lineSize * 1.25f);
            mPaint.setColor(0xaaffffff);
            canvas.drawText("暂无数据", w / 2f, h / 2f, mPaint);
            return;
        }


        canvas.translate(w / 2f, h / 2f);

        canvas.save();
        float aqiArcRadius = lineSize * 4f;
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(lineSize * 1);

        rectF.set(-aqiArcRadius, -aqiArcRadius, aqiArcRadius, aqiArcRadius);

        // draw aqi restPercent arc
        float startAngle = -180f;
        for (int i = 0; i <= 5; i++) {
            mPaint.setColor(mIndicatorColors[i]);
            if (i == 4) {
                canvas.drawArc(rectF, startAngle, 40f, false, mPaint);
                startAngle += 36f;
            } else if (i == 5) {
                canvas.drawArc(rectF, startAngle, 72f, false, mPaint);
            } else {
                canvas.drawArc(rectF, startAngle, 20f, false, mPaint);
                startAngle += 18f;
            }
        }

        if (mCurrentPercent >= 0f) {
            if (mCurrentPercent <= 0.1f) {
                mPaint.setColor(mIndicatorColors[0]);
            } else if (mCurrentPercent <= 0.2f) {
                mPaint.setColor(mIndicatorColors[1]);
            } else if (mCurrentPercent <= 0.3f) {
                mPaint.setColor(mIndicatorColors[2]);
            } else if (mCurrentPercent <= 0.4f) {
                mPaint.setColor(mIndicatorColors[3]);
            } else if (mCurrentPercent <= 0.6f) {
                mPaint.setColor(mIndicatorColors[4]);
            } else {
                mPaint.setColor(mIndicatorColors[5]);
            }
            // draw aqi arc center circle
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setStrokeWidth(lineSize / 8f);
            canvas.drawCircle(0, 0, lineSize / 10f, mPaint);
            // draw the aqi line
            canvas.rotate(180 * mCurrentPercent);
            mPaint.setStrokeWidth(lineSize / 20f);
            mPaint.setStyle(Paint.Style.STROKE);
            float startX = lineSize / 10f;
            canvas.drawLine(-startX, 0, -lineSize * 3.5f, 0, mPaint);
            // draw aqi number and text
            canvas.restore();
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setTextSize(lineSize * 1.5f);
            try {
                canvas.drawText(mCityInfo.getAqi() + "", 0, lineSize * 3, mPaint);
            } catch (Exception e) {
            }
            mPaint.setTextSize(lineSize * 1f);
            try {
                canvas.drawText(mCityInfo.getQuality() + "", 0, lineSize * 4.25f, mPaint);
            } catch (Exception e) {
            }


        }
    }

    public void setData(AqiInfo aqiInfo) {
        if (aqiInfo != null && aqiInfo.getCityInfo() != null) {
            this.mCityInfo = aqiInfo.getCityInfo();

            mCurrentPercent = Float.valueOf(mCityInfo.getAqi()) / 500f;
            mCurrentPercent = Math.min(mCurrentPercent, 1f);

            invalidate();
        }
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, widthMeasureSpec);
    }

    /**
     * Determines the width of this view
     *
     * @param measureSpec A measureSpec packed into an int
     * @return The width of the view, honoring constraints from measureSpec
     */
    private int measureLong(int measureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if ((specMode == MeasureSpec.EXACTLY)) {
            //We were told how big to be
            result = specSize;
        } else {
            //Calculate the width according the views count
            result = getPaddingLeft() + getPaddingRight();
            //Respect AT_MOST value if that was what is called for by measureSpec
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    /**
     * Determines the height of this view
     *
     * @param measureSpec A measureSpec packed into an int
     * @return The height of the view, honoring constraints from measureSpec
     */
    private int measureShort(int measureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            //We were told how big to be
            result = specSize;
        } else {
            //Measure the height
            result = getPaddingTop() + getPaddingBottom();
            //Respect AT_MOST value if that was what is called for by measureSpec
            if (specMode == MeasureSpec.AT_MOST) {
                result = Math.min(result, specSize);
            }
        }
        return result;
    }
}
