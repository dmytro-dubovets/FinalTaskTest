package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ScoresAndFixturesPage extends AbstractPage {

    @FindBy(xpath = "//li/a[@class='sp-c-date-picker-timeline__item-inner']")
    public List<WebElement> listOfMonthsAndYears;
    @FindBy(xpath = "//input[@id='downshift-0-input']")
    public WebElement searchChampionShip;
    @FindBy(xpath = "//span[@class='sp-c-fixture__number sp-c-fixture__number--home sp-c-fixture__number--ft']")
    public List<WebElement> scoreLeft;
    @FindBy(xpath = "//span[@class='sp-c-fixture__number sp-c-fixture__number--away sp-c-fixture__number--ft']")
    public List<WebElement> scoreRight;
    @FindBy(xpath = "//div[@class='sp-c-fixture__wrapper']")
    public List<WebElement> teamAndScore;
    @FindBy(xpath = "//li[@class='gs-o-list-ui__item gs-u-pb-']")
    public List<WebElement> listOfTwoTeams;
    @FindBy(xpath = "//div[@class='gel-wrap']//div[@class='gel-layout gel-layout--center']")
    public WebElement scoreContent;
    @FindBy(xpath = "//span[contains(@class,'sp-c-fixture__number sp-c-fixture__number--home sp-c-fixture__number--ft')]")
    public WebElement leftScoreOfTeamPage;
    @FindBy(xpath = "//span[contains(@class,'sp-c-fixture__number sp-c-fixture__number--away sp-c-fixture__number--ft')]")
    public WebElement rightScoreOfTeamPage;

    public ScoresAndFixturesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public List<WebElement> getScoreLeft() {
        return scoreLeft;
    }

    public List<WebElement> getScoreRight() {
        return scoreRight;
    }

    public WebElement getLeftScoreOfTeamPage() {
        return leftScoreOfTeamPage;
    }

    public WebElement getRightScoreOfTeamPage() {
        return rightScoreOfTeamPage;
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


    public boolean getNthMonthAndClickWhereTeamsArePresented(String firstScore, String secondScore, String firstTeam, String secondTeam, String monthAndYear) {
        List<Integer> scoresOnTheFixturesPage = new ArrayList<>();
        List<Integer> scoresOnTheTeamPage = new ArrayList<>();
        boolean result = false;
        for (int i = 0; i < getListOfMonthsAndYears().size(); i++) {
            if (scoreContent.isDisplayed()) {
                getListOfMonthsAndYears().get(i).click();
            }
            for (int j = 0; j < getListOfTwoTeams().size(); j++) {
                if ((getListOfTwoTeams().get(j).getText().contains(firstTeam)) &&
                        (getListOfTwoTeams().get(j).getText().contains(secondTeam))) {
                    for (int k = 0; k < getTeamAndScore().size(); k++) {
                        if (((getTeamAndScore().get(k).getText().contains(firstScore) &&
                                getTeamAndScore().get(k).getText().contains(secondScore))) &&
                                (getListOfTwoTeams().get(j).getText().contains(firstTeam) &&
                                        getListOfTwoTeams().get(j).getText().contains(secondTeam)) &&
                                (getListOfMonthsAndYears().get(i).getText().replaceAll("\\s+", " ")
                                        .substring(4).contains(monthAndYear))) {
                            scoresOnTheFixturesPage.add(Integer.parseInt(getScoreLeft().get(k).getText()));
                            scoresOnTheFixturesPage.add(Integer.parseInt(getScoreRight().get(k).getText()));
                            getListOfTwoTeams().get(j).click();
                            scoresOnTheTeamPage.add(Integer.parseInt(getLeftScoreOfTeamPage().getText()));
                            scoresOnTheTeamPage.add(Integer.parseInt(getRightScoreOfTeamPage().getText()));
                            break;
                        }
                    }
                }
            }
        }
        if (scoresOnTheFixturesPage.equals(scoresOnTheTeamPage)) {
            result = true;
        }
        return result;
    }
}