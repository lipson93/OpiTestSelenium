package org.opi.tests;

import org.opi.driver.management.utils.DriverUtils;
import org.opi.page.objects.SignInPage;
import org.testng.annotations.Test;

import static org.opi.utils.EnvironmentsUrls.LOGIN_URL;
import static org.testng.Assert.assertEquals;

public class LoginFailedTest extends TestBase {

    String login = "Login@email.com";
    String password = "Password";

    @Test
    public void asUserTrytoLoginWithBadCredentials() {
        DriverUtils.navigateTo(LOGIN_URL);

        SignInPage signInPage = new SignInPage();
        String failedLogin = signInPage
                .setLogin(login)
                .setPassword(password)
                .submitAndSave()
                .getFailedLogin();


        assertEquals(failedLogin, "Authentication failed.");
    }

    @Test
    public void asUserTrytoLoginSearchText(){
        DriverUtils.navigateTo(LOGIN_URL);



    }
}
