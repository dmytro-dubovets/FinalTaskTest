package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private final String URL = "https://www.bbc.com/";

    public WebDriver driver;

    // We use this code for TestNG tests

    @BeforeClass
    public void profileSetUp() {
        getDriver(Browser.CHROME);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(URL);
    }

    // We use this code for Cucumber BDD

    public WebDriver getDriver(Browser browser) {
        if (null == driver) {
            switch (browser) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        return driver;
    }

    public WebDriver getDriver() {
        return driver == null ? getDriver(Browser.CHROME) : driver;
    }

    @AfterClass
    public void tearDown() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public enum Browser {
        CHROME,
        FIREFOX
    }
}
