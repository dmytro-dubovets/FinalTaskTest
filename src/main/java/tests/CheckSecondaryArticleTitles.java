package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CheckSecondaryArticleTitles extends BaseTest {
    private final List<String> listOfExpectedArticleTitles = new ArrayList<>(Arrays.asList("Home", "US Election", "Coronavirus", "Video", "World", "UK", "Business", "Tech", "Science", "Stories", "Entertainment & Arts", "Health", "World News TV", "In Pictures"));

    @Test(priority = 2)
    public void checkOtherArticle() {
        getBasePage().waitVisibilityOfElement(5, getHomePage().getNews());
        getHomePage().clickOnNews();
        Assert.assertEquals(listOfExpectedArticleTitles, getNewsPage().stringArrayListOfActualSecondaryArticleTitles(), "The expected secondary article titles " + listOfExpectedArticleTitles + " are not equal to the actual secondary article titles " + getNewsPage().stringArrayListOfActualSecondaryArticleTitles() + "\n");
    }
}