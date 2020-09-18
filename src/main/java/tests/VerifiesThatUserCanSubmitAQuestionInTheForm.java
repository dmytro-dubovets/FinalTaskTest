package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class VerifiesThatUserCanSubmitAQuestionInTheForm extends CommonConditions {
    protected String titleOfHowToShare = "How to share your questions, stories, pictures and videos with BBC News - BBC News";
    protected String INPUT_NAME = "  123";
    protected String INPUT_STORY = "  gkrgkerger";

    @Test
    public void verifiesThatUserCanSubmitAQuestion() {
        /*HomePage homePage = new HomePage(driver);
        NewsPage newsPage = new NewsPage(driver);
        CoronaVirusPage coronaVirusPage = new CoronaVirusPage(driver);
        CoronaVirusStoriesPage coronaVirusStoriesPage = new CoronaVirusStoriesPage(driver);*/
        /*HowToShareYourStoriesPage howToShareYourStoriesPage = new HowToShareYourStoriesPage(driver);*/
        new HomePage(driver)
                .clickOnNews()
                .waitAndClosePopUp()
                .clickOnTheCoronaVirusTab()
                .clickOnGetStories()
                .waitForPageLoadComplete(15)
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
        HomePage homePage = new HomePage(driver);
        NewsPage newsPage = new NewsPage(driver);
        CoronaVirusPage coronaVirusPage = new CoronaVirusPage(driver);
        CoronaVirusStoriesPage coronaVirusStoriesPage = new CoronaVirusStoriesPage(driver);
        HowToShareYourStoriesPage howToShareYourStoriesPage = new HowToShareYourStoriesPage(driver);
        homePage.clickOnNews();
        newsPage.waitAndClosePopUp();
        newsPage.clickOnTheCoronaVirusTab();
        coronaVirusPage.clickOnGetStories();
        homePage.waitForPageLoadComplete(15);
        coronaVirusStoriesPage.clickOnHowToShareYourStories();
        howToShareYourStoriesPage.clickOnCheckBoxOver16();
        howToShareYourStoriesPage.clickOnSubmitButton();
        boolean errorMessages = howToShareYourStoriesPage.ifErrorsMessagesAreDisplayed();
        Assert.assertTrue(errorMessages, "The error messages like: " + howToShareYourStoriesPage.errorMessages() + " are not displayed");
        boolean title = homePage.isTitleEquals(titleOfHowToShare);
        Assert.assertTrue(title, "The actual title is not equal to the expected title " + titleOfHowToShare);
    }

    @Test
    public void verifiesThatUserCanNotSubmitWithAllReqCheckBoxesAndNonEmptyName() {
        HomePage homePage = new HomePage(driver);
        NewsPage newsPage = new NewsPage(driver);
        CoronaVirusPage coronaVirusPage = new CoronaVirusPage(driver);
        CoronaVirusStoriesPage coronaVirusStoriesPage = new CoronaVirusStoriesPage(driver);
        HowToShareYourStoriesPage howToShareYourStoriesPage = new HowToShareYourStoriesPage(driver);
        homePage.clickOnNews();
        newsPage.waitAndClosePopUp();
        newsPage.clickOnTheCoronaVirusTab();
        coronaVirusPage.clickOnGetStories();
        homePage.waitForPageLoadComplete(15);
        coronaVirusStoriesPage.clickOnHowToShareYourStories();
        howToShareYourStoriesPage.sendName(INPUT_NAME);
        howToShareYourStoriesPage.clickOnAllCheckBoxes();
        howToShareYourStoriesPage.clickOnSubmitButton();
        boolean errorMessages = howToShareYourStoriesPage.ifErrorsMessagesAreDisplayed();
        Assert.assertTrue(errorMessages, "The error messages like: " + howToShareYourStoriesPage.errorMessages() + " are not displayed");
        boolean title = homePage.isTitleEquals(titleOfHowToShare);
        Assert.assertTrue(title, "The actual title is not equal to the expected title " + titleOfHowToShare);
    }

    @Test
    public void verifiesThatUserCanNotSubmitWithAllReqCheckBoxesAndEmptyNameButNonEmptyStory() {
        HomePage homePage = new HomePage(driver);
        NewsPage newsPage = new NewsPage(driver);
        CoronaVirusPage coronaVirusPage = new CoronaVirusPage(driver);
        CoronaVirusStoriesPage coronaVirusStoriesPage = new CoronaVirusStoriesPage(driver);
        HowToShareYourStoriesPage howToShareYourStoriesPage = new HowToShareYourStoriesPage(driver);
        homePage.clickOnNews();
        newsPage.waitAndClosePopUp();
        newsPage.clickOnTheCoronaVirusTab();
        coronaVirusPage.clickOnGetStories();
        homePage.waitForPageLoadComplete(15);
        coronaVirusStoriesPage.clickOnHowToShareYourStories();
        howToShareYourStoriesPage.sendStory(INPUT_STORY);
        howToShareYourStoriesPage.clickOnAllCheckBoxes();
        howToShareYourStoriesPage.clickOnSubmitButton();
        boolean errorMessages = howToShareYourStoriesPage.ifErrorsMessagesAreDisplayed();
        Assert.assertTrue(errorMessages, "The error messages like: " + howToShareYourStoriesPage.errorMessages() + " are not displayed");
        boolean title = homePage.isTitleEquals(titleOfHowToShare);
        Assert.assertTrue(title, "The actual title is not equal to the expected title " + titleOfHowToShare);
    }
}
