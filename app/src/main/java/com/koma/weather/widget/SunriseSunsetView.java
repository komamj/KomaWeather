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
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;

import com.koma.weather.R;
import com.koma.weather.util.LogUtils;
import com.koma.weather.util.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.ButterKnife;

/**
 * Created by koma on 8/2/17.
 */

public class SunriseSunsetView extends View {
    @BindDimen(R.dimen.default_arc_dash_height)
    int mArcDashHeight;
    @BindDimen(R.dimen.default_sun_size)
    int mSunSize;
    @BindDimen(R.dimen.default_interval_size)
    int mIntervalSize;
    @BindDimen(R.dimen.default_bottom_line_height)
    int mBottomLineHeight;
    @BindDimen(R.dimen.default_text_size)
    int mTextSize;
    @BindColor(R.color.default_sun_color)
    int mSunColor;
    @BindColor(R.color.default_text_color)
    int mTimeTextColor;
    @BindColor(R.color.default_bottom_line_color)
    int mBottomLineColor;
    @BindColor(R.color.default_arc_color)
    int mArcColor;
    @BindColor(R.color.default_arc_solid_color)
    int mArcSolidColor;
    private Paint mPaint;
    private String mSunriseTime;
    private String mSunsetTime;
    private String mCurrentTime;
    private int mRadius;
    private RectF mArcRectF = new RectF();
    private DashPathEffect mDashPathEffect;
    private DateFormat mDateFormat;

    private float offsetX;
    private float offsetY;


    public SunriseSunsetView(Context context) {
        this(context, null);
    }

    public SunriseSunsetView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SunriseSunsetView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if (isInEditMode()) {
            return;
        }

        if (Utils.hasNougat()) {
            mDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault(Locale.Category.FORMAT));
        } else {
            mDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        }


        mCurrentTime = mDateFormat.format(new Date());

        LogUtils.i("", "mCurrentTime :" + mCurrentTime);


        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();

        ButterKnife.bind(this, this);

        mDashPathEffect = new DashPathEffect(new float[]{mIntervalSize, mIntervalSize}, 0);
    }

    public void setTime(String sunriseTime, String sunsetTime) {
        mSunriseTime = sunriseTime;
        mSunsetTime = sunsetTime;

        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(widthMeasureSpec, widthMeasureSpec / 2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (TextUtils.isEmpty(mSunriseTime) || TextUtils.isEmpty(mSunsetTime)) {
            return;
        }

        mPaint.setColor(mBottomLineColor);
        mPaint.setStrokeWidth(mBottomLineHeight);
        mPaint.setStyle(Paint.Style.STROKE);

        canvas.drawLine(getPaddingLeft(), getHeight() - getBottomHeightGap(),
                getWidth() - getPaddingRight(), getHeight() - getBottomHeightGap(), mPaint);

        int width = getWidth() - getWidthGap();
        int height = getHeight() - getHeightGap();

        if (width / 2 > height) {
            mRadius = height;
        } else {
            mRadius = width / 2;
        }

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mArcColor);
        mPaint.setStrokeWidth(mArcDashHeight);

        float left = getPaddingLeft() + (getWidth() - getPaddingLeft() - getPaddingRight() - 2 * mRadius) / 2;
        float top = getHeight() - mRadius - getBottomHeightGap();
        float right = left + 2 * mRadius;
        float bottom = top + 2 * mRadius;
        mArcRectF.set(left, top, right, bottom);

        PointF offsetPoint = calcArcEndPointXY(mArcRectF.centerX(), mArcRectF.centerY(), mArcRectF.width() / 2, 0);
        offsetX = offsetPoint.x - left;
        offsetY = mArcRectF.centerY() - offsetPoint.y;

        mArcRectF.top += offsetY;
        mArcRectF.bottom += offsetY;

        mPaint.setPathEffect(mDashPathEffect);
        canvas.drawArc(mArcRectF, 180, 180, false, mPaint);

        int angle = 0;
        try {
            long start = mDateFormat.parse(mSunriseTime).getTime();
            long end = mDateFormat.parse(mSunsetTime).getTime();

            long current = mDateFormat.parse(mCurrentTime).getTime();
            LogUtils.i("", "current : " + current + ",start :" + start + ",end :" + end);
            if (current < start) {
                return;
            }
            float factor = 1.0f * (current - start) / (end - start);
            if (factor > 1) {
                angle = 180;
            } else {
                angle = (int) (factor * 180);
            }
        } catch (ParseException e) {
            LogUtils.e("", "error : " + e.toString());
            e.printStackTrace();
        }

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mArcSolidColor);
        canvas.drawArc(mArcRectF, 180, angle, false, mPaint);

        PointF point = calcArcEndPointXY(mArcRectF.centerX(), mArcRectF.centerY(), mArcRectF.width() / 2, angle);

        //因为计算损失精度,所以这里用1像素来微调
        Path path = new Path();
        path.moveTo(mArcRectF.left - 1 + offsetX, mArcRectF.centerY() - offsetY);// 此点为多边形的起点
        path.lineTo(point.x - 1, point.y - 1);
        path.lineTo(point.x - 1, mArcRectF.centerY() - offsetY);
        path.close(); // 使这些点构成封闭的多边形
        canvas.drawPath(path, mPaint);

        mPaint.setColor(mSunColor);

        mPaint.setStyle(Paint.Style.FILL);

        canvas.drawCircle(point.x, point.y, mSunSize / 2, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mSunSize / 3);


        float c = (float) (2 * mSunSize * Math.PI);

        int w = 3;
        float gapW = (c - 12 * 5) / 12;

        DashPathEffect effect = new DashPathEffect(new float[]{w, gapW, w, gapW}, 0);
        mPaint.setPathEffect(effect);

        canvas.drawCircle(point.x, point.y, mSunSize, mPaint);

        mPaint.setColor(mTimeTextColor);
        mPaint.setTextSize(mTextSize);

        int startTextWidth = getTextWidth(mPaint, mSunriseTime);
        int endTextWidth = getTextWidth(mPaint, mSunsetTime);

        int textHeight = getTextHeight();

        mPaint.setPathEffect(null);
        mPaint.setStyle(Paint.Style.FILL);

        canvas.drawText(mSunriseTime, mArcRectF.left - startTextWidth / 2 + offsetX,
                mArcRectF.centerY() - offsetY + textHeight, mPaint);
        canvas.drawText(mSunsetTime, mArcRectF.right - endTextWidth / 2 - 2 - offsetX * 2,
                mArcRectF.centerY() - offsetY + textHeight, mPaint);
    }

    /**
     * 绘制天气图标
     *
     * @param canvas
     * @param point
     */
    private void drawWeatherDrawable(Canvas canvas, PointF point) {
        drawSun(canvas, point);
    }

    /**
     * 画太阳
     *
     * @param canvas
     * @param point
     */
    private void drawSun(Canvas canvas, PointF point) {
        mPaint.setColor(mSunColor);

        mPaint.setStyle(Paint.Style.FILL);

        canvas.drawCircle(point.x, point.y, mSunSize / 2, mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mSunSize / 3);


        float c = (float) (2 * mSunSize * Math.PI);

        int w = 3;
        float gapW = (c - 12 * 5) / 12;

        DashPathEffect effect = new DashPathEffect(new float[]{w, gapW, w, gapW}, 0);
        mPaint.setPathEffect(effect);

        canvas.drawCircle(point.x, point.y, mSunSize, mPaint);
    }

    private int getTextHeight() {
        mPaint.setTextSize(mTextSize);
        Paint.FontMetrics fm = mPaint.getFontMetrics();// 得到系统默认字体属性
        return (int) Math.ceil(fm.descent - fm.ascent);
    }

    /**
     * 宽度除了圆弧以外的空隙
     *
     * @return
     */
    private int getWidthGap() {
        return getPaddingLeft() + getPaddingRight() + getTextWidth(mSunriseTime) / 2 + getTextWidth(mSunsetTime) / 2;
    }

    /**
     * 高度除了圆弧以外的空隙
     *
     * @return
     */
    private int getHeightGap() {
        return (int) (getPaddingTop() + getPaddingBottom() + mBottomLineHeight / 2) + getTextHeight();
    }

    /**
     * 圆弧底部空隙
     *
     * @return
     */
    private int getBottomHeightGap() {
        return (int) (getPaddingBottom() + getTextHeight());
    }

    //依圆心坐标，半径，扇形角度，计算出扇形终射线与圆弧交叉点的xy坐标
    public PointF calcArcEndPointXY(float cirX, float cirY, float radius, float angle) {

        PointF point = new PointF();

        //将角度转换为弧度
        float arcAngle = (float) (Math.PI * angle / 180.0);

        if (angle < 90)     //直角的三角形斜边是半径
        {
            point.x = cirX - (float) (Math.cos(arcAngle)) * radius;
            point.y = cirY - (float) (Math.sin(arcAngle)) * radius;
        } else if (angle == 90) {
            point.x = cirX;
            point.y = cirY - radius;
        } else if (angle > 90 && angle < 180) {
            arcAngle = (float) (Math.PI * (180 - angle) / 180.0);
            point.x = cirX + (float) (Math.cos(arcAngle)) * radius;
            point.y = cirY - (float) (Math.sin(arcAngle)) * radius;
        } else {
            point.x = cirX + radius;
            point.y = cirY;
        }

        return point;
    }

    public int getTextWidth(Paint paint, String str) {
        int iRet = 0;
        if (str != null && str.length() > 0) {
            int len = str.length();
            float[] widths = new float[len];
            paint.getTextWidths(str, widths);
            for (int j = 0; j < len; j++) {
                iRet += (int) Math.ceil(widths[j]);
            }
        }
        return iRet;
    }

    public int getTextWidth(String str) {
        mPaint.setTextSize(mTextSize);
        return getTextWidth(mPaint, str);
    }
}
