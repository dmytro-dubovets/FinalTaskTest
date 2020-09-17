package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    public WebElement getNews() {
        return news;
    }

    @FindBy(xpath = "//div[@id='orb-nav-links']//a[contains(text(),'News')]")
    private WebElement news;
    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void waitForPageLoadComplete(long timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
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
