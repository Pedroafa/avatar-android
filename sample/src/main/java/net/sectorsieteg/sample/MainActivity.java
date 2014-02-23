package net.sectorsieteg.sample;

import android.app.ActionBar;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import net.sectorsieteg.avatars.AvatarDrawableFactory;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            AvatarDrawableFactory avatarDrawableFactory = new AvatarDrawableFactory(getResources());

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inMutable = false;

            Bitmap avatar = BitmapFactory.decodeResource(getResources(), R.drawable.avatar, options);

            Drawable roundedAvatarDrawable = avatarDrawableFactory.getRoundedAvatarDrawable(avatar);
            ImageView roundedAvatarView = (ImageView)rootView.findViewById(R.id.roundedAvatar);
            roundedAvatarView.setImageDrawable(roundedAvatarDrawable);

            Drawable borderedRoundedAvatarDrawable = avatarDrawableFactory.getBorderedRoundedAvatarDrawable(avatar);
            ImageView borderedRoundedAvatarView = (ImageView)rootView.findViewById(R.id.borderedRoundedAvatar);
            borderedRoundedAvatarView.setImageDrawable(borderedRoundedAvatarDrawable);

            Drawable squaredAvatarDrawable = avatarDrawableFactory.getSquaredAvatarDrawable(avatar);
            ImageView squaredAvatarView = (ImageView)rootView.findViewById(R.id.squaredAvatar);
            squaredAvatarView.setImageDrawable(squaredAvatarDrawable);

            Drawable doubleSquaredAvatarDrawable = avatarDrawableFactory.getSquaredAvatarDrawable(avatar, avatar);
            ImageView doubleSquaredAvatarView = (ImageView)rootView.findViewById(R.id.doubleSquaredAvatar);
            doubleSquaredAvatarView.setImageDrawable(doubleSquaredAvatarDrawable);

            Drawable tripleSquaredAvatarDrawable = avatarDrawableFactory
                    .getSquaredAvatarDrawable(avatar, avatar, avatar);
            ImageView tripleSquaredAvatarView = (ImageView)rootView.findViewById(R.id.tripleSquaredAvatar);
            tripleSquaredAvatarView.setImageDrawable(tripleSquaredAvatarDrawable);

            Drawable quadrupleSquaredAvatarDrawable = avatarDrawableFactory
                    .getSquaredAvatarDrawable(avatar, avatar, avatar, avatar);
            ImageView quadrupleSquaredAvatarView = (ImageView)rootView.findViewById(R.id.quadrupleSquaredAvatar);
            quadrupleSquaredAvatarView.setImageDrawable(quadrupleSquaredAvatarDrawable);

            return rootView;
        }
    }
}