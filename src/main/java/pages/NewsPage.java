package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class NewsPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'BBC News')]")
    private WebElement expectedArticle;
    @FindBy(xpath = "//ul[@class='gs-o-list-ui--top-no-border nw-c-nav__wide-sections']/li/a/span[1]")
    private List<WebElement> actualListOfSecondaryArticleTitles;
    @FindBy(xpath = "//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']//span[contains(text(),'Coronavirus')]")
    private WebElement coronaVirusTab;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCoronaVirusTab() {
        return coronaVirusTab;
    }

    public WebElement getExpectedArticle() {
        return expectedArticle;
    }

    public List<WebElement> getActualListOfSecondaryArticleTitles() {
        return actualListOfSecondaryArticleTitles;
    }

    public String getExpectedTextOfTheArticle() {
        return getExpectedArticle().getText();
    }

    public String getExpectedTextOfTheCoronaVirusTab() {
        return getCoronaVirusTab().getText();
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