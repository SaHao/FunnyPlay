package com.iejnnnmokkk.funnyplay.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * @author Sun
 * @Demo class CircleCircleWaveProgressView
 * @Description TODO
 * @date 2024/12/12 14:47
 */
public class CircleWaveProgressView extends View {

    private Paint circlePaint, wavePaint, textPaint;
    private int circleColor = Color.GRAY;
    private int waveColor = Color.BLUE;
    private int textColor = Color.WHITE;
    private float textSize = 50f;
    private int progress = 0;
    private float borderWidth = 3f;

    private float waveOffset = 0f; // 波纹偏移
    private ValueAnimator waveAnimator; // 平滑动画

    // 常量，控制波纹的直径
    private static final float WAVE_DIAMETER_OFFSET = 10f; // 波纹直径的偏移量，可以根据需要调整

    public CircleWaveProgressView(Context context) {
        super(context);
        init();
    }

    public CircleWaveProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(10);

        wavePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        wavePaint.setStyle(Paint.Style.FILL);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setTextAlign(Paint.Align.CENTER);

        // 初始化波纹动画
        initWaveAnimator();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 2;

        // 计算圆心坐标
        float centerX = width / 2f;
        float centerY = height / 2f;

        // 计算内圆的半径，减去边框宽度
        float innerRadius = radius - borderWidth / 2f;

        // 绘制圆形边框
        circlePaint.setStyle(Paint.Style.STROKE);
        circlePaint.setStrokeWidth(borderWidth);
        circlePaint.setColor(circleColor);
        canvas.drawCircle(centerX, centerY, innerRadius, circlePaint);

        // 创建圆形路径，裁剪区域为内圆
        Path circlePath = new Path();
        circlePath.addCircle(centerX, centerY, innerRadius, Path.Direction.CW);
        canvas.save(); // 保存当前画布状态
        canvas.clipPath(circlePath); // 裁剪画布为圆形

        // 绘制波纹
        wavePaint.setColor(waveColor);
        Path wavePath = new Path();

        // 计算波纹的内圆半径，使用常量 WAVE_DIAMETER_OFFSET 来控制波纹的直径
        float waveRadius = innerRadius - WAVE_DIAMETER_OFFSET; // 控制波纹的直径，减去偏移量
        float waveHeight = height * (100 - progress) / 100f; // 根据进度计算波纹高度
        wavePath.moveTo(0, waveHeight);

        // 计算波纹的路径，生成流畅的波纹曲线
        for (int x = 0; x <= width; x++) {
            float y = (float) (10 * Math.sin((x + waveOffset) * Math.PI / 180) + waveHeight);
            wavePath.lineTo(x, y);
        }

        wavePath.lineTo(width, height);
        wavePath.lineTo(0, height);
        wavePath.close();
        canvas.drawPath(wavePath, wavePaint);

        canvas.restore(); // 恢复画布状态

        // 绘制文本
        textPaint.setColor(textColor);
        textPaint.setTextSize(textSize);
        textPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(progress + "%", centerX, centerY + textSize / 3f, textPaint);
    }

    // 设置圆形边框颜色
    public CircleWaveProgressView setCircleColor(int color) {
        this.circleColor = color;
        invalidate();
        return this;
    }

    // 设置波纹颜色
    public CircleWaveProgressView setWaveColor(int color) {
        this.waveColor = color;
        invalidate();
        return this;
    }

    // 设置文本大小
    public CircleWaveProgressView setTextSize(float size) {
        this.textSize = size;
        invalidate();
        return this;
    }

    // 设置文本颜色
    public CircleWaveProgressView setTextColor(int color) {
        this.textColor = color;
        invalidate();
        return this;
    }

    // 设置进度值
    public CircleWaveProgressView setProgress(int progress) {
        this.progress = Math.min(100, Math.max(0, progress));
        invalidate();
        return this;
    }

    // 启动波纹动画
    public void startAnimation() {
        // 启动平滑波纹动画
        if (waveAnimator != null && !waveAnimator.isRunning()) {
            waveAnimator.start();
        }
    }

    // 停止波纹动画
    public void stopAnimation() {
        // 停止波纹动画
        if (waveAnimator != null && waveAnimator.isRunning()) {
            waveAnimator.cancel();
        }
    }

    // 初始化波纹动画
    private void initWaveAnimator() {
        // 创建平滑波纹动画，使用 ValueAnimator 让波纹偏移更加丝滑
        waveAnimator = ValueAnimator.ofFloat(0f, 360f);
        waveAnimator.setDuration(2500); // 动画时长2.5秒
        waveAnimator.setRepeatCount(ValueAnimator.INFINITE); // 无限循环
        waveAnimator.setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator()); // 加速和减速插值器，确保平滑过渡
        waveAnimator.addUpdateListener(animation -> {
            waveOffset = (float) animation.getAnimatedValue(); // 更新波纹偏移量
            invalidate();
        });
    }
}


