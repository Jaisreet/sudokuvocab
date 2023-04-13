package com.example.sudokuapp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;

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
import androidx.test.uiautomator.UiDevice;

import org.junit.Test;

public class First_pageTest {
    private static final String SUDOKU
            = "com.example.sudokuapp";

    private static final int LAUNCH_TIMEOUT = 5000;

    private static final String STRING_TO_BE_TYPED = "UiAutomator";

    private UiDevice mDevice;

    @Before
    public void startMainActivityFromHomeScreen() {
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
    public void newGame() throws UiObjectNotFoundException {
        UiObject newGame = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/button12")
        );
        newGame.click();
    }

    @Test
    public void openNewGameDialogBox() throws UiObjectNotFoundException {
        UiObject newGame = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/button12")
        );
        newGame.click();

        UiObject startGame = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/startGame")
        );
        startGame.click();
    }

    @Test
    public void newGameDialogButtons() throws UiObjectNotFoundException {

        UiObject startGame = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/startGame")
        );

        UiObject Mode_english = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/english")
        );

        UiObject Mode_french = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/French")
        );

        UiObject difficulty_easy = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/easyButton")
        );

        UiObject difficulty_medium = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/mediumButton")
        );

        UiObject difficulty_hard = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/hardButton")
        );

        UiObject grid_9x9 = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/ninebynine")
        );

        UiObject grid_4x4 = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/fourbyfour")
        );

        UiObject grid_6x6 = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/sixbysix")
        );

        UiObject grid_12x12 = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/twelvebytwelve")
        );

        UiObject listening_mode = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/checkBox")
        );

        UiObject newGame = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/button12")
        );

        newGame.click();
        Mode_english.click();
        Mode_french.click();
        difficulty_easy.click();
        difficulty_medium.click();
        difficulty_hard.click();
        grid_9x9.click();
        grid_4x4.click();
        grid_6x6.click();
        grid_12x12.click();
        listening_mode.click();
        startGame.click();
    }

    @Test
    public void settingPage() throws UiObjectNotFoundException {
        UiObject Settings = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/textView2")
        );
        Settings.click();
    }

    @Test
    public void testRotation() throws UiObjectNotFoundException, RemoteException {

        UiDevice device = UiDevice.getInstance(getInstrumentation());
        device.setOrientationLeft();
        device.setOrientationNatural();
        device.setOrientationRight();

    }


}