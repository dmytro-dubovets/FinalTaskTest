package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class VerifiesThatUserCanSubmitAQuestionInTheForm extends CommonConditions {
    protected String titleOfHowToShare = "How to share your questions, stories, pictures and videos with BBC News - BBC News";

    @Test
    public void verifiesThatUserCanSubmitAQuestion() {
        HomePage homePage = new HomePage(driver);
        NewsPage newsPage = new NewsPage(driver);
        CoronaVirusPage coronaVirusPage = new CoronaVirusPage(driver);
        CoronaVirusStoriesPage coronaVirusStoriesPage = new CoronaVirusStoriesPage(driver);
        HowToShareYourStoriesPage howToShareYourStoriesPage = new HowToShareYourStoriesPage(driver);

        homePage.waiAndClickOnNews();
        newsPage.clickOnTheCoronaVirusTab();
        coronaVirusPage.clickOnGetStories();
        coronaVirusStoriesPage.clickOnHowToShareYourStories();
        howToShareYourStoriesPage.clickOnSubmitButton();
        boolean errorMessages = howToShareYourStoriesPage.ifErrorsMessagesAreDisplayed();
        Assert.assertTrue(errorMessages, "The error messages like: " + howToShareYourStoriesPage.errorMessages() + " are not displayed");
        boolean title = homePage.ifTitleIsEquals(titleOfHowToShare);
        Assert.assertTrue(title, "The actual title is not equal to the expected title " + titleOfHowToShare);
    }
}
