package tests;

import org.testng.annotations.Test;
import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;


public class CheckTextOfTheMainArticle extends BasePage {

    @Test
    public void checkTextOfTheMainArticle() {
        String expectedTextOfTheMainArticle = new HomePage(driver)
                .clickOnNews()
                .getExpectedTextOfTheMainArticle();
        String actualArticle = "BBC News";
        assertThat(actualArticle).isEqualTo(expectedTextOfTheMainArticle);
    }
}
