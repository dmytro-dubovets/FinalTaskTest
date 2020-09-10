package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckTheArticle extends BaseTest {
    protected String actualArticle = "BBC News";

    @Test
    public void checkTheArticle() {
        homePage().clickOnNews();
        String expectedArticle = newsPage().getExpectedTextOfTheArticle();
        Assert.assertEquals(expectedArticle, actualArticle, "The expected article " + expectedArticle + " is not equal to the actual article " + actualArticle + "\n");
    }
}
