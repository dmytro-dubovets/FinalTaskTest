package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewsPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CheckSecondaryArticleTitles extends CommonConditions {
    private final List<String> listOfExpectedArticleTitles = new ArrayList<>(Arrays.asList("Home", "US Election", "Coronavirus", "Video", "World", "UK", "Business", "Tech", "Science", "Stories", "Entertainment & Arts", "Health", "World News TV", "In Pictures"));

    @Test
    public void checkSecondaryArticles() {
        HomePage homePage = new HomePage(driver);
        homePage.waiAndClickOnNews();
        ArrayList<String> actualSecondaryArticleTitles = new NewsPage(driver)
                .stringArrayListOfActualSecondaryArticleTitles();
        Assert.assertEquals(listOfExpectedArticleTitles, actualSecondaryArticleTitles, "The expected secondary article titles " + listOfExpectedArticleTitles + " are not equal to the actual secondary article titles " + actualSecondaryArticleTitles + "\n");
    }
}