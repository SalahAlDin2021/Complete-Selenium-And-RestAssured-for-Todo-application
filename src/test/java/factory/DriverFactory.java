package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {

   private WebDriver driver;

   public WebDriver initializeDriver(){

       String browser = System.getProperty("browser" , "Chrome");

       switch (browser){
           case "Chrome":
               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
               break;
           case "Firefox":
               WebDriverManager.firefoxdriver().setup();
               driver = new FirefoxDriver();
               break;
           case "Edge":
               WebDriverManager.edgedriver().setup();
               driver= new EdgeDriver();
           default:
               throw new RuntimeException("browser is not supported ");
       }
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       driver.manage().window().maximize();
       return driver;
   }

}
