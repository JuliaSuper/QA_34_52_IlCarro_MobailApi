package config;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.PropertiesReader.*;

public class AppiumConfig {
    public static AppiumDriver createAppiumDriver(){
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(getProperty("mobaile.properties", "platformName"))
                .setAutomationName(getProperty("mobaile.properties", "automationName"))
                .setDeviceName(getProperty("mobaile.properties","deviceName"))
                .setAppPackage(getProperty("mobaile.properties","appPackage"))
                .setAppActivity(getProperty("mobaile.properties","appActivity"));
        try {
            AppiumDriver appiumDriver = new AppiumDriver(new URL(getProperty("mobaile.properties",
                    "appiumUrl")),options);
            return appiumDriver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
