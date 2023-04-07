package com.example.sudokuapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import androidx.test.filters.SdkSuppress;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

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

        UiObject startGame = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/startGame")
        );
        startGame.click();
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



    @Test
    public void testBTNOnePress() throws UiObjectNotFoundException {
        UiObject button = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/button"));
        button.click();
    }

    @Test
    public void testBTNTwoPress() throws UiObjectNotFoundException {
        UiObject button = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/button2"));
        button.click();
    }

    @Test
    public void testBTNThreePress() throws UiObjectNotFoundException {
        UiObject button = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/button3"));
        button.click();
    }

    @Test
    public void testBTNFourPress() throws UiObjectNotFoundException {
        UiObject button = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/button4"));
        button.click();
    }

    @Test
    public void testBTNFivePress() throws UiObjectNotFoundException {
        UiObject button = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/button5"));
        button.click();
    }

    @Test
    public void testBTNSixPress() throws UiObjectNotFoundException {
        UiObject button = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/button6"));
        button.click();
    }

    @Test
    public void testBTNSevenPress() throws UiObjectNotFoundException {
        UiObject button = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/button7"));
        button.click();
    }

    @Test
    public void testBTNEightPress() throws UiObjectNotFoundException {
        UiObject button = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/button8"));
        button.click();
    }

    @Test
    public void testBTNNinePress() throws UiObjectNotFoundException {
        UiObject button = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/button9"));
        button.click();
    }

    @Test
    public void testEraseText() throws UiObjectNotFoundException {
        UiObject erase = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/erase"));
        erase.click();
    }

    @Test
    public void testReset() throws UiObjectNotFoundException {
        UiObject reset = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/resetbtn"));
        reset.click();
    }

    @Test
    public void testCheck() throws UiObjectNotFoundException {
        UiObject check = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/checkBtn"));
        check.click();
    }

    @Test
    public void testOpenSettingDialog() throws UiObjectNotFoundException {
        UiObject dialog = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/settingsDialog"));
        dialog.click();
    }


    @Test
    public void testHint() throws UiObjectNotFoundException {

        UiObject dialog = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/hint"));
        dialog.click();
    }
}
