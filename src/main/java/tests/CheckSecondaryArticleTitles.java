package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CheckSecondaryArticleTitles extends BaseTest {
    private final List<String> listOfExpectedArticleTitles = new ArrayList<>(Arrays.asList("Home", "US Election", "Coronavirus", "Video", "World", "UK", "Business", "Tech", "Science", "Stories", "Entertainment & Arts", "Health", "World News TV", "In Pictures"));

    @Test
    public void checkOtherArticle() {
        homePage().clickOnNews();
        Assert.assertEquals(listOfExpectedArticleTitles, newsPage().stringArrayListOfActualSecondaryArticleTitles(), "The expected secondary article titles " + listOfExpectedArticleTitles + " are not equal to the actual secondary article titles " + newsPage().stringArrayListOfActualSecondaryArticleTitles() + "\n");
    }
}