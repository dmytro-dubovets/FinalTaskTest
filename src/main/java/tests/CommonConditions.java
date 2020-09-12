package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class CommonConditions {

    protected WebDriver driver;
    protected String url = "https://www.bbc.com/";

    protected By windowOff = By.xpath("//button[@class='sign_in-exit']");

    @BeforeSuite
    public void profileSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    @AfterMethod
    public void writeTextMsgIfWindowIsDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 1);
            WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(windowOff));
            if (button.getAttribute("data-bbc-title").contains("dismiss")) {
                button.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
