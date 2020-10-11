package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ScoresAndFixturesPage extends AbstractPage {

    public List<String> scoresOnTheFixturesPage;
    public List<String> scoresOnTheTeamPage;

    @FindBy(xpath = "//input[@id='downshift-0-input']")
    private WebElement searchChampionShip;

    @FindBy(xpath = "//li/a[@class='sp-c-date-picker-timeline__item-inner  false']")
    private List<WebElement> listOfMonthsAndYears;

    @FindBy(xpath = "//div[@class='sp-c-fixture__wrapper']")
    private List<WebElement> teamAndScore;

    @FindBy(xpath = "//li[@class='gs-o-list-ui__item gs-u-pb-']")
    private List<WebElement> listOfTwoTeams;

/*    @FindBy(xpath = "//div[@class='gel-wrap']//div[@class='gel-layout gel-layout--center']")
    private WebElement scoreContent;*/

    @FindBy(xpath = "//div[@id='orb-modules']//div[@class='gel-layout gel-layout--center']/div[@class='gel-layout__item gel-10/12@l']/div[@class='gs-u-clearfix']")
    private WebElement scoreContent;

    @FindBy(xpath = "//section[contains(@class, 'sp-c-fixture--live-session-header')]//span[contains(@class,'sp-c-fixture__number--home')]")
    private WebElement leftScoreOfTeamPage;

    @FindBy(xpath = "//section[contains(@class, 'sp-c-fixture--live-session-header')]//span[contains(@class,'sp-c-fixture__number--away')]")
    private WebElement rightScoreOfTeamPage;

    public ScoresAndFixturesPage(WebDriver driver) {
        super(driver);
    }

    public ScoresAndFixturesPage typeInTheSearchAndPressEnter(String champion) {
        wait.until(ExpectedConditions.elementToBeClickable(searchChampionShip));
        searchChampionShip.sendKeys(champion + Keys.ARROW_DOWN + Keys.ENTER);
        waitForPageLoadComplete(20);
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
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
                            waitForPageLoadComplete(20);
                            try {
                                scoresOnTheTeamPage.add(leftScoreOfTeamPage.getText());
                                scoresOnTheTeamPage.add(rightScoreOfTeamPage.getText());
                            } catch (Exception e) {
                                System.out.println(scoresOnTheTeamPage);
                                e.printStackTrace();
                            }
                            break outerLoop;
                        }
                    }
                }
            }
        }
        return scoresOnTheTeamPage;
    }
}
