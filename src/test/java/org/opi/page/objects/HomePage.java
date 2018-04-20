package org.opi.page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "search_query_top")
    private WebElement searchQueryTextField;

    @FindBy(name = "submit_search")
    private WebElement searchButton;

    @FindBy(className = "login")
    private WebElement SignInButton;

    @Step("Typed into search query filed (0)")
    public HomePage TypeIntoSearchQueryTextField(String searchQuery) {
        searchQueryTextField.sendKeys(searchQuery);
        return this;
    }

    public ResultsPage clickOnSearchButton() {
        searchButton.click();
        return new ResultsPage();
    }

    public SignInPage signInClick(){
        SignInButton.click();
        return new SignInPage();
    }
}
