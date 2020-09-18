package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NewsPage;

public class CheckTheArticle extends CommonConditions {

    @Test
    public void checkTheArticle() {
        String expectedArticle = new HomePage(driver)
                .clickOnNews()
                .getExpectedTextOfTheArticle();
        String actualArticle = "BBC News";
        Assert.assertEquals(expectedArticle, actualArticle, "The expected article " + expectedArticle +
                " is not equal to the actual article " + actualArticle + "\n");
    }
}
