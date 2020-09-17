package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewsPage;
import pages.SearchPage;
import pages.SignInWindowPage;

public class CheckTheCategoryLinkOfTheFirstHeadlineArticle extends CommonConditions {

    @Test
    public void checkThatSearchWordIsPresentedInTheFirstArticle() {
        HomePage homePage = new HomePage(driver);
        NewsPage newsPage = new NewsPage(driver);
        SignInWindowPage signInWindowPage = new SignInWindowPage(driver);
        homePage.clickOnNews();
        signInWindowPage.waitAndClosePopUp();
        String actualTab = newsPage.getExpectedTextOfTheCoronaVirusTab();
        homePage.typeSearchWordAndPressEnter(actualTab);
        String expectedHeadlineFirstArticle = new SearchPage(driver)
                .getFirstListOfHeadlineOfSearchArticles();
        Assert.assertTrue(expectedHeadlineFirstArticle.contains(actualTab), "The first headline article " + expectedHeadlineFirstArticle + " doesn't contain actual article " + actualTab + "\n");
    }
}