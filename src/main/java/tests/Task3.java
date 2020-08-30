package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task3 extends BaseTest {

    @Test(priority = 3)
    public void checkThatSearchWordIsPresented() {
        getHomePage().clickOnNews();
        String coronaVirusActual = getNewsPage().getCoronavirusText();
        getHomePage().typeSearchWordAndPressEnter(getNewsPage().getCoronavirusText());
        String coronaVirusExpected = getSearchPage().getFitstListOfHeadlineOfSearchArticles();
        System.out.println();
        Assert.assertTrue(coronaVirusExpected.contains(coronaVirusActual));
    }
}
