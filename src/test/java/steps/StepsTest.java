package steps;

import driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.NewsPage;


public class StepsTest {
    WebDriver driver;
    String expectedArticle;

    @Given("User opens website")
    public void user_opens_website() {
        new DriverManager()
                .profileSetUp();
    }

    @When("User clicks on news")
    public void user_clicks_on_news() {
        new HomePage(driver)
                .clickOnNews();
    }

    @And("Get expected text of the article")
    public void get_expected_text_of_the_article() {
        expectedArticle = new NewsPage(driver)
                .getExpectedTextOfTheArticle();
    }

    @Then("User assert with actual article")
    public void user_assert_with_actual_article() {
        String actualArticle = "BBC News";
        Assert.assertEquals(expectedArticle, actualArticle, "The expected article " + expectedArticle +
                " is not equal to the actual article " + actualArticle + "\n");
    }
}
