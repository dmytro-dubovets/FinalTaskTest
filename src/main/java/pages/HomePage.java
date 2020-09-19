package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {


    public WebElement getNews() {
        return news;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSport() {
        return sport;
    }

    public WebElement getCloseButton() {
        return closeButton;
    }

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
        PageFactory.initElements(this.driver, this);
    }

    public void openURL() {
        String URL = "https://www.bbc.com/";
        driver.get(URL);
    }

    public SportPage clickOnSport() {
        sport.click();
        waitAndClosePopUp(closeButton);
        return new SportPage(driver);
    }

    public void clickOnNewsCucumber() {
        getNews().click();
        waitAndClosePopUp(getCloseButton());
    }

    public NewsPage clickOnNews() {
        news.click();
        waitAndClosePopUp(closeButton);
        return new NewsPage(driver);
    }

    public HomePage typeSearchWordAndPressEnter(String searchWord) {
        searchButton.sendKeys(searchWord + Keys.ENTER);
        return this;
    }

    public boolean isTitleEquals(String title) {
        return driver.getTitle().contains(title);
    }
}
