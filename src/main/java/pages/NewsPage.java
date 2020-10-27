package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class NewsPage extends AbstractPage {

    @FindBy(xpath = "//span[contains(text(),'BBC News')]")
    private WebElement expectedArticle;

    @FindBy(xpath = "//ul[@class='gs-o-list-ui--top-no-border nw-c-nav__wide-sections']/li/a/span[1]")
    private List<WebElement> actualListOfSecondaryArticleTitles;

    @FindBy(xpath = "//li[contains(@class,'nw-c-nav__wide-menuitem-container')]//span[contains(text(),'Coronavirus')]")
    private WebElement coronaVirusTab;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public CoronaVirusPage clickOnTheCoronaVirusTab() {
        coronaVirusTab.click();
        waitForPageLoadComplete(20);
        return new CoronaVirusPage(driver);
    }

    public String getExpectedTextOfTheCoronaVirusTab() {
        return coronaVirusTab.getText();
    }

    public String getExpectedTextOfTheMainArticle() {
        return expectedArticle.getText();
    }
    
    public List<String> stringArrayListOfActualSecondaryArticleTitles() {
        return actualListOfSecondaryArticleTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}