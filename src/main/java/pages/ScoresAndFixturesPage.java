package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ScoresAndFixturesPage extends AbstractPage {

    public List<String> scoresOnTheFixturesPage;
    public List<String> scoresOnTheTeamPage;

    @FindBy(xpath = "//input[@id='downshift-0-input']")
    private WebElement searchChampionShip;

    @FindBy(xpath = "//li/a[@class='sp-c-date-picker-timeline__item-inner']")
    private List<WebElement> listOfMonthsAndYears;

    @FindBy(xpath = "//div[@class='sp-c-fixture__wrapper']")
    private List<WebElement> teamAndScore;

    @FindBy(xpath = "//li[@class='gs-o-list-ui__item gs-u-pb-']")
    private List<WebElement> listOfTwoTeams;

    @FindBy(xpath = "//div[@class='gel-wrap']//div[@class='gel-layout gel-layout--center']")
    private WebElement scoreContent;

    @FindBy(xpath = "//section[contains(@class, 'sp-c-fixture--live-session-header')]//span[contains(@class,'sp-c-fixture__number--home')]")
    private WebElement leftScoreOfTeamPage;

    @FindBy(xpath = "//section[contains(@class, 'sp-c-fixture--live-session-header')]//span[contains(@class,'sp-c-fixture__number--away')]")
    private WebElement rightScoreOfTeamPage;

    public ScoresAndFixturesPage(WebDriver driver) {
        super(driver);
    }

    public ScoresAndFixturesPage typeInTheSearchAndPressEnter(String champion) {
        searchChampionShip.sendKeys(champion + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }

    public List<String> getScoresOnTheTeamPage(String firstScore, String secondScore, String firstTeam,
                                               String secondTeam, String monthAndYear) {
        scoresOnTheFixturesPage = new ArrayList<>();
        scoresOnTheTeamPage = new ArrayList<>();
        outerLoop:
        for (int i = 0; i < listOfMonthsAndYears.size(); i++) {
            if (scoreContent.isDisplayed()) {
                listOfMonthsAndYears.get(i).click();
            }
            for (int j = 0; j < listOfTwoTeams.size(); j++) {
                if ((listOfTwoTeams.get(j).getText().contains(firstTeam)) &&
                        (listOfTwoTeams.get(j).getText().contains(secondTeam))) {
                    for (int k = 0; k < teamAndScore.size(); k++) {
                        if (((teamAndScore.get(k).getText().contains(firstScore)
                                && teamAndScore.get(k).getText().contains(secondScore)))
                                && (listOfTwoTeams).get(j).getText().contains(firstTeam)
                                && (listOfTwoTeams.get(j).getText().contains(secondTeam))
                                && (listOfMonthsAndYears.get(i).getText().replaceAll("\\s+", " ")
                                .substring(4).contains(monthAndYear))) {
                            listOfTwoTeams.get(j).click();
                            scoresOnTheTeamPage.add(leftScoreOfTeamPage.getText());
                            scoresOnTheTeamPage.add(rightScoreOfTeamPage.getText());
                            //waitForPageLoadComplete(10);
                            break outerLoop;
                        }
                    }
                }
            }
        }
        return scoresOnTheTeamPage;
    }
}
