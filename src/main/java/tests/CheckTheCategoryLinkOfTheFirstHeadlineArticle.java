package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckTheCategoryLinkOfTheFirstHeadlineArticle extends BaseTest {
    protected String actualTab;
    protected String expectedHeadlineFirstArticle;

    @Test(priority = 3)
    public void checkThatSearchWordIsPresentedInTheFirstArticle() {
        homePage().clickOnNews();
        actualTab = newsPage().getExpectedTextOfTheCoronaVirusTab();
        homePage().typeSearchWordAndPressEnter(actualTab);
        expectedHeadlineFirstArticle = searchPage().getFirstListOfHeadlineOfSearchArticles();
        Assert.assertTrue(expectedHeadlineFirstArticle.contains(actualTab), "The first headline article " + expectedHeadlineFirstArticle + " doesn't contain actual article " + actualTab + "\n");
    }
}