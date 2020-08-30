package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[@id='orb-nav-links']//a[contains(text(),'News')]")
    private WebElement news;

    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchButton;

    public void typeSearchWordAndPressEnter(String searchWord) {
        searchButton.sendKeys(searchWord + Keys.ENTER);
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
}
