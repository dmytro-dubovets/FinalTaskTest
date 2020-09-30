package tests;

import org.testng.annotations.Test;
import pages.Form;
import pages.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifiesThatUserCanSubmitAQuestionInTheForm extends BasePage {
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
        boolean errorMessages = new Form(driver)
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
        boolean errorMessages = new Form(driver)
                .ifErrorsMessagesAreDisplayed();
        assertThat(errorMessages).isTrue();
    }

    @Test
    public void verifiesThatUserCanNotSubmitWithAllReqCheckBoxesAndNonEmptyName() {
        String actualTitle = new HomePage(driver)
                .clickOnNews()
                .clickOnTheCoronaVirusTab()
                .clickOnGetStories()
                .clickOnHowToShareYourStories()
                .fillForm(Form.FormFields.NAME)
                .clickOnAllCheckBoxes()
                .clickOnSubmitButton()
                .getTitle();
        assertThat(actualTitle).isEqualTo(titleOfHowToShareStories);
        boolean errorMessages = new Form(driver)
                .ifErrorsMessagesAreDisplayed();
        assertThat(errorMessages).isTrue();
    }

    @Test
    public void verifiesThatUserCanNotSubmitWithAllReqCheckBoxesAndEmptyNameButNonEmptyStory() {
        String actualTitle = new HomePage(driver)
                .clickOnNews()
                .clickOnTheCoronaVirusTab()
                .clickOnGetStories()
                .clickOnHowToShareYourStories()
                .fillForm(Form.FormFields.STORY)
                .clickOnAllCheckBoxes()
                .clickOnSubmitButton()
                .getTitle();
        assertThat(actualTitle).isEqualTo(titleOfHowToShareStories);
        boolean errorMessages = new Form(driver)
                .ifErrorsMessagesAreDisplayed();
        assertThat(errorMessages).isTrue();
    }
}
