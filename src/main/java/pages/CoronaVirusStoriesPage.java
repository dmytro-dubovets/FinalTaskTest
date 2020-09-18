package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CoronaVirusStoriesPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(@class,'gel-pica-bold nw-o-link-split__anchor')]")
    private List<WebElement> linksLifeInLockDown;

    public CoronaVirusStoriesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public List<WebElement> getLinksLifeInLockDown() {
        return linksLifeInLockDown;
    }

    public HowToShareYourStoriesPage clickOnHowToShareYourStories() {
        getHowToShareYourStories().click();
        waitForPageLoadComplete(15);
        return new HowToShareYourStoriesPage(driver);
    }

    private WebElement getHowToShareYourStories() {
        List<WebElement> howToShare = new ArrayList<>();
        try {
            for (WebElement link : getLinksLifeInLockDown()) {
                if (link.getText().equals("How to share with BBC News")) {
                    howToShare.add(link);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return howToShare.get(0);
    }
}
