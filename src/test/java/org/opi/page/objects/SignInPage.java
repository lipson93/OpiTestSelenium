package org.opi.page.objects;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "passwd")
    private WebElement inputPassword;

    @FindBy(id = "SubmitLogin")
    private WebElement buttonSubmitLogin;

    @FindBy(css = "[class='alert alert-danger' ] li")
    private WebElement warningLabel;

    private Logger logger = LogManager.getLogger(SignInPage.class);

    public SignInPage setLogin(String text){
        inputEmail.clear();
        inputEmail.sendKeys(text);
        return new SignInPage();
    }

    public SignInPage setPassword(String text){
        inputPassword.clear();
        inputPassword.sendKeys(text);

        return new SignInPage();
    }

    public SignInPage submitAndSave(){
        buttonSubmitLogin.click();
        return this;
    }

    public String getFailedLogin(){
        return warningLabel.getText();
    }
}
