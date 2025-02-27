import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Collections;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


public class FlipkartLoginPage {
    WebDriver driver;
@BeforeClass
@Parameters("browser")
public void setup(String browser){
    if(browser.equalsIgnoreCase("edge")){
        WebDriverManager.edgedriver().setup();
        EdgeOptions options=new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new EdgeDriver(options);
    } else if (browser.equalsIgnoreCase("chrome")) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }
    else{
        throw new IllegalArgumentException("Browser not supported");
    }


}

@Test
    public void loginTest() throws InterruptedException {
    Thread.sleep(5000);
    System.out.println("Navigating to Flipkart...");
    driver.get("https://www.flipkart.com/");
//        // Setup EdgeDriver using WebDriverManager
//        //System.setProperty("webdriver.edge.driver", "C:\\Users\\Monit Gupta\\selenium-java-automation\\drivers\\msedgedriver.exe");
//        WebDriverManager.edgedriver().setup();
//        EdgeOptions options=new EdgeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        // Initialize EdgeDriver
//        WebDriver driver = new EdgeDriver(options);


        try {
            // Open Flipkart homepage
            Actions action =new Actions(driver);
//            System.out.println("Navigating to Flipkart...");
//            driver.get("https://www.flipkart.com/");

           // driver.manage().window().maximize();
            //Assert.assertEquals(actualTitle,"Flipkart");
            // Ensure the URL is correct
           // System.out.println("Current URL: " + driver.getCurrentUrl());

            // Wait for the login button to be clickable
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            WebElement loginButton = wait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Login']")));

            // Locate and click the login button
            action.moveToElement(loginButton).click().perform();
            Thread.sleep(3000);
            // Wait for the login page to open
            WebElement textField = wait
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='number']")));
            textField.click();
            textField.sendKeys("8874927983");
            textField.sendKeys(Keys.ENTER);

            // The login process should continue from here
            System.out.println("Login page is open!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
        driver.quit();


    }
    @Test
    public void loginTest1(){
        driver.get("https://www.flipkart.com/");
    }
    }


