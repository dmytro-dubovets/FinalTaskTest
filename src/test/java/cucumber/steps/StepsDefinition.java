package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static pages.FactoryOfPages.*;


public class StepsDefinition {

    @Given("User opens website")
    public void userOpensWebsite() {
        getHomePage().openURL();
    }

    @When("User clicks on news tab")
    public void userClicksOnNewsTab() {
        getHomePage().clickOnNews();
    }

    @And("Get expected text of the main article")
    public void getExpectedTextOfTheMainArticle() {
        expectedTextOfTheMainArticle = getNewsPage().getExpectedTextOfTheMainArticle();
    }

    @Then("User assert with actual article")
    public void userAssertWithActualArticle() {
        String actualArticle = "BBC News";
        assertThat(actualArticle).isEqualTo(expectedTextOfTheMainArticle);
    }

    @And("Get the list of actual secondary article titles")
    public void getTheListOfActualSecondaryArticleTitles() {
        actualSecondaryArticleTitles = getNewsPage()
                .stringArrayListOfActualSecondaryArticleTitles();
    }

    @Then("Assert the expected and actual secondary article titles")
    public void assertTheExpectedAndActualSecondaryArticleTitles() {
        List<String> listOfExpectedArticleTitles = new ArrayList<>(Arrays.asList(
                "Home", "US Election", "Coronavirus", "Video", "World",
                "UK", "Business", "Tech", "Science", "Stories", "Entertainment & Arts",
                "Health", "World News TV", "In Pictures"));
        assertThat(actualSecondaryArticleTitles).isEqualTo(listOfExpectedArticleTitles);
    }

    @And("Get expected text of the chosen tab")
    public void getExpectedTextOfTheChosenTab() {
        actualTab = getNewsPage().getExpectedTextOfTheCoronaVirusTab();
    }

    @Then("Type chosen text in the search field and press enter")
    public void typeChosenTextInTheSearchFieldAndPressEnter() {
        getHomePage().typeSearchWordAndPressEnter(actualTab);
    }

    @And("Get text of the expected headline the first article")
    public void getTextOfTheExpectedHeadlineTheFirstArticle() {
        expectedHeadlineFirstArticle = getSearchPage().getFirstListOfHeadlineOfSearchArticles();
    }

    @Then("Assert that headline of the first article contains text of the chosen tab")
    public void assertThatHeadlineOfTheFirstArticleContainsTextOfTheChosenTab() {
        assertThat(expectedHeadlineFirstArticle).contains(actualTab);
    }

    @When("User clicks on Coronavirus tab")
    public void userClicksOnCoronavirusTab() {
        getNewsPage().clickOnTheCoronaVirusTab();
    }

    @Then("User clicks on Your Coronavirus Stories")
    public void user_clicks_on_your_coronavirus_stories() {
        getCoronaVirusPage().clickOnGetStories();
    }

    @And("User clicks on How to share with BBC news")
    public void userClicksOnHowToShareWithBBCNews() {
        getCoronaVirusStoriesPage().clickOnHowToShareYourStories();
    }

    @When("User clicks on Submit button")
    public void userClicksOnSubmitButton() {
        getHowToShareYourStoriesPage().clickOnSubmitButton();
    }

    @And("Get the title of actual page")
    public void getTheTitleOfActualPage() {
        actualTitle = getHomePage().getTitle();
    }

    @Then("User assert the actual and expected titles of the displayed page")
    public void userAssertTheActualAndExpectedTitlesOfTheDisplayedPage() {
        String titleOfHowToShareStories = "How to share your questions, stories, pictures and videos with BBC News - BBC News";
        assertThat(actualTitle).isEqualTo(titleOfHowToShareStories);
    }

    @And("Get the error messages")
    public void getTheErrorMessages() {
        errorMessages = getHowToShareYourStoriesPage().ifErrorsMessagesAreDisplayed();
    }

    @Then("User assert that error messages are displayed")
    public void userAssertThatErrorMessagesAreDisplayed() {
        assertThat(errorMessages).isTrue();
    }

    @Then("User check required checkbox I am over 16 years old")
    public void userCheckRequiredCheckboxIAm16OverYearsOld() {
        getHowToShareYourStoriesPage().clickOnCheckBoxOver16();
    }

    @Then("^User fill some (.*) or (.*) in the fields$")
    public void userFillSomeStoryOrNameInTheFieldName(String story, String name) {
        getHowToShareYourStoriesPage().sendNameOrStory(story, name);
    }

    @And("User checks all required checkboxes")
    public void userChecksAllRequiredCheckboxes() {
        getHowToShareYourStoriesPage().clickOnAllCheckBoxes();
    }

    @When("User clicks on Sport page")
    public void userClicksOnSportPage() {
        getHomePage().clickOnSport();
    }

    @Then("User clicks on Football page")
    public void userClicksOnFootballPage() {
        getSportPage().clickOnFootball();
    }

    @And("User clicks on scores and fixtures")
    public void userClicksOnScoresAndFixtures() {
        getFootballPage().clickOnScoresAndFixtures();
    }

    @Then("^User type in the search the name of (.*)$")
    public void userTypeInTheSearchTheNameOfChampionship(String championship) {
        getScoresAndFixturesPage().typeInTheSearchAndPressEnter(championship);
    }

    @And("^Get scores on the Team page (.*), (.*), (.*), (.*), (.*)$")
    public void getScoresOnTheTeamPage(String first_score, String second_score, String first_team,
                                       String second_team, String month_and_year) {
        expectedScoreOnTheTeamPage = getScoresAndFixturesPage().getScoresOnTheTeamPage(first_score, second_score,
                first_team, second_team, month_and_year);
    }

    @Then("^Assert that (.*) and (.*) are equals scores on the Team page$")
    public void assertThatFirstScoreAndSecondScoresAreEqualsOnTheTeamPage(String first_score, String second_score) {
        assertThat(expectedScoreOnTheTeamPage).containsSequence(first_score, second_score);
    }
}
