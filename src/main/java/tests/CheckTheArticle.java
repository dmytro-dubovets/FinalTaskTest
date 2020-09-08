package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckTheArticle extends BaseTest {
    private String actualArticle = "BBC News";

    @Test(priority = 1)
    public void checkTheArticle() {
        getBasePage().waitVisibilityOfElement(5, getHomePage().getNews());
        getHomePage().clickOnNews();
        String expectedArticle = getNewsPage().getExpectedTextOfTheArticle();
        Assert.assertEquals(expectedArticle, actualArticle, "The expected article " + expectedArticle + " is not equal to the actual article " + actualArticle + "\n");
    }
}
