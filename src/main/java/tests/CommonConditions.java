package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class CommonConditions {

    protected WebDriver driver;
    protected String url = "https://www.bbc.com/";
    protected String Chrome = "Chrome";
    protected String FireFox = "Firefox";

    public void setDriver(String browser) {
        switch (browser) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
    }

    @BeforeSuite
    public void profileSetUp() {
        setDriver(Chrome);
    }

    @BeforeTest
    public void testsSetUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(url);
    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
