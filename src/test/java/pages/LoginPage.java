package pages;

import base.BasePage;
import utils.ConfigUtils;
import utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Properties;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@data-testid='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@data-testid='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@data-testid='submit']")
    private WebElement submit;

    @Step
    public TodoPage Login(String email ,String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submit.click();
        return new TodoPage(driver);
    }
    @Step
    public LoginPage loadURL(){
        String url = ConfigUtils.getInstance().getBaseUrl();
        driver.get(url);
        return this;
    }

}
