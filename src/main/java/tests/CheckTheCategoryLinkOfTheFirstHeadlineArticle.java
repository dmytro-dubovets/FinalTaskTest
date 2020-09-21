package tests;

import driver.DriverFactory;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;

import static org.assertj.core.api.Assertions.assertThat;


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
        assertThat(expectedHeadlineFirstArticle).contains(actualTab);
    }
}
