package net.sectorsieteg.avatars.square;

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
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;

import net.sectorsieteg.avatars.square.utils.SquareCanvas;
import net.sectorsieteg.avatars.square.utils.SquareCanvasProvider;

public class TripleSquaredAvatarDrawable extends Drawable {

    private final SquareCanvasProvider mSquareCanvasProvider;

    private final Bitmap mLeftBitmap;
    private final Bitmap mRightBitmapTop;
    private final Bitmap mRightBitmapBottom;

    public TripleSquaredAvatarDrawable(SquareCanvasProvider squareCanvasProvider, Bitmap leftBitmap, Bitmap rightBitmapTop,
                                       Bitmap rightBitmapBottom) {
        mSquareCanvasProvider = squareCanvasProvider;
        mLeftBitmap = leftBitmap;
        mRightBitmapTop = rightBitmapTop;
        mRightBitmapBottom = rightBitmapBottom;
    }

    @Override
    public void draw(Canvas canvas) {
        SquareCanvas squareCanvas = mSquareCanvasProvider.getSquareCanvas(canvas);

        squareCanvas.drawBitmapLeft(mLeftBitmap);
        squareCanvas.drawBitmapRightTop(mRightBitmapTop);
        squareCanvas.drawBitmapRightBottom(mRightBitmapBottom);
    }

    @Override
    public void setAlpha(int i) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
