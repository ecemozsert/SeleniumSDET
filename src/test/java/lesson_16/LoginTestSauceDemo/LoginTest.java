package lesson_16.LoginTestSauceDemo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTestDriver{

    @Test(priority = 1)
    public void validCredentialsLogin(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickSubmitButton();
    }
    @Test(priority = 2)
    public void InvalidCredentialsLogin(){
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("dummy");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickSubmitButton();
    }
}
