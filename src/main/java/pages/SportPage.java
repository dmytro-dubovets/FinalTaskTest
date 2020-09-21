package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SportPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(@class,'sp-c-sport-navigation__link')][contains(text(),'Football')]")
    private WebElement football;

    public SportPage(WebDriver driver) {
        super(driver);
    }

    public FootballPage clickOnFootball() {
        football.click();
        return new FootballPage(driver);
    }
}
