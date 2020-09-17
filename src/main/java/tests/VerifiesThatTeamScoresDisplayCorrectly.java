package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class VerifiesThatTeamScoresDisplayCorrectly extends CommonConditions{
    protected String SEARCH_CHAMPIONSHIP = "Scottish Championship";
    protected String FIRST_TEAM = "Dunfermline";
    protected String SECOND_TEAM = "Partick Thistle";
    protected String FIRST_SCORE = "5";
    protected String SECOND_SCORE = "1";
    protected String MONTH_YEAR = "2019 November";

    protected String SEARCH_CHAMPIONSHIP_SECOND = "National League";
    protected String FIRST_TEAM_SECOND = "Notts County";
    protected String SECOND_TEAM_SECOND = "Barnet";
    protected String FIRST_SCORE_SECOND = "2";
    protected String SECOND_SCORE_SECOND = "0";
    protected String MONTH_YEAR_SECOND = "2020 July";

    protected String SEARCH_CHAMPIONSHIP_THIRD = "Europa League";
    protected String FIRST_TEAM_THIRD = "LASK";
    protected String SECOND_TEAM_THIRD = "Manchester United";
    protected String FIRST_SCORE_THIRD = "0";
    protected String SECOND_SCORE_THIRD = "5";
    protected String MONTH_YEAR_THIRD = "2020 March";

    protected String SEARCH_CHAMPIONSHIP_FOURTH = "Premier League";
    protected String FIRST_TEAM_FOURTH = "Burnley";
    protected String SECOND_TEAM_FOURTH = "Crystal Palace";
    protected String FIRST_SCORE_FOURTH = "0";
    protected String SECOND_SCORE_FOURTH = "2";
    protected String MONTH_YEAR_FOURTH = "2019 November";

    protected String SEARCH_CHAMPIONSHIP_FIFTH = "England Football Team";
    protected String FIRST_TEAM_FIFTH = "Kosovo";
    protected String SECOND_TEAM_FIFTH = "England";
    protected String FIRST_SCORE_FIFTH = "0";
    protected String SECOND_SCORE_FIFTH = "4";
    protected String MONTH_YEAR_FIFTH = "2019 November";


    @Test
    public void checkThatTeamsScores() {
        HomePage homePage = new HomePage(driver);
        SportPage sportPage = new SportPage(driver);
        NewsPage newsPage = new NewsPage(driver);
        FootballPage footballPage = new FootballPage(driver);
        ScoresAndFixturesPage scoresAndFixturesPage = new ScoresAndFixturesPage(driver);
        homePage.clickOnSport();
        newsPage.waitAndClosePopUp();
        sportPage.clickOnFootball();
        footballPage.clickOnScoresAndFixtures();
        scoresAndFixturesPage.typeInTheSearchAndPressEnter(SEARCH_CHAMPIONSHIP);
        Assert.assertTrue(scoresAndFixturesPage.getNthMonthAndClickWhereTeamsArePresented(FIRST_SCORE, SECOND_SCORE, FIRST_TEAM, SECOND_TEAM, MONTH_YEAR), "The Score is not correct");
    }

    @Test
    public void checkThatTeamsScoresSecondChampionShip() {
        HomePage homePage = new HomePage(driver);
        SportPage sportPage = new SportPage(driver);
        NewsPage newsPage = new NewsPage(driver);
        FootballPage footballPage = new FootballPage(driver);
        ScoresAndFixturesPage scoresAndFixturesPage = new ScoresAndFixturesPage(driver);
        homePage.clickOnSport();
        newsPage.waitAndClosePopUp();
        sportPage.clickOnFootball();
        footballPage.clickOnScoresAndFixtures();
        scoresAndFixturesPage.typeInTheSearchAndPressEnter(SEARCH_CHAMPIONSHIP_SECOND);
        Assert.assertTrue(scoresAndFixturesPage.getNthMonthAndClickWhereTeamsArePresented(FIRST_SCORE_SECOND, SECOND_SCORE_SECOND, FIRST_TEAM_SECOND, SECOND_TEAM_SECOND, MONTH_YEAR_SECOND), "The Score is not correct");
    }

    @Test
    public void checkThatTeamsScoresThirdChampionShip() {
        HomePage homePage = new HomePage(driver);
        SportPage sportPage = new SportPage(driver);
        NewsPage newsPage = new NewsPage(driver);
        FootballPage footballPage = new FootballPage(driver);
        ScoresAndFixturesPage scoresAndFixturesPage = new ScoresAndFixturesPage(driver);
        homePage.clickOnSport();
        newsPage.waitAndClosePopUp();
        sportPage.clickOnFootball();
        footballPage.clickOnScoresAndFixtures();
        scoresAndFixturesPage.typeInTheSearchAndPressEnter(SEARCH_CHAMPIONSHIP_THIRD);
        Assert.assertTrue(scoresAndFixturesPage.getNthMonthAndClickWhereTeamsArePresented(FIRST_SCORE_THIRD, SECOND_SCORE_THIRD, FIRST_TEAM_THIRD, SECOND_TEAM_THIRD, MONTH_YEAR_THIRD), "The Score is not correct");
    }

    @Test
    public void checkThatTeamsScoresFourthChampionShip() {
        HomePage homePage = new HomePage(driver);
        SportPage sportPage = new SportPage(driver);
        NewsPage newsPage = new NewsPage(driver);
        FootballPage footballPage = new FootballPage(driver);
        ScoresAndFixturesPage scoresAndFixturesPage = new ScoresAndFixturesPage(driver);
        homePage.clickOnSport();
        newsPage.waitAndClosePopUp();
        sportPage.clickOnFootball();
        footballPage.clickOnScoresAndFixtures();
        scoresAndFixturesPage.typeInTheSearchAndPressEnter(SEARCH_CHAMPIONSHIP_FOURTH);
        Assert.assertTrue(scoresAndFixturesPage.getNthMonthAndClickWhereTeamsArePresented(FIRST_SCORE_FOURTH, SECOND_SCORE_FOURTH, FIRST_TEAM_FOURTH, SECOND_TEAM_FOURTH, MONTH_YEAR_FOURTH), "The Score is not correct");
    }

    @Test
    public void checkThatTeamsScoresFifthChampionShip() {
        HomePage homePage = new HomePage(driver);
        SportPage sportPage = new SportPage(driver);
        NewsPage newsPage = new NewsPage(driver);
        FootballPage footballPage = new FootballPage(driver);
        ScoresAndFixturesPage scoresAndFixturesPage = new ScoresAndFixturesPage(driver);
        homePage.clickOnSport();
        newsPage.waitAndClosePopUp();
        sportPage.clickOnFootball();
        footballPage.clickOnScoresAndFixtures();
        scoresAndFixturesPage.typeInTheSearchAndPressEnter(SEARCH_CHAMPIONSHIP_FIFTH);
        Assert.assertTrue(scoresAndFixturesPage.getNthMonthAndClickWhereTeamsArePresented(FIRST_SCORE_FIFTH, SECOND_SCORE_FIFTH, FIRST_TEAM_FIFTH, SECOND_TEAM_FIFTH, MONTH_YEAR_FIFTH), "The Score is not correct");
    }
}
