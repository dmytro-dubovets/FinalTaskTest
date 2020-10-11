package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FootballPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(text(),'Scores & Fixtures')]")
    private WebElement scoresAndFixtures;

    public FootballPage(WebDriver driver) {
        super(driver);
    }

    public ScoresAndFixturesPage clickOnScoresAndFixtures() {
        wait.until(ExpectedConditions.elementToBeClickable(scoresAndFixtures)).click();
        waitForPageLoadComplete(20);
        return new ScoresAndFixturesPage(driver);
    }
}
