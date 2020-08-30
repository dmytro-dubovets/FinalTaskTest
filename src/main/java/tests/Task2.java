package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2 extends BaseTest{
    private static final String[] LIST_OF_TABS_EXPECTED = new String[] {"Home", "US Election", "Coronavirus", "Video", "World", "UK", "Business", "Tech", "Science", "Stories", "Entertainment & Arts", "Health", "World News TV", "In Pictures"};

    @Test(priority = 2)
    public void checkOtherArticle() {
        getHomePage().clickOnNews();
        Assert.assertEquals(getNewsPage().getExpectedList(LIST_OF_TABS_EXPECTED), getNewsPage().ListOfTabs());
    }
}
