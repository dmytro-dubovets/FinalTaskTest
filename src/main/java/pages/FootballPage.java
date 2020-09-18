package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FootballPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(text(),'Scores & Fixtures')]")
    private WebElement scoresAndFixtures;

    public FootballPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ScoresAndFixturesPage clickOnScoresAndFixtures() {
        scoresAndFixtures.click();
        return new ScoresAndFixturesPage(driver);
    }
}
