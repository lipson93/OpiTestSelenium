package org.opi.driver.management.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    public static final String USERNAME = "marek209";
    public static final String AUTOMATE_KEY = "g39iUqC9mpoxfNqs4Gyw";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public WebDriver getRemoteDriver(String browserValue) {
        WebDriver driver = null;
        DesiredCapabilities caps = new DesiredCapabilities();
        switch (browserValue) {
            case "EDGE":
                caps.setCapability("browser", "Firefox");
                caps.setCapability("browser_version", "60.0 beta");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "10");
                caps.setCapability("resolution", "2048x1536");

                break;
            case "CHROME":
                caps.setCapability("browser", "Chrome");
                caps.setCapability("browser_version", "49.0");
                caps.setCapability("os", "Windows");
                caps.setCapability("os_version", "XP");
                caps.setCapability("resolution", "1920x1080");

                try {
                    driver = new RemoteWebDriver(new URL(URL), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
        }
        return driver;
    }
}
