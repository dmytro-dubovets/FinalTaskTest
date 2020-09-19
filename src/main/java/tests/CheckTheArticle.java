package tests;

import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;


public class CheckTheArticle extends DriverFactory {

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
