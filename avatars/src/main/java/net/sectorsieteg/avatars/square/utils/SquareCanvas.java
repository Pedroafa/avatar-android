package net.sectorsieteg.avatars.square.utils;

/*
 * Copyright 2014 Pedro Álvarez Fernández <pedroafa@gmail.com>
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
import android.graphics.Bitmap;
import android.graphics.Canvas;

import net.sectorsieteg.avatars.AvatarBorder;

public class SquareCanvas {

    private final SquareUtils mSquareUtils;
    private final AvatarBorder mAvatarBorder;
    private final Canvas mCanvas;

    public SquareCanvas(SquareUtils squareUtils, AvatarBorder avatarBorder, Canvas canvas) {
        mSquareUtils = squareUtils;
        mAvatarBorder = avatarBorder;
        mCanvas = canvas;

        mCanvas.drawColor(avatarBorder.getColor());
    }

    public void drawBitmap(Bitmap bitmap) {
        Bitmap scaledBitmap = mSquareUtils.createScaledBitmap(bitmap, mCanvas.getWidth(), mCanvas.getHeight());
        mCanvas.drawBitmap(scaledBitmap, 0f, 0f, null);
        scaledBitmap.recycle();
    }

    public void drawBitmapLeft(Bitmap bitmap) {
        Bitmap scaledBitmap = mSquareUtils.createScaledBitmap(bitmap, getNewWidth(), mCanvas.getHeight());
        mCanvas.drawBitmap(scaledBitmap, 0f, 0f, null);
        scaledBitmap.recycle();
    }

    public void drawBitmapLeftTop(Bitmap bitmap) {
        Bitmap scaledBitmap = mSquareUtils.createScaledBitmap(bitmap, getNewWidth(), getNewHeight());
        mCanvas.drawBitmap(scaledBitmap, 0f, 0f, null);
        scaledBitmap.recycle();
    }

    public void drawBitmapLeftBottom(Bitmap bitmap) {
        Bitmap scaledBitmap = mSquareUtils.createScaledBitmap(bitmap, getNewWidth(), getNewHeight());
        mCanvas.drawBitmap(scaledBitmap, 0f, getBottomPosition(), null);
        scaledBitmap.recycle();
    }

    public void drawBitmapRight(Bitmap bitmap) {
        Bitmap scaledBitmap = mSquareUtils.createScaledBitmap(bitmap, getNewWidth(), mCanvas.getHeight());
        mCanvas.drawBitmap(scaledBitmap, getRightPosition(), 0f, null);
        scaledBitmap.recycle();
    }

    public void drawBitmapRightTop(Bitmap bitmap) {
        Bitmap scaledBitmap = mSquareUtils.createScaledBitmap(bitmap, getNewWidth(), getNewHeight());
        mCanvas.drawBitmap(scaledBitmap, getRightPosition(), 0f, null);
        scaledBitmap.recycle();
    }

    public void drawBitmapRightBottom(Bitmap bitmap) {
        Bitmap scaledBitmap = mSquareUtils.createScaledBitmap(bitmap, getNewWidth(), getNewHeight());
        mCanvas.drawBitmap(scaledBitmap, getRightPosition(), getBottomPosition(), null);
        scaledBitmap.recycle();
    }

    private int getHalfBorderWidth() {
        return mAvatarBorder.getSquareWidth() / 2;
    }

    private int getNewWidth() {
        return (mCanvas.getWidth() / 2) - getHalfBorderWidth();
    }

    private int getNewHeight() {
        return (mCanvas.getHeight()  / 2) - getHalfBorderWidth();
    }

    private int getRightPosition() {
        return (mCanvas.getWidth() / 2) + mAvatarBorder.getSquareWidth();
    }

    private int getBottomPosition() {
        return (mCanvas.getHeight()  / 2) + mAvatarBorder.getSquareWidth();
    }
}