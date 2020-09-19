package tests;

import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewsPage;
import pages.SearchPage;

public class CheckTheCategoryLinkOfTheFirstHeadlineArticle extends DriverFactory {

    @Test
    public void checkThatSearchWordIsPresentedInTheFirstArticle() {
        String actualTab = new HomePage(driver)
                .clickOnNews()
                .getExpectedTextOfTheCoronaVirusTab();
        new HomePage(driver)
                .typeSearchWordAndPressEnter(actualTab);
        String expectedHeadlineFirstArticle = new SearchPage(driver)
                .getFirstListOfHeadlineOfSearchArticles();
        Assert.assertTrue(expectedHeadlineFirstArticle.contains(actualTab), "The first headline article " +
                expectedHeadlineFirstArticle + " doesn't contain actual article " + actualTab + "\n");
    }
}
