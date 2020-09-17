package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoronaVirusPage extends AbstractPage {
    public CoronaVirusPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']//span[contains(text(),'Your Coronavirus Stories')]")
    private WebElement yourCoronaVirusStories;

    protected By yourCoronaVirusStr = By.xpath("//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__secondary-menuitem-container']//span[contains(text(),'Your Coronavirus Stories')]");

    protected Actions actions;
    protected WebDriverWait wait;


    public WebElement getYourCoronaVirusStories() {
        return yourCoronaVirusStories;
    }

    public void clickOnGetStories() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(yourCoronaVirusStr));
        getYourCoronaVirusStories().click();
    }
/*    //public void clickOnGetStories() {
        getYourCoronaVirusStories().click();
    }*/
}
