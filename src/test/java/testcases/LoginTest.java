package testcases;

import base.BaseTest;
import pages.LoginPage;
import utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Auth Feature")
public class LoginTest extends BaseTest {


    @Story("Login and Email and Password")
    @Test(description = "Test the Login functionality using email and password")
    @Description("It will filling the email, password and navigate to Todo Page")
    public void LoginToApp(){
        LoginPage loginPage= new LoginPage(getDriver());
        String email = ConfigUtils.getInstance().getEmail();
        String password = ConfigUtils.getInstance().getPassword();
        boolean welcome =
                loginPage
                .loadURL()
                .Login(email,password)
                .isWelcomeMessageDisplayed();

        Assert.assertTrue(welcome);
    }
}
