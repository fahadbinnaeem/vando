package com.vando.tpl.vando.Utilities;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.squareup.picasso.Transformation;

public class CircleTransform implements Transformation {

    private float relativeFactor = 0.1f;

    @Override
    public Bitmap transform(Bitmap source) {
        int size = Math.min(source.getWidth(), source.getHeight());

        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;

        Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
        if (squaredBitmap != source) {
            source.recycle();
        }

        Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        BitmapShader shader = new BitmapShader(squaredBitmap,
                BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setAntiAlias(true);

        Paint ringBorderPaint = new Paint();
        ringBorderPaint.setARGB(220,180,150,120);
        ringBorderPaint.setStyle(Paint.Style.STROKE);
        ringBorderPaint.setStrokeWidth(20);
        ringBorderPaint.setAntiAlias(true);

        float r = size / 2f;
        canvas.drawCircle(r, r, r*0.9f, paint);
        canvas.drawCircle(r, r, r*0.9f, ringBorderPaint);


        squaredBitmap.recycle();

        Bitmap BigBaseBitmap = Bitmap.createBitmap(size, size,source.getConfig());
        RectF centerRect = new RectF(BigBaseBitmap.getWidth()/2-BigBaseBitmap.getWidth()*relativeFactor,
                BigBaseBitmap.getHeight()/2-BigBaseBitmap.getWidth()*relativeFactor,
                BigBaseBitmap.getWidth()/2+BigBaseBitmap.getWidth()*relativeFactor,
                BigBaseBitmap.getHeight()/2+BigBaseBitmap.getWidth()*relativeFactor);
        Canvas newCanvas = new Canvas(BigBaseBitmap);
        newCanvas.drawBitmap(bitmap,null,centerRect,null);
        return bitmap;
    }

    @Override
    public String key() {
        return "circle";
    }
}