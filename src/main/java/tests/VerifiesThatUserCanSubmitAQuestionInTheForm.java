package tests;

import driver.DriverFactory;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HowToShareYourStoriesPage;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifiesThatUserCanSubmitAQuestionInTheForm extends DriverFactory {
    private final String titleOfHowToShareStories = "How to share your questions, stories, pictures and videos with BBC News - BBC News";

    @Test
    public void verifiesThatUserCanNotSubmitAQuestion() {
        String actualTitle = new HomePage(driver)
                .clickOnNews()
                .clickOnTheCoronaVirusTab()
                .clickOnGetStories()
                .clickOnHowToShareYourStories()
                .clickOnSubmitButton()
                .getTitle();
        assertThat(actualTitle).isEqualTo(titleOfHowToShareStories);
        boolean errorMessages = new HowToShareYourStoriesPage(driver)
                .ifErrorsMessagesAreDisplayed();
        assertThat(errorMessages).isTrue();
    }

    @Test
    public void verifiesThatUserCanNotSubmitWithOneReqCheckBoxOver16() {
        String actualTitle = new HomePage(driver)
                .clickOnNews()
                .clickOnTheCoronaVirusTab()
                .clickOnGetStories()
                .clickOnHowToShareYourStories()
                .clickOnCheckBoxOver16()
                .clickOnSubmitButton()
                .getTitle();
        assertThat(actualTitle).isEqualTo(titleOfHowToShareStories);
        boolean errorMessages = new HowToShareYourStoriesPage(driver)
                .ifErrorsMessagesAreDisplayed();
        assertThat(errorMessages).isTrue();
    }

    @Test
    public void verifiesThatUserCanNotSubmitWithAllReqCheckBoxesAndNonEmptyName() {
        String INPUT_NAME = "Type some name";
        String actualTitle = new HomePage(driver)
                .clickOnNews()
                .clickOnTheCoronaVirusTab()
                .clickOnGetStories()
                .clickOnHowToShareYourStories()
                .sendName(INPUT_NAME)
                .clickOnAllCheckBoxes()
                .clickOnSubmitButton()
                .getTitle();
        assertThat(actualTitle).isEqualTo(titleOfHowToShareStories);
        boolean errorMessages = new HowToShareYourStoriesPage(driver)
                .ifErrorsMessagesAreDisplayed();
        assertThat(errorMessages).isTrue();
    }

    @Test
    public void verifiesThatUserCanNotSubmitWithAllReqCheckBoxesAndEmptyNameButNonEmptyStory() {
        String INPUT_STORY = "* type some story... *";
        String actualTitle = new HomePage(driver)
                .clickOnNews()
                .clickOnTheCoronaVirusTab()
                .clickOnGetStories()
                .clickOnHowToShareYourStories()
                .sendStory(INPUT_STORY)
                .clickOnAllCheckBoxes()
                .clickOnSubmitButton()
                .getTitle();
        assertThat(actualTitle).isEqualTo(titleOfHowToShareStories);
        boolean errorMessages = new HowToShareYourStoriesPage(driver)
                .ifErrorsMessagesAreDisplayed();
        assertThat(errorMessages).isTrue();
    }
}
