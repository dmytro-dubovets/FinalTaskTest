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
    public WebElement searchChampionShip;

    @FindBy(xpath = "//li/a[@class='sp-c-date-picker-timeline__item-inner']")
    public List<WebElement> listOfMonthsAndYears;

    @FindBy(xpath = "//div[@class='sp-c-fixture__wrapper']")
    public List<WebElement> teamAndScore;

    @FindBy(xpath = "//li[@class='gs-o-list-ui__item gs-u-pb-']")
    public List<WebElement> listOfTwoTeams;

    @FindBy(xpath = "//div[@class='gel-wrap']//div[@class='gel-layout gel-layout--center']")
    public WebElement scoreContent;

    @FindBy(xpath = "//section[contains(@class, 'sp-c-fixture--live-session-header')]//span[contains(@class,'sp-c-fixture__number--home')]")
    public WebElement leftScoreOfTeamPage;

    @FindBy(xpath = "//section[contains(@class, 'sp-c-fixture--live-session-header')]//span[contains(@class,'sp-c-fixture__number--away')]")
    public WebElement rightScoreOfTeamPage;

    public ScoresAndFixturesPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getScoreContent() {
        return scoreContent;
    }

    public List<WebElement> getTeamAndScore() {
        return teamAndScore;
    }

    public List<WebElement> getListOfTwoTeams() {
        return listOfTwoTeams;
    }

    public WebElement getSearchChampionShip() {
        return searchChampionShip;
    }

    public ScoresAndFixturesPage typeInTheSearchAndPressEnter(String champion) {
        getSearchChampionShip().sendKeys(champion + Keys.ARROW_DOWN + Keys.ENTER);
        return this;
    }

    public List<WebElement> getListOfMonthsAndYears() {
        return listOfMonthsAndYears;
    }


    public List<String> getScoresOnTheTeamPage(String firstScore, String secondScore, String firstTeam,
                                               String secondTeam, String monthAndYear) {
        scoresOnTheFixturesPage = new ArrayList<>();
        scoresOnTheTeamPage = new ArrayList<>();
        outerLoop:
        for (int i = 0; i < getListOfMonthsAndYears().size(); i++) {
            if (getScoreContent().isDisplayed()) {
                getListOfMonthsAndYears().get(i).click();
            }
            for (int j = 0; j < getListOfTwoTeams().size(); j++) {
                if ((getListOfTwoTeams().get(j).getText().contains(firstTeam)) &&
                        (getListOfTwoTeams().get(j).getText().contains(secondTeam))) {
                    for (int k = 0; k < getTeamAndScore().size(); k++) {
                        if (((getTeamAndScore().get(k).getText().contains(firstScore)
                                && getTeamAndScore().get(k).getText().contains(secondScore)))
                                && (getListOfTwoTeams().get(j).getText().contains(firstTeam)
                                && getListOfTwoTeams().get(j).getText().contains(secondTeam))
                                && (getListOfMonthsAndYears().get(i).getText().replaceAll("\\s+", " ")
                                .substring(4).contains(monthAndYear))) {
                            getListOfTwoTeams().get(j).click();
                            scoresOnTheTeamPage.add(leftScoreOfTeamPage.getText());
                            scoresOnTheTeamPage.add(rightScoreOfTeamPage.getText());
                            waitForPageLoadComplete(15);
                            break outerLoop;
                        }
                    }
                }
            }
        }
        return scoresOnTheTeamPage;
    }
}