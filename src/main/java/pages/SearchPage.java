package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//div[@class='css-l100ew-PromoContentSummary ett16tt10']/p/a")
    private List<WebElement> headlineOfSearchArticle;

    public List<WebElement> getHeadlineOfSearchArticle() {
        return headlineOfSearchArticle;
    }

    public String getFitstListOfHeadlineOfSearchArticles() {
        ArrayList<String> actualListOfArticles = new ArrayList<>();

        for (WebElement article: getHeadlineOfSearchArticle()) {
            String headlineTextArticle = article.getText();
            if (headlineTextArticle == null) {
                break;
            }
            actualListOfArticles.add(headlineTextArticle);
        }
        return actualListOfArticles.get(0);
    }
}
