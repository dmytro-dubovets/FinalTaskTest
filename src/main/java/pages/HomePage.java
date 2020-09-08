package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='orb-nav-links']//a[contains(text(),'News')]")
    private WebElement news;
    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getNews() {
        return news;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public void clickOnNews() {
        news.click();
    }

    public void typeSearchWordAndPressEnter(String searchWord) {
        getSearchButton().sendKeys(searchWord + Keys.ENTER);
    }
}
