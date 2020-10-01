package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BasePage {

    protected static WebDriver driver;

    @BeforeClass
    public void profileSetUp() {
        driver = DriverSingleton.getDriver();
        driver.manage().window().maximize();
        String URL = "https://www.bbc.com/";
        driver.get(URL);
    }

    @AfterClass
    public void closeBrowser() {
        DriverSingleton.tearDown();
    }
}
