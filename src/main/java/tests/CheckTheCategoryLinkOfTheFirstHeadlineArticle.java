package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckTheCategoryLinkOfTheFirstHeadlineArticle extends BaseTest {
    protected String actualTab;
    protected String expectedHeadlineFirstArticle;

    @Test(priority = 3)
    public void checkThatSearchWordIsPresentedInTheFirstArticle() {
        getBasePage().waitVisibilityOfElement(5, getHomePage().getNews());
        getHomePage().clickOnNews();
        actualTab = getNewsPage().getExpectedTextOfTheCoronaVirusTab();
        getHomePage().typeSearchWordAndPressEnter(actualTab);
        expectedHeadlineFirstArticle = getSearchPage().getFirstListOfHeadlineOfSearchArticles();
        Assert.assertTrue(expectedHeadlineFirstArticle.contains(actualTab), "The first headline article " + expectedHeadlineFirstArticle + " doesn't contain actual article " + actualTab + "\n");
    }
}