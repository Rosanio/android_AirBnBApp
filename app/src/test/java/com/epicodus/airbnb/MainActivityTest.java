package com.epicodus.airbnb;

import android.content.Intent;
import android.os.Build;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.RoboAttributeSet;
import org.robolectric.shadows.ShadowActivity;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Guest on 4/21/16.
 */

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void validateTextViewContent() {
        TextView appNameTextView = (TextView) activity.findViewById(R.id.custom_font);
        assertTrue("AirBnB".equals(appNameTextView.getText().toString()));
    }

    @Test
    public void secondActivityStarted() {
        activity.findViewById(R.id.fab).performClick();
        Intent expectedIntent = new Intent(activity, SearchActivity.class);
        ShadowActivity shadowActivity = org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }
}
