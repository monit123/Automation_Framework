import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class sampleTest {
    public static void main(String[] args) {
        // Set the path to msedgedriver.exe
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Monit Gupta\\selenium-java-automation\\drivers\\msedgedriver.exe");

        // Use existing Edge instance
        EdgeOptions options = new EdgeOptions();
        options.setExperimentalOption("debuggerAddress", "localhost:9223");

        WebDriver driver = new EdgeDriver(options);
        driver.get("https://www.google.com");

        System.out.println("Title: " + driver.getTitle());
        driver.quit();
    }
}
