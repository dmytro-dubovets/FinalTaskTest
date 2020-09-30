package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class CoronaVirusStoriesPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(@class,'gel-pica-bold nw-o-link-split__anchor')]")
    private List<WebElement> linksLifeInLockDown;

    public CoronaVirusStoriesPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getLinksLifeInLockDown() {
        return linksLifeInLockDown;
    }

    public Form clickOnHowToShareYourStories() {
        getHowToShareYourStories().click();
        waitForPageLoadComplete(20);
        return new Form(driver);
    }

    private WebElement getHowToShareYourStories() {
        List<WebElement> howToShareYourStories = new ArrayList<>();
        try {
            for (WebElement link : getLinksLifeInLockDown()) {
                if (link.getText().equals("How to share with BBC News")) {
                    howToShareYourStories.add(link);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return howToShareYourStories.get(0);
    }
}
