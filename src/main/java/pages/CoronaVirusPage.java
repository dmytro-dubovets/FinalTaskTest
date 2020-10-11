package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronaVirusPage extends AbstractPage {

    private final By yourCoronaVirusStr = By
            .xpath("//li[contains(@class,'nw-c-nav__secondary-menuitem-container')]//span[contains(text(),'Your Coronavirus Stories')]");

    @FindBy(xpath = "//li[contains(@class,'nw-c-nav__secondary-menuitem-container')]//span[contains(text(),'Your Coronavirus Stories')]")
    private WebElement yourCoronaVirusStories;

    public CoronaVirusPage(WebDriver driver) {
        super(driver);
    }

    public CoronaVirusStoriesPage clickOnGetStories() {
        yourCoronaVirusStories.click();
        waitForPageLoadComplete(20);
        return new CoronaVirusStoriesPage(driver);
    }
}
