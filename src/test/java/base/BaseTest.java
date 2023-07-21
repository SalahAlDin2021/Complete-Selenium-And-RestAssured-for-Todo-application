package base;

import factory.DriverFactory;
import utils.CookieUtils;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class BaseTest {


    protected ThreadLocal<WebDriver>  driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }
    public WebDriver getDriver(){
        return this.driver.get();
    }

    @BeforeMethod
    public void setup(){

        WebDriver driver =new DriverFactory().initializeDriver();
        setDriver(driver);
    }

    @AfterMethod
    public void teardown(@NotNull ITestResult result){
      String testCaseName= result.getMethod().getMethodName();
      File destinationFile = new File("target" + File.separator+"screenshots" + File.separator +testCaseName+".png");
      takeScreenShot(destinationFile);
      getDriver().quit();
    }

    @Step
    public void injectCookiesToTheBrowser(List<Cookie> restAssuredCookie){

        List<org.openqa.selenium.Cookie> seleniumCookie =
                CookieUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookie);

        for(org.openqa.selenium.Cookie cookie : seleniumCookie){
            getDriver().manage().addCookie(cookie);
        }
    }


    public void takeScreenShot(File destinationFile){
        File file = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(file ,destinationFile);
            InputStream inputStream = new FileInputStream(destinationFile);
            Allure.addAttachment("screenshots" ,inputStream);
        }catch (IOException e){
         throw new RuntimeException(e);
        }
    }

}
