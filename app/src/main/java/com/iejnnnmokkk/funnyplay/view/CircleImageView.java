package com.iejnnnmokkk.funnyplay.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.iejnnnmokkk.funnyplay.R;

/**
 * @author Sun
 * @Demo class CircleImageView
 * @Description TODO
 * @date 2024/12/12 17:18
 */
public class CircleImageView extends ImageView {

    private Paint paint;
    private RectF rectF;
    private float topLeftRadius = 20f;
    private float topRightRadius = 20f;
    private float bottomLeftRadius = 0f;
    private float bottomRightRadius = 0f;

    public CircleImageView(Context context) {
        super(context);
        init(null);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CircleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        if (attrs != null) {
            // 获取自定义属性
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.RoundedCornerImageView);
            topLeftRadius = a.getDimension(R.styleable.RoundedCornerImageView_topLeftRadius, 20f);
            topRightRadius = a.getDimension(R.styleable.RoundedCornerImageView_topRightRadius, 20f);
            bottomLeftRadius = a.getDimension(R.styleable.RoundedCornerImageView_bottomLeftRadius, 0f);
            bottomRightRadius = a.getDimension(R.styleable.RoundedCornerImageView_bottomRightRadius, 0f);

            // 如果设置了"allCornersRadius"，则将其应用到所有四个角
            float allCornersRadius = a.getDimension(R.styleable.RoundedCornerImageView_allCornersRadius, -1);
            if (allCornersRadius != -1) {
                setAllCornersRadius(allCornersRadius);
            }

            a.recycle();
        }

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.WHITE);  // 设置颜色，可以修改为其他颜色
        paint.setStyle(Paint.Style.FILL);
        rectF = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 获取视图的宽度和高度
        int width = getWidth();
        int height = getHeight();

        // 创建Path来绘制带圆角的矩形
        Path path = new Path();
        rectF.set(0, 0, width, height);

        // 绘制四个圆角
        path.addRoundRect(new RectF(0, 0, width, height),
                new float[]{
                        topLeftRadius, topLeftRadius, // 左上角圆角
                        topRightRadius, topRightRadius, // 右上角圆角
                        bottomLeftRadius, bottomLeftRadius, // 左下角圆角
                        bottomRightRadius, bottomRightRadius}, Path.Direction.CW);

        // 绘制路径
        canvas.drawPath(path, paint);

        // 如果有图片则绘制图片
        if (getDrawable() != null) {
            getDrawable().setBounds(0, 0, width, height);
            getDrawable().draw(canvas);
        }
    }

    /**
     * 设置所有四个角的圆角半径
     */
    public void setAllCornersRadius(float radius) {
        topLeftRadius = radius;
        topRightRadius = radius;
        bottomLeftRadius = radius;
        bottomRightRadius = radius;
        invalidate(); // 重绘视图
    }

    // 下面的 getter 和 setter 方法用于手动修改单独的角的圆角值
    public void setTopLeftRadius(float topLeftRadius) {
        this.topLeftRadius = topLeftRadius;
        invalidate(); // 重绘视图
    }

    public void setTopRightRadius(float topRightRadius) {
        this.topRightRadius = topRightRadius;
        invalidate(); // 重绘视图
    }

    public void setBottomLeftRadius(float bottomLeftRadius) {
        this.bottomLeftRadius = bottomLeftRadius;
        invalidate(); // 重绘视图
    }

    public void setBottomRightRadius(float bottomRightRadius) {
        this.bottomRightRadius = bottomRightRadius;
        invalidate(); // 重绘视图
    }
}



