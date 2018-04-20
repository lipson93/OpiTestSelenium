package org.opi.tests;

import org.opi.driver.management.DriverManager;
import org.opi.driver.management.utils.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static org.opi.utils.EnvironmentsUrls.MAIN_APP_URL;

public class TestBase {

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("CHROME") String browser){
        DriverManager.createWebDriver(browser);
        DriverManager.getDriver().manage().window().maximize();
        DriverUtils.navigateTo(MAIN_APP_URL);
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.disposeDriver();
    }
}
