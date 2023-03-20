package com.example.sudokuapp;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.content.Intent;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.SdkSuppress;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import org.junit.Before;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)

public class MainActivityTest {
    private static final String SUDOKU
            = "Model.board_GamePlay";
    private static final int LAUNCH_TIMEOUT = 5000;
    private static final String STRING_TO_BE_TYPED = "UiAutomator";
    private UiDevice device;

    @Before
    public void startMainActivityFromHomeScreen() {
        // Initialize UiDevice instance
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        // Start from the home screen
        device.pressHome();

        // Wait for launcher
        final String launcherPackage = device.getLauncherPackageName();
        assertThat(launcherPackage, notNullValue());
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)),
                LAUNCH_TIMEOUT);

        // Launch the app
        Context context = ApplicationProvider.getApplicationContext();
        final Intent intent = context.getPackageManager()
                .getLaunchIntentForPackage(SUDOKU);
        // Clear out any previous instances
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);

        // Wait for the app to appear
        device.wait(Until.hasObject(By.pkg(SUDOKU).depth(0)),
                LAUNCH_TIMEOUT);
    }


    public void hint() throws UiObjectNotFoundException {


        UiObject hintButton = device.findObject(new UiSelector()
                .text("Hint")
                .className("android.widget.Button"));
       /**  UiObject okButton = device.findObject(new UiSelector()
                .text("OK")
                .className("android.widget.Button")); */

// Simulate a user-click on the OK button, if found.
        if(hintButton.exists() && hintButton.isEnabled()) {
            hintButton.click();
        }

        device.findObject(new UiSelector()
                .packageName(SUDOKU).resourceId("hint")).click();

        // Verify the result = 5
        //UiObject result = device.findObject(By.res(SUDOKU ));
       // assertEquals("5", result.getText());
    }

}
