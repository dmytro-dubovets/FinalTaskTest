package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoronaVirusPage extends AbstractPage {
    public CoronaVirusPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']//span[contains(text(),'Your Coronavirus Stories')]")
    private WebElement yourCoronaVirusStories;

    protected By yourCoronaVirusStr = By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']//span[contains(text(),'Your Coronavirus Stories')]");

    public WebElement getYourCoronaVirusStories() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(yourCoronaVirusStr));
        return yourCoronaVirusStories;
    }

    public void clickOnGetStories() {
        getYourCoronaVirusStories().click();
    }
}
