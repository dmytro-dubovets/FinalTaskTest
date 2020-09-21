package tests;

import driver.DriverFactory;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;


public class CheckTheArticle extends DriverFactory {

    @Test
    public void checkTheArticle() {
        String expectedArticle = new HomePage(driver)
                .clickOnNews()
                .getExpectedTextOfTheArticle();
        String actualArticle = "BBC News";
        assertThat(actualArticle).isEqualTo(expectedArticle);
    }
}
