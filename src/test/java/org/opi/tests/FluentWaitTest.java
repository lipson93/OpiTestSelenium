package org.opi.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FluentWaitTest {


    protected WebDriver webDriver;

    @Test
    public void fluentWaitTest() {
        WebElement buttonAddText = webDriver.findElement(By.id("addText"));
        buttonAddText.click();

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.textToBe(By.id("dynamicElement"),"dynamicText0"));

        WebElement buttonDynamicTest = webDriver.findElement(By.id("dynamicElement"));
        assertTrue(buttonDynamicTest.isDisplayed());

    }
    @Test
    public void fluentWaitTest1() {
        WebElement buttonChangeColour = webDriver.findElement(By.id("dynamicColour"));
        buttonChangeColour.click();

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
        webDriverWait.until(ExpectedConditions.attributeToBe(By.id("dynamicColour"),"style","color: red;"));

        buttonChangeColour = webDriver.findElement(By.id("dynamicColour"));

        assertTrue(buttonChangeColour.getAttribute("style").contains("red;"));
    }

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.navigate().to("file:///C:/Selenium/SeleniumIntro/selenium-basic/exercies/Fluent_Wait_Page.html");
    }

    @AfterMethod
    public void tearDown() {
        webDriver.quit();
    }
}
