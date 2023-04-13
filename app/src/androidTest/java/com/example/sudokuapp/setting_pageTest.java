package com.example.sudokuapp;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;
import androidx.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;

public class setting_pageTest {

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


        UiObject settings = mDevice.findObject(new UiSelector()
                .resourceId("com.example.sudokuapp:id/button13")
        );

        settings.click();

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
    public void save() throws UiObjectNotFoundException {
        UiObject save = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/save"));
        save.click();
    }

    @Test
    public void back() throws UiObjectNotFoundException {
        UiObject back = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/button14"));
        back.click();
    }

    @Test
    public void modes() throws UiObjectNotFoundException {
        UiObject en = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/english"));
        en.click();

        UiObject fre = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU+":id/French"));
        fre.click();
    }

    @Test
    public void levels() throws UiObjectNotFoundException {
        UiObject emode = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU + ":id/easyButton"));
        emode.click();
        UiObject mmode = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU + ":id/mediumButton"));
        mmode.click();
        UiObject hmode = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU + ":id/hardButton"));
        hmode.click();
    }

    @Test
    public void layout() throws UiObjectNotFoundException {
        UiObject four = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU + ":id/fourbyfour"));
        four.click();
        UiObject six = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU + ":id/sixbysix"));
        six.click();
        UiObject nine = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU + ":id/ninebynine"));
        nine.click();
        UiObject twelve = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU + ":id/twelvebytwelve"));
        twelve.click();
    }

    @Test
    public void testRotation() throws UiObjectNotFoundException, RemoteException {

        UiDevice device = UiDevice.getInstance(getInstrumentation());
        device.setOrientationLeft();
        device.setOrientationNatural();
        device.setOrientationRight();

    }

    @Test
    public void listening() throws UiObjectNotFoundException {
        UiObject listening = mDevice.findObject(new UiSelector().
                resourceId(SUDOKU + ":id/checkBox"));
        listening.click();

    }

}