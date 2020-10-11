package cucumber.hooks;


import driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.*;


public class DriverHooks {

    protected static WebDriver driver;

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

    @Before
    public void setUpDriver() {
        driver = DriverSingleton.getDriver();
    }

    @After
    public void closeDriver() {
        DriverSingleton.tearDown();
    }

}

