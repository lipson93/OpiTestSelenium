package org.opi.tests;

import org.openqa.selenium.WebDriver;
import org.opi.page.objects.HomePage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchTests extends TestBase {

    private String baseUrl = "http://google.pl";
    private static WebDriver driver;

    @DataProvider(name = "myLocalDataProvider")
    public Object[][] queriesTestData(){
        Object[][] testDataArray = {{"Faded Short Sleeve T-shirts"},{"Blouse"}};
        return testDataArray;
    }


    @Test(dataProvider = "myLocalDataProvider")
    public void queryforTshirt(String articleName) {
        HomePage homePage = new HomePage();
        homePage
                .TypeIntoSearchQueryTextField(articleName)
                .clickOnSearchButton()
                .assertThatProductWithNameIsDisplayed(articleName);
    }
}
