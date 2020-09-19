package tests;

import driver.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HowToShareYourStoriesPage;

public class VerifiesThatUserCanSubmitAQuestionInTheForm extends DriverFactory {
    private final String titleOfHowToShare = "How to share your questions, stories, pictures and videos with BBC News - BBC News";

    @Test
    public void verifiesThatUserCanNotSubmitAQuestion() {
        new HomePage(driver)
                .clickOnNews()
                .clickOnTheCoronaVirusTab()
                .clickOnGetStories()
                .clickOnHowToShareYourStories()
                .clickOnSubmitButton();
        boolean errorMessages = new HowToShareYourStoriesPage(driver)
                .ifErrorsMessagesAreDisplayed();
        Assert.assertTrue(errorMessages, "The error messages like: " + new HowToShareYourStoriesPage(driver)
                .errorMessages() + " are not displayed");
        boolean title = new HomePage(driver)
                .isTitleEquals(titleOfHowToShare);
        Assert.assertTrue(title, "The actual title is not equal to the expected title " + titleOfHowToShare);
    }

    @Test
    public void verifiesThatUserCanNotSubmitWithOneReqCheckBoxOver16() {
        new HomePage(driver)
                .clickOnNews()
                .clickOnTheCoronaVirusTab()
                .clickOnGetStories()
                .clickOnHowToShareYourStories()
                .clickOnCheckBoxOver16()
                .clickOnSubmitButton();
        boolean errorMessages = new HowToShareYourStoriesPage(driver)
                .ifErrorsMessagesAreDisplayed();
        Assert.assertTrue(errorMessages, "The error messages like: " + new HowToShareYourStoriesPage(driver)
                .errorMessages() + " are not displayed");
        boolean title = new HomePage(driver)
                .isTitleEquals(titleOfHowToShare);
        Assert.assertTrue(title, "The actual title is not equal to the expected title " + titleOfHowToShare);
    }

    @Test(enabled = false)
    public void verifiesThatUserCanNotSubmitWithAllReqCheckBoxesAndNonEmptyName() {
        String INPUT_NAME = "  123";
        new HomePage(driver)
                .clickOnNews()
                .clickOnTheCoronaVirusTab()
                .clickOnGetStories()
                .clickOnHowToShareYourStories()
                .sendName(INPUT_NAME)
                .clickOnAllCheckBoxes()
                .clickOnSubmitButton();
        boolean errorMessages = new HowToShareYourStoriesPage(driver)
                .ifErrorsMessagesAreDisplayed();
        Assert.assertTrue(errorMessages, "The error messages like: " + new HowToShareYourStoriesPage(driver)
                .errorMessages() + " are not displayed");
        boolean title = new HomePage(driver)
                .isTitleEquals(titleOfHowToShare);
        Assert.assertTrue(title, "The actual title is not equal to the expected title " + titleOfHowToShare);
    }

    @Test(enabled = false)
    public void verifiesThatUserCanNotSubmitWithAllReqCheckBoxesAndEmptyNameButNonEmptyStory() {
        String INPUT_STORY = "  gkrgkerger";
        new HomePage(driver)
                .clickOnNews()
                .clickOnTheCoronaVirusTab()
                .clickOnGetStories()
                .clickOnHowToShareYourStories()
                .sendStory(INPUT_STORY)
                .clickOnAllCheckBoxes()
                .clickOnSubmitButton();
        boolean errorMessages = new HowToShareYourStoriesPage(driver)
                .ifErrorsMessagesAreDisplayed();
        Assert.assertTrue(errorMessages, "The error messages like: " + new HowToShareYourStoriesPage(driver)
                .errorMessages() + " are not displayed");
        boolean title = new HomePage(driver)
                .isTitleEquals(titleOfHowToShare);
        Assert.assertTrue(title, "The actual title is not equal to the expected title " + titleOfHowToShare);
    }
}
