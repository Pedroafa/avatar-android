Avatars for Android
==============

This project provides a easy way to build avatar compositions for Android applications, as you can see in the screenshot.

![Screenshot](https://github.com/Pedroafa/avatar-android/blob/master/screenshot.png?raw=true)

## How to Use

Inside the layout, you only needs a ImageView in order to show the avatar.

``` xml
    <ImageView
        android:id="@+id/avatar"
        android:layout_height="fill_parent"
        android:layout_width="fill_parent"/>
```

The AvatarDrawableFactory will abstract you about how the avatars are built. We will be able to create a rounded or a
squared avatar from this entry point.

For the squared avatars depending of the number of images passed to the factory, a composition for one, two, three or four
will be created. Returning the specific implementation for that case.

There are this types of compositions:

* RoundedAvatarDrawable
* BorderedRoundedAvatarDrawable
* SquaredAvatarDrawable
* DoubleSquaredAvatarDrawable
* TripleSquaredAvatarDrawable
* QuadrupleSquaredAvatarDrawable

``` java
BitmapFactory.Options options = new BitmapFactory.Options();
options.inMutable = false;
Bitmap avatar = BitmapFactory.decodeResource(getResources(), R.drawable.avatar, options);

AvatarDrawableFactory avatarFactory = new AvatarDrawableFactory(getResources());

Drawable avatarDrawable = avatarFactory.getSquaredAvatarDrawable(avatar, avatar);
ImageView avatarView = (ImageView)rootView.findViewById(R.id.avatar);
avatarView.setImageDrawable(avatarDrawable);
```

## Contributors

* Evelio Tarazona Cáceres - <https://gist.github.com/eveliotc/6051367>

## License

    Copyright 2014 Pedro Álvarez Fernández

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
