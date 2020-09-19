package tests;

import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CheckSecondaryArticleTitles extends DriverFactory {
    private final List<String> listOfExpectedArticleTitles = new ArrayList<>(Arrays.asList(
            "Home", "US Election", "Coronavirus", "Video", "World",
            "UK", "Business", "Tech", "Science", "Stories", "Entertainment & Arts",
            "Health", "World News TV", "In Pictures"));

    @Test
    public void checkSecondaryArticles() {
        List<String> actualSecondaryArticleTitles = new HomePage(driver)
                .clickOnNews()
                .stringArrayListOfActualSecondaryArticleTitles();
        Assert.assertEquals(listOfExpectedArticleTitles, actualSecondaryArticleTitles,
                "The expected secondary article titles " + listOfExpectedArticleTitles +
                        " are not equal to the actual secondary article titles " +
                        actualSecondaryArticleTitles + "\n");
    }
}
