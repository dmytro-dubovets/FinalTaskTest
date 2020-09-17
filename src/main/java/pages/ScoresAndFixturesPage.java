package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ScoresAndFixturesPage extends AbstractPage {
    public ScoresAndFixturesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//input[@id='downshift-0-input']")
    private WebElement searchChampionShip;

    @FindBy(xpath = "//li/a[@class='sp-c-date-picker-timeline__item-inner']")
    private List<WebElement> listOfMonthesAndYears;

    @FindBy(xpath = "//span[@class='sp-c-fixture__number sp-c-fixture__number--home sp-c-fixture__number--ft']")
    private List<WebElement> scoreLeft;


    @FindBy(xpath = "//span[@class='sp-c-fixture__number sp-c-fixture__number--away sp-c-fixture__number--ft']")
    private List<WebElement> scoreRight;


    @FindBy(xpath = "//div[@class='sp-c-fixture__wrapper']")
    private List<WebElement> teamAndScore;

    @FindBy(xpath = "//span[@class='gs-u-display-none gs-u-display-block@m qa-full-team-name sp-c-fixture__team-name-trunc']")
    private List<WebElement> listOfTeams;


    @FindBy(xpath = "//li[@class='gs-o-list-ui__item gs-u-pb-']")
    private List<WebElement> listOfTwoTeams;

    public WebElement getResultOfTheChampion() {
        return resultOfTheChampion;
    }

    public WebElement getScoreContent() {
        return scoreContent;
    }

    @FindBy(xpath = "//div[@class='gel-wrap']//div[@class='gel-layout gel-layout--center']")
    private WebElement scoreContent;

    @FindBy(xpath = "//h1[@id='page']")
    private WebElement resultOfTheChampion;

    public List<WebElement> getScoreLeft() {
        return scoreLeft;
    }

    public List<WebElement> getScoreRight() {
        return scoreRight;
    }

    // Team Page

    @FindBy(xpath = "//span[contains(@class,'sp-c-fixture__number sp-c-fixture__number--home sp-c-fixture__number--ft')]")
    private WebElement leftScoreOfTeamPage;

    public WebElement getLeftScoreOfTeamPage() {
        return leftScoreOfTeamPage;
    }

    public WebElement getRightScoreOfTeamPage() {
        return rightScoreOfTeamPage;
    }

    @FindBy(xpath = "//span[contains(@class,'sp-c-fixture__number sp-c-fixture__number--away sp-c-fixture__number--ft')]")
    private WebElement rightScoreOfTeamPage;

    // Team Page


    public List<WebElement> getTeamAndScore() {
        return teamAndScore;
    }

    public List<WebElement> getListOfTwoTeams() {
        return listOfTwoTeams;
    }

    public WebElement getSearchChampionShip() {
        return searchChampionShip;
    }

    public void typeInTheSearchAndPressEnter(String champion) {
        getSearchChampionShip().sendKeys(champion + Keys.ARROW_DOWN + Keys.ENTER);
    }

    public List<WebElement> getListOfMonthsAndYears() {
        return listOfMonthesAndYears;
    }


    public boolean getNthMonthAndClickWhereTeamsArePresented(String firstScore, String secondScore, String firstTeam, String secondTeam, String monthAndYear) {
        List<Integer> scoresOnTheFixturesPage = new ArrayList<>();
        List<Integer> scoresOnTheTeamPage = new ArrayList<>();
        boolean result = false;
        for (int i = 0; i < getListOfMonthsAndYears().size(); i++) {
            if (getScoreContent().isDisplayed()) {
                getListOfMonthsAndYears().get(i).click();
            }
            for (int j = 0; j < getListOfTwoTeams().size(); j++) {
                if ((getListOfTwoTeams().get(j).getText().contains(firstTeam)) && (getListOfTwoTeams().get(j).getText().contains(secondTeam))) {
                    for (int k = 0; k < getTeamAndScore().size(); k++) {
                        if (((getTeamAndScore().get(k).getText().contains(firstScore) && getTeamAndScore().get(k).getText().contains(secondScore))) && (getListOfTwoTeams().get(j).getText().contains(firstTeam) && getListOfTwoTeams().get(j).getText().contains(secondTeam)) && (getListOfMonthsAndYears().get(i).getText().replaceAll("\\s+", " ").substring(4).contains(monthAndYear))) {
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
            scoresOnTheFixturesPage.clear();
            scoresOnTheTeamPage.clear();
        }
        return result;
    }
}