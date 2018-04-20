package org.opi.page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ResultsPage extends BasePage{

    @FindBy(css = "[class='product-container'] [class='product-name']")
    private WebElement productLabel;

    public boolean isProductLabelDisplayed() {
        return productLabel.isDisplayed();
    }
    public String getProductLabelText(){
        return productLabel.getText();
    }

    public ResultsPage assertThatProductWithNameIsDisplayed(String productName){

        assertTrue(productLabel.isDisplayed());
        assertEquals(productLabel.getText(),productName);
        return this;
    }
}
