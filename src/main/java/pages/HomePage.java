package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//div[@id='orb-nav-links']//a[contains(text(),'News')]")
    private WebElement news;
    @FindBy(xpath = "//input[@id='orb-search-q']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[@class='sign_in-exit']")
    private WebElement buttonExit;

    protected By windowOff = By.xpath("//button[@class='sign_in-exit']");

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void writeTextMsgIfWindowIsDisplayed() {
        try {
            /*WebDriverWait wait = new WebDriverWait(driver, 1);
            WebElement button = wait.until(ExpectedConditions.presenceOfElementLocated(windowOff));*/
            if (buttonExit.isDisplayed()) {
                buttonExit.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waiAndClickOnNews() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(news)).click();
        writeTextMsgIfWindowIsDisplayed();
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
