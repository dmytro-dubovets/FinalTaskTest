package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    protected static WebDriver driver;

    @BeforeClass
    public void profileSetUp() {
        driver = DriverSingleton.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String URL = "https://www.bbc.com/";
        driver.get(URL);
    }

    @AfterClass
    public void closeBrowser() {
        DriverSingleton.tearDown();
    }
}
