package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class CommonConditions {

    protected WebDriver driver;
    protected String url = "https://www.bbc.com/";


    @BeforeSuite
    public void profileSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void testsSetUp() {
        driver.manage().window().maximize();
        driver.get(url);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}