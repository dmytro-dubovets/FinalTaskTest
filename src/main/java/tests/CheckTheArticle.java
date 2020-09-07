package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckTheArticle extends BaseTest{
    private String BBC_NEWS = "BBC News";

    @Test(priority = 1)
    public void checkTheArticle() {
        getBasePage().waitVisibilityOfElement(5, getHomePage().getNews());
        getHomePage().clickOnNews();
        String expectedText = getNewsPage().getBBCNewsText();
        Assert.assertEquals(expectedText, BBC_NEWS, "The text of expected article {0} and the text of actual article {1}");
    }

}
