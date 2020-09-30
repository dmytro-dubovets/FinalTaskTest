package pages;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;


import java.util.List;

public class FactoryOfPages extends AbstractPage {

    protected static WebDriver driver = DriverSingleton.getDriver();

    public static List<String> actualSecondaryArticleTitles;
    public static List<String> expectedScoreOnTheTeamPage;
    public static String expectedTextOfTheMainArticle;
    public static String actualTab;
    public static String expectedHeadlineFirstArticle;
    public static String actualTitle;
    public static boolean errorMessages;

    protected FactoryOfPages(WebDriver driver) {
        super(driver);
    }

    public static HomePage getHomePage() {
        return new HomePage(driver);
    }

    public static NewsPage getNewsPage() {
        return new NewsPage(driver);
    }

    public static SearchPage getSearchPage() {
        return new SearchPage(driver);
    }

    public static CoronaVirusPage getCoronaVirusPage() {
        return new CoronaVirusPage(driver);
    }

    public static CoronaVirusStoriesPage getCoronaVirusStoriesPage() {
        return new CoronaVirusStoriesPage(driver);
    }

    public static Form getHowToShareYourStoriesPage() {
        return new Form(driver);
    }

    public static SportPage getSportPage() {
        return new SportPage(driver);
    }

    public static FootballPage getFootballPage() {
        return new FootballPage(driver);
    }

    public static ScoresAndFixturesPage getScoresAndFixturesPage() {
        return new ScoresAndFixturesPage(driver);
    }
}
