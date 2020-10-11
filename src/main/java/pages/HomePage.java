package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[@id='orb-nav-links']//a[contains(text(),'News')]")
    private WebElement news;

    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@id='orb-nav-links']//a[contains(text(),'Sport')]")
    private WebElement sport;

    @FindBy(xpath = "//button[@class='sign_in-exit']")
    private WebElement closeButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openURL() {
        String URL = "https://www.bbc.com/";
        driver.get(URL);
        waitForPageLoadComplete(20);
    }

    public SportPage clickOnSport() {
        wait.until(ExpectedConditions.visibilityOf(sport));
        sport.click();
        waitAndClosePopUp(closeButton);
        return new SportPage(driver);
    }

    public NewsPage clickOnNews() {
        wait.until(ExpectedConditions.visibilityOf(news));
        news.click();
        waitAndClosePopUp(closeButton);
        return new NewsPage(driver);
    }

    public HomePage typeSearchWordAndPressEnter(String searchWord) {
        searchButton.sendKeys(searchWord + Keys.ENTER);
        return this;
    }
}
