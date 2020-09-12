package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CoronaVirusPage extends AbstractPage {
    public CoronaVirusPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']//a[@class='nw-o-link']")
    private WebElement yourCoronaVirusStories;

    public WebElement getYourCoronaVirusStories() {
        return yourCoronaVirusStories;
    }

    public void clickOnGetStories() {
        getYourCoronaVirusStories().click();
    }
}
