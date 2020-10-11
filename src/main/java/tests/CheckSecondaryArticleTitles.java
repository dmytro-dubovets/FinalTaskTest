package tests;

import org.testng.annotations.Test;
import pages.HomePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckSecondaryArticleTitles extends BasePage {

    private final List<String> listOfExpectedArticleTitles = new ArrayList<>(Arrays.asList(
            "Home", "US Election", "Coronavirus", "Video", "World",
            "UK", "Business", "Tech", "Science", "Stories", "Entertainment & Arts",
            "Health", "World News TV", "In Pictures"));

    @Test
    public void checkSecondaryArticles() {
        List<String> actualSecondaryArticleTitles = new HomePage(driver)
                .clickOnNews()
                .stringArrayListOfActualSecondaryArticleTitles();
        assertThat(actualSecondaryArticleTitles).isEqualTo(listOfExpectedArticleTitles);
    }
}
