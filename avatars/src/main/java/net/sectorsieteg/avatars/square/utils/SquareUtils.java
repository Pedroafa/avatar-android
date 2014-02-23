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
import android.graphics.Rect;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;

public class SquareUtils {

    public Bitmap createScaledBitmap(Bitmap bitmap, int newWidth, int newHeight) {
        Rect bitmapRect = calculateBitmapRect(bitmap.getWidth(), bitmap.getHeight(), newWidth, newHeight);
        Rect scaledRect = new Rect(0, 0, newWidth, newHeight);

        Bitmap scaledBitmap = Bitmap.createBitmap(scaledRect.width(), scaledRect.height(), Config.ARGB_8888);
        Canvas canvas = new Canvas(scaledBitmap);
        canvas.drawBitmap(bitmap, bitmapRect, scaledRect, null);

        return scaledBitmap;
    }

    private Rect calculateBitmapRect(int bitmapWidth, int bitmapHeight, int newWidth, int newHeight) {
        float bitmapAspect = (float)bitmapWidth / (float)bitmapHeight;
        float newAspect = (float)newWidth / (float)newHeight;

        if (bitmapAspect > newAspect) {
            int rectWidth = (int)(bitmapHeight * newAspect);
            int rectLeft = (bitmapWidth - rectWidth) / 2;
            return new Rect(rectLeft, 0, rectLeft + rectWidth, bitmapHeight);
        } else {
            int rectHeight = (int)(bitmapWidth / newAspect);
            int rectTop = (bitmapHeight - rectHeight) / 2;
            return new Rect(0, rectTop, bitmapWidth, rectTop + rectHeight);
        }
    }
}

