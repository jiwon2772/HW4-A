package com.example.jayden.hw4_a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Jayden on 2016-06-03.
 */
public class Aircaps extends View {
    private Bitmap img1, img2;
    boolean[][] state;
    Point mPoint;
    private void init()
    {
        // 뾱뾱이 이미지를 받아온다.
        Resources res = getResources();
        img1 = BitmapFactory.decodeResource(res,R.drawable.aircap1);
        img2 = BitmapFactory.decodeResource(res,R.drawable.aircap2);
        //뾱뾱이 초기화
        state = new boolean[6][6];
        for(int i=0;i<6; i++)
            for(int j =0; j < 6; j++)
                state[i][j] = true;
        invalidate();
    }
    public Aircaps(Context c) {
        super(c);
        init();
    }
    public Aircaps(Context c, AttributeSet a) {
        super(c, a);
        init();
    }
    protected void onDraw(Canvas canvas)
    {
        Paint paint = new Paint();
        //뾱뾱이를 그린다.
        for(int i=0;i<6; i++) {
            for (int j = 0; j < 6; j++) {
                if (state[i][j] == true) //터지기 전 뾱뾱이
                    canvas.drawBitmap(img1, new Rect(0, 0, img1.getWidth(), img1.getHeight()), new Rect(150 * j, 150 * i, 150 * (j + 1), 150 * (i + 1)),paint);
                else  //터진 후 뾱뾱이
                    canvas.drawBitmap(img2, new Rect(0, 0, img2.getWidth(), img2.getHeight()), new Rect(150 * j, 150 * i, 150 * (j + 1), 150 * (i + 1)),paint);
            }
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int eventX = (int) event.getX();
        int eventY = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //이미지를 바꿔주기 위해 상태값을 바꿔줌
                state[eventY/150][eventX/150] = false;
                break;
        }
        invalidate();   //뾱뾱이 상태변화 갱신
        return true;
    }
}
