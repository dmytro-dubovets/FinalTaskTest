package cucumber.steps;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class StepsDefinition {

    String titleOfHowToShareStories = "How to share your questions, stories, pictures and videos with BBC News - BBC News";
    List<String> actualSecondaryArticleTitles;
    List<String> expectedScoreOnTheTeamPage;
    String expectedArticle;
    String actualTab;
    String expectedHeadlineFirstArticle;
    String actualTitle;
    boolean errorMessages;

    DriverFactory driverFactory = new DriverFactory();
    WebDriver driver = driverFactory.getDriver();
    HomePage homePage = new HomePage(driver);
    NewsPage newsPage = new NewsPage(driver);
    SearchPage searchPage = new SearchPage(driver);
    CoronaVirusPage coronaVirusPage = new CoronaVirusPage(driver);
    HowToShareYourStoriesPage howToShareYourStoriesPage = new HowToShareYourStoriesPage(driver);
    CoronaVirusStoriesPage coronaVirusStoriesPage = new CoronaVirusStoriesPage(driver);
    SportPage sportPage = new SportPage(driver);
    FootballPage footballPage = new FootballPage(driver);
    ScoresAndFixturesPage scoresAndFixturesPage = new ScoresAndFixturesPage(driver);

    @Before
    public void setUpDriver() {
        driverFactory.getDriver(DriverFactory.Browser.CHROME);
    }

    @After
    public void closeDriver() {
        driverFactory.tearDown();
    }

    @Given("User opens website")
    public void user_opens_website() {
        homePage.openURL();
    }

    @When("User clicks on news")
    public void user_clicks_on_news() {
        homePage.clickOnNews();
    }

    @And("Get expected text of the article")
    public void get_expected_text_of_the_article() {
        expectedArticle = newsPage.getExpectedTextOfTheArticle();
    }

    @Then("User assert with actual article")
    public void user_assert_with_actual_article() {
        String actualArticle = "BBC News";
        assertThat(actualArticle).isEqualTo(expectedArticle);

    }

    // Steps for Scenario: Check secondary article titles

    @And("Get the list of actual secondary article titles")
    public void get_the_list_of_actual_secondary_article_titles() {
        actualSecondaryArticleTitles = newsPage
                .stringArrayListOfActualSecondaryArticleTitles();
    }

    @Then("Assert the expected and actual secondary article titles")
    public void assert_the_expected_and_actual_secondary_article_titles() {
        List<String> listOfExpectedArticleTitles = new ArrayList<>(Arrays.asList(
                "Home", "US Election", "Coronavirus", "Video", "World",
                "UK", "Business", "Tech", "Science", "Stories", "Entertainment & Arts",
                "Health", "World News TV", "In Pictures"));
        assertThat(actualSecondaryArticleTitles).isEqualTo(listOfExpectedArticleTitles);
    }

    // Steps for Scenario: Check the category link of the first headline article

    @And("Get expected text of the chosen tab")
    public void get_expected_text_of_the_chosen_tab() {
        actualTab = newsPage.getExpectedTextOfTheCoronaVirusTab();
    }

    @Then("Type chosen text in the search field and press enter")
    public void type_chosen_text_in_the_search_field_and_press_enter() {
        homePage.typeSearchWordAndPressEnter(actualTab);
    }

    @And("Get text of the expected headline the first article")
    public void get_text_of_the_expected_headline_the_first_article() {
        expectedHeadlineFirstArticle = searchPage.getFirstListOfHeadlineOfSearchArticles();
    }

    @Then("Assert that headline of the first article contains text of the chosen tab")
    public void assert_that_headline_of_the_first_article_contains_text_of_the_chosen_tab() {
        assertThat(expectedHeadlineFirstArticle).contains(actualTab);
    }

    // Steps for Scenario: Verifies that user can not submit a question in the form

    @When("User clicks on Coronavirus tab")
    public void user_clicks_on_coronavirus_tab() {
        newsPage.clickOnTheCoronaVirusTab();
    }

    @Then("User clicks on Your Coronavirus Stories")
    public void user_clicks_on_your_coronavirus_stories() {
        coronaVirusPage.clickOnGetStories();
    }

    @And("User clicks on How to share with BBC news")
    public void user_clicks_on_how_to_share_with_bbc_news() {
        coronaVirusStoriesPage.clickOnHowToShareYourStories();
    }

    @When("User clicks on Submit button")
    public void user_clicks_on_submit_button() {
        howToShareYourStoriesPage.clickOnSubmitButton();
    }

    @And("Get the title of actual page")
    public void get_the_title_of_actual_page() {
        actualTitle = homePage.getTitle();
    }

    @Then("User assert the actual and expected titles of the displayed page")
    public void user_assert_the_actual_and_expected_titles_of_the_displayed_page() {
        assertThat(actualTitle).isEqualTo(titleOfHowToShareStories);
    }

    @And("Get the errors")
    public void get_the_errors() {
        errorMessages = howToShareYourStoriesPage.ifErrorsMessagesAreDisplayed();
    }

    @Then("User assert that errors are displayed")
    public void user_assert_that_errors_are_displayed() {
        assertThat(errorMessages).isTrue();
    }


    // Steps for Scenario: Verifies that user can not submit with one checked required checkbox I am over 16 years old

    @Then("User check required checkbox I am over 16 years old")
    public void user_check_required_checkbox_i_am_16_over_years_old() {
        howToShareYourStoriesPage.clickOnCheckBoxOver16();
    }

    // Steps for Scenario: Verifies that user can not submit with all checked
    // required checkboxes and with not empty story or name

    @Then("^User fill some (.*) or (.*) in the fields$")
    public void user_fill_some_story_or_name_in_the_field_name(String story, String name) {
        howToShareYourStoriesPage.sendNameOrStory(story,name);
    }

    @And("User checks all required checkboxes")
    public void user_checks_all_required_checkboxes() {
        howToShareYourStoriesPage.clickOnAllCheckBoxes();
    }

    // Steps for Scenario: The team scores should be displayed correctly

    @When("User clicks on Sport page")
    public void user_clicks_on_sport_page() {
        homePage.clickOnSport();
    }

    @Then("User clicks on Football page")
    public void user_clicks_on_football_page() {
        sportPage.clickOnFootball();
    }

    @And("User clicks on scores and fixtures")
    public void user_clicks_on_scores_and_fixtures() {
        footballPage.clickOnScoresAndFixtures();
    }

    @Then("^User type in the search the name of (.*)$")
    public void user_type_in_the_search_the_name_of_championship(String championship) {
        scoresAndFixturesPage.typeInTheSearchAndPressEnter(championship);
    }

    @And("^Get scores on the Team page (.*), (.*), (.*), (.*), (.*)$")
    public void get_scores_on_the_team_page(String first_score, String second_score, String first_team,
                                            String second_team, String month_and_year) {
        expectedScoreOnTheTeamPage = scoresAndFixturesPage.getScoresOnTheTeamPage(first_score,second_score,first_team,
                second_team,month_and_year);
    }

    @Then("^Assert that (.*) and (.*) are equals scores on the Team page$")
    public void assert_that_first_score_and_second_score_are_equals_on_the_team_page(String first_score,
                                                                                     String second_score) {
        assertThat(expectedScoreOnTheTeamPage).containsSequence(first_score, second_score);
    }
}
