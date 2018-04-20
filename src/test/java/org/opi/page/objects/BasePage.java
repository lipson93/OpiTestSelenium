package org.opi.page.objects;

import org.openqa.selenium.support.PageFactory;
import org.opi.driver.management.DriverManager;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

}
