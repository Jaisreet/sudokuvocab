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
public class settingsDialogTest {

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
        UiObject settings1 = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/settingsDialog")
        );

        newGame.click();
        settings1.click();

    }

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
    public void testResume() throws UiObjectNotFoundException {

        UiObject dialog = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/resume"));
        dialog.click();
    }

    @Test
    public void testNewGame() throws UiObjectNotFoundException {

        UiObject dialog = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/newGameBtn"));
        dialog.click();
    }

    @Test
    public void testQuitGame() throws UiObjectNotFoundException {

        UiObject dialog = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/quitGame"));
        dialog.click();
    }

    @Test
    public void testSettingsPage() throws UiObjectNotFoundException {

        UiObject dialog = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/settingsPage"));
        dialog.click();
    }
}
