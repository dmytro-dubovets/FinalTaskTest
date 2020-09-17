package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SportPage extends AbstractPage {
    public SportPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//a[@class='sp-c-sport-navigation__link qa-primary-item sp-nav-click-stat'][contains(text(),'Football')]")
    private WebElement football;

    public void clickOnFootball() {
        football.click();
    }
}
