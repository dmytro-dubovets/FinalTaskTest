package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.BasePage;
import pages.HomePage;
import pages.NewsPage;
import pages.SearchPage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected String url = "https://www.bbc.com/";

    public BasePage getBasePage() {
        return new BasePage(driver);
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public NewsPage getNewsPage() {
        return new NewsPage(driver);
    }

    public SearchPage getSearchPage() {
        return new SearchPage(driver);
    }

    @BeforeSuite
    public void profileSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeClass

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
        driver.get(url);
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
