package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewsPage;
import pages.SignInWindowPage;

public class CheckTheArticle extends CommonConditions {
    protected String actualArticle = "BBC News";

    @Test
    public void checkTheArticle() {
        HomePage homePage = new HomePage(driver);
        SignInWindowPage signInWindowPage = new SignInWindowPage(driver);
        homePage.clickOnNews();
        signInWindowPage.waitAndClosePopUp();
        String expectedArticle = new NewsPage(driver)
                .getExpectedTextOfTheArticle();
        Assert.assertEquals(expectedArticle, actualArticle, "The expected article " + expectedArticle + " is not equal to the actual article " + actualArticle + "\n");
    }
}
