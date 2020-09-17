package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FootballPage extends AbstractPage{
    public FootballPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @FindBy(xpath = "//a[contains(text(),'Scores & Fixtures')]")
    private WebElement scoresAndFixtures;

    public void clickOnScoresAndFixtures() {
        scoresAndFixtures.click();
    }
}
