package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewsPage extends BasePage {
    public NewsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text(),'BBC News')]")
    private WebElement bbcNewsText;

    @FindBy(xpath = "//ul[@class='gs-o-list-ui--top-no-border nw-c-nav__wide-sections']/li/a/span[1]")
    private List<WebElement> listOfTabs;

    @FindBy(xpath = "//li[@class='gs-o-list-ui__item--flush gel-long-primer gs-u-display-block gs-u-float-left nw-c-nav__wide-menuitem-container']//span[contains(text(),'Coronavirus')]")
    private WebElement coronaVirus;

    public List<WebElement> getListOfTabs() {
        return listOfTabs;
    }

    public String getBBCNewsText() {
        return bbcNewsText.getText();
    }

    public String getCoronavirusText() {
        return coronaVirus.getText();
    }

    public ArrayList<String> ListOfTabs() {
        ArrayList<String> actualList = new ArrayList<String>();
        for (WebElement tab : getListOfTabs()) {
            String tabOfList = tab.getText();
            if(tabOfList.length() != 0) {
                actualList.add(tabOfList);
            }
        }
        return actualList;
    }


    public ArrayList<String> getExpectedList(String[] listExpected) {
        ArrayList<String> expectedList = new ArrayList<String>(Arrays.asList(listExpected));
        return expectedList;
    }

}

