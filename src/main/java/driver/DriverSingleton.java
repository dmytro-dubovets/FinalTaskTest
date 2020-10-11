package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static WebDriver driver;

    public DriverSingleton() {
    }

    public static WebDriver getDriver(Browser browser) {
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
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver == null ? getDriver(Browser.CHROME) : driver;
    }

    public static  void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public enum Browser {
        CHROME,
        FIREFOX
    }
}
