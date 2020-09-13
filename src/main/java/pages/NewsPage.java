package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class NewsPage extends AbstractPage {

    @FindBy(xpath = "//span[contains(text(),'BBC News')]")
    private WebElement expectedArticle;
    @FindBy(xpath = "//ul[@class='gs-o-list-ui--top-no-border nw-c-nav__wide-sections']/li/a/span[1]")
    private List<WebElement> actualListOfSecondaryArticleTitles;


    public WebElement getCoronaVirusTab() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(coronaVirusTab));
        return coronaVirusTab;
    }

    @FindBy(xpath = "//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']//span[contains(text(),'Coronavirus')]")
    private WebElement coronaVirusTab;

    public NewsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    public NewsPage clickOnTheCoronaVirusTab() {
        coronaVirusTab.click();
        return this;
    }
    public String getExpectedTextOfTheCoronaVirusTab() {
        return coronaVirusTab.getText();

    }
    public List<WebElement> getActualListOfSecondaryArticleTitles() {
        return actualListOfSecondaryArticleTitles;
    }

    public String getExpectedTextOfTheArticle() {
        return expectedArticle.getText();
    }


    public ArrayList<String> stringArrayListOfActualSecondaryArticleTitles() {
        ArrayList<String> actualList = new ArrayList<>();
        for (WebElement tab : getActualListOfSecondaryArticleTitles()) {
            String tabOfList = tab.getText();
            if (tabOfList.length() != 0) {
                actualList.add(tabOfList);
            }
        }
        return actualList;
    }
}