package net.sectorsieteg.avatars.round;

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
import android.graphics.Paint;

import net.sectorsieteg.avatars.AvatarBorder;

/**
 * A Drawable that draws an oval with given {@link android.graphics.Bitmap} adding a border with a given
 * color and width
 */
public class BorderedRoundedAvatarDrawable extends RoundedAvatarDrawable {

    private final AvatarBorder mAvatarBorder;

    public BorderedRoundedAvatarDrawable(AvatarBorder avatarBorder, Bitmap bitmap) {
        super(bitmap);
        mAvatarBorder = avatarBorder;
    }

    @Override
    public void draw(Canvas canvas) {
        float borderWidth = mAvatarBorder.getRoundWidth();

        Paint paintBorder = new Paint();
        paintBorder.setAntiAlias(true);
        paintBorder.setColor(mAvatarBorder.getColor());
        paintBorder.setStyle(Paint.Style.STROKE);
        paintBorder.setStrokeWidth(borderWidth);

        int viewWidth = getIntrinsicWidth() - ((int)borderWidth * 2);
        int circleCenter = viewWidth / 2;

        canvas.drawCircle(circleCenter + borderWidth, circleCenter + borderWidth,
                circleCenter + borderWidth - 4.0f, paintBorder);
        canvas.drawCircle(circleCenter + borderWidth, circleCenter + borderWidth,
                circleCenter, getPaint());
    }
}
