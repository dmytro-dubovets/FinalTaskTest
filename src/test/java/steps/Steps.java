/*
package steps;

import driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.*;

public class Steps {

    WebDriver driver = null;

    @Given("User opens website bbc.com")
    public void user_opens_website_bbc_com() {
        new DriverManager()
                .profileSetUp();
    }

    @When("User clicks on Sport page")
    public void user_clicks_on_sport_page() {
        new HomePage(driver)
                .clickOnSport();
        System.out.println("clicks on sport page");
    }

    @Then("User clicks on Football page")
    public void user_clicks_on_football_page() {
        new SportPage(driver)
                .clickOnFootball();
        System.out.println("User clicks on football page");
    }

    @And("User clicks on scores and fixtures")
    public void user_clicks_on_scores_and_fixtures() {
        new FootballPage(driver)
                .clickOnScoresAndFixtures();
        System.out.println("User is on scores and fixtures");
    }

    @Then("^User type in the search the name of (.*)$")
    public void user_type_in_the_search_the_name_of_scottish_championship(String championships) {
        new ScoresAndFixturesPage(driver)
                .typeInTheSearchAndPressEnter(championships);
        System.out.println("User type championship" + championships);
    }

    @And("^Check that scores is displayed correctly with typing: (.*), (.*), (.*), (.*), (.*)$")
    public void checkThatScoresIsDisplayedCorrectlyWithTypingFirstScoreSecondScoreFirstTeamSecondTeamMonthAndYear(String first_score,
                                                                                                                  String second_score,
                                                                                                                  String first_team,
                                                                                                                  String second_team,
                                                                                                                  String month_and_year) {
        new ScoresAndFixturesPage(driver)
                .getNthMonthAndClickWhereTeamsArePresented(first_score, second_score, first_team, second_team, month_and_year);
        System.out.println(first_score + second_score + first_team + second_team + month_and_year);
    }
}
*/
