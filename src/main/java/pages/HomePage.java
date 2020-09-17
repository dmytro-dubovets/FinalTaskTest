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

    @FindBy(xpath = "//div[@id='orb-nav-links']//a[contains(text(),'News')]")
    private WebElement news;
    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchButton;
    @FindBy(xpath = "//div[@id='orb-nav-links']//a[contains(text(),'Sport')]")
    private WebElement sport;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnSport() {
        sport.click();
    }

    public void clickOnNews() {
        news.click();
    }

    public void typeSearchWordAndPressEnter(String searchWord) {
        searchButton.sendKeys(searchWord + Keys.ENTER);
    }


    public boolean ifTitleIsEquals(String title) {
        boolean result = false;
        if (driver.getTitle().contains(title)) {
            result = true;
        }
        return result;
    }

}
