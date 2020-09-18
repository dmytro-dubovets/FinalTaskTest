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
    @FindBy(xpath = "//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']//span[contains(text(),'Coronavirus')]")
    private WebElement coronaVirusTab;
    @FindBy(xpath = "//button[@class='sign_in-exit']")
    private WebElement closeButton;

    public NewsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public NewsPage waitAndClosePopUp() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(closeButton)).click();
        return this;
    }

    public CoronaVirusPage clickOnTheCoronaVirusTab() {
        coronaVirusTab.click();
        return new CoronaVirusPage(driver);
    }

    public String getExpectedTextOfTheCoronaVirusTab() {
        return coronaVirusTab.getText();

    }

    public String getExpectedTextOfTheArticle() {
        return expectedArticle.getText();
    }


    public List<String> stringArrayListOfActualSecondaryArticleTitles() {
        List<String> actualList = new ArrayList<>();
        for (WebElement tab : actualListOfSecondaryArticleTitles) {
            String tabOfList = tab.getText();
            if (tabOfList.length() != 0) {
                actualList.add(tabOfList);
            }
        }
        return actualList;
    }
}