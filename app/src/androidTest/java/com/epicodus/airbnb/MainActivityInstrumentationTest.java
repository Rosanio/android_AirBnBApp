package com.epicodus.airbnb;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

/**
 * Created by Guest on 4/21/16.
 */
public class MainActivityInstrumentationTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void validateEditText() {

    }
}
