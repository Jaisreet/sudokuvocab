/*
 * Copyright 2015, The Android Open Source Project
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

package com.example.sudokuapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import androidx.test.filters.SdkSuppress;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Basic sample for unbundled UiAutomator.
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class MainActivityTest {

    private static final String SUDOKU
            = "com.example.sudokuapp";

    private static final int LAUNCH_TIMEOUT = 5000;

    private static final String STRING_TO_BE_TYPED = "UiAutomator";

    private UiDevice mDevice;

    @Before
    public void startMainActivityFromHomeScreen() throws UiObjectNotFoundException {
        // Initialize UiDevice instance
        mDevice = UiDevice.getInstance(getInstrumentation());

        // Start from the home screen
        mDevice.pressHome();

        // Wait for launcher
        final String launcherPackage = getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        mDevice.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), LAUNCH_TIMEOUT);

        // Launch the blueprint app
        Context context = getApplicationContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(SUDOKU);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);    // Clear out any previous instances
        context.startActivity(intent);

        // Wait for the app to appear
        mDevice.wait(Until.hasObject(By.pkg(SUDOKU).depth(0)), LAUNCH_TIMEOUT);

        UiObject newGame = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/button12")
        );
        newGame.click();
    }

    /**
     * Uses package manager to find the package name of the device launcher. Usually this package
     * is "com.android.launcher" but can be different at times. This is a generic solution which
     * works on all platforms.`
     */
    private String getLauncherPackageName() {
        // Create launcher Intent
        final Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);

        // Use PackageManager to get the launcher package name
        PackageManager pm = getApplicationContext().getPackageManager();
        ResolveInfo resolveInfo = pm.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return resolveInfo.activityInfo.packageName;
    }

    public void testOnNewIntent() {
    }

    public void testOnPause() {
    }

    public void testOnClickReset() {
    }

    public void testOnResume() {
    }

    public void testTimerOff() {
    }

    public void testTimerStatus() {
    }

    public void testBackToMain() {
    }

    public void testBTNOnePress() {
    }

    public void testBTNTwoPress() {
    }

    public void testBTNThreePress() {
    }

    public void testBTNFourPress() {
    }

    public void testBTNFivePress() {
    }

    public void testBTNSixPress() {
    }

    public void testBTNSevenPress() {
    }

    public void testBTNEightPress() {
    }

    public void testBTNNinePress() {
    }

    public void testEraseText() {
    }

    public void testReset() {
    }

    public void testCheck() {
    }

    public void testOpenDialog() {
    }

    public void testOpenSettingDialog() {
    }

    public void testStartNewGame() {
    }

    @Test
    public void testSettingPage() {

        UiObject settings = mDevice.findObject(new UiSelector()
                .text("settings")
                .className("android.widget.Button"));

        // Simulate a user-click on the OK button, if found.
        try {
            if(settings.exists() && settings.isEnabled()) {
                settings.click();
            }
        } catch (UiObjectNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testQuit() throws UiObjectNotFoundException {
        UiObject quit = mDevice.findObject(new UiSelector()
                .text("quitGame")
                .className("android.widget.Button"));

        // Simulate a user-click on the OK button, if found.

        if(quit.exists() && quit.isEnabled()) {
            quit.click();
            // Wait for the hint dialog to appear
            mDevice.wait(Until.hasObject(By.text("Quit Game")), 5000);

            // Check that the hint dialog title is correct
            UiObject hintDialogTitle = mDevice.findObject(new UiSelector().text("Hint Dialog"));
            assertTrue(hintDialogTitle.exists());
        }
    }



    @Test
    public void testHint() throws UiObjectNotFoundException {

        UiObject hint = mDevice.findObject(new UiSelector()
                .text("hint")
                .className("android.widget.Button"));

        // Simulate a user-click on the OK button, if found.

        if(hint.exists() && hint.isEnabled()) {
            hint.click();
            // Wait for the hint dialog to appear
            mDevice.wait(Until.hasObject(By.text("Hint Dialog")), 5000);

            // Check that the hint dialog title is correct
            UiObject hintDialogTitle = mDevice.findObject(new UiSelector().text("Hint Dialog"));
            assertTrue(hintDialogTitle.exists());
        }
    }

}
