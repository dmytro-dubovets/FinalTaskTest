package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public abstract class BasePage {

    protected static WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        driver = DriverSingleton.getDriver();
        driver.manage().window().maximize();
        String URL = "https://www.bbc.com/";
        driver.get(URL);
    }

    @AfterTest
    public void closeBrowser() {
        DriverSingleton.tearDown();
    }
}
