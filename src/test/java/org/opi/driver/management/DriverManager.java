package org.opi.driver.management;

import org.openqa.selenium.WebDriver;
import org.opi.driver.management.utils.DriverFactory;

public class DriverManager {


    private static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

    public DriverManager() {
    }

    public synchronized static WebDriver createWebDriver(String driverToRun) {
        DriverFactory driverFactory = new DriverFactory();
        WebDriver webDriver = driverFactory.getRemoteDriver("CHROME");
        threadLocal.set(webDriver);
        return threadLocal.get();
    }

    public synchronized static WebDriver getDriver() {
        if (threadLocal.get() == null) {
            throw new IllegalStateException("Please run createWebDriver before calling getDriver");
        }
        return threadLocal.get();
    }

    public synchronized static void disposeDriver() {
        threadLocal.get().quit();
        threadLocal.remove();
    }

}
