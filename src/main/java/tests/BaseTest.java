package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pages.BasePage;
import pages.HomePage;
import pages.NewsPage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static final String URL = "https://www.bbc.com/";
    protected WebDriver driver;

    @BeforeSuite
    public void profileSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void closeSignInWindow() {
        try {
            String mainWindow = driver.getWindowHandle();
            Set<String> handles = driver.getWindowHandles();
            for (String childWindow : handles) {
                if (!mainWindow.equalsIgnoreCase(childWindow)) {
                    driver.switchTo().window(childWindow);
                    driver.close();
                }
            }
            driver.switchTo().window(mainWindow);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @BeforeTest
    public void testsSetUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public BasePage getBasePage() {
        return new BasePage(getDriver());
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public NewsPage getNewsPage() {
        return new NewsPage(getDriver());
    }

}
