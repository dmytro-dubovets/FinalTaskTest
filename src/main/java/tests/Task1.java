package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Task1 extends BaseTest{
    private static final String BBC_NEWS = "BBC News";

    @Test(priority = 1)
    public void checkThatArticleIsCorrect() {
        getHomePage().clickOnNews();
        String expectedText = getNewsPage().getBBCNewsText();
        Assert.assertEquals(expectedText, BBC_NEWS, "message is not correct");
    }
}
