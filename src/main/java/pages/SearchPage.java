package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends AbstractPage {


    @FindBy(xpath = "//div[@class='css-l100ew-PromoContentSummary ett16tt10']/p/a")
    private List<WebElement> headlineOfSearchArticle;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getHeadlineOfSearchArticle() {
        return headlineOfSearchArticle;
    }

    public String getFirstListOfHeadlineOfSearchArticles() {
        ArrayList<String> actualListOfArticles = new ArrayList<>();

        for (WebElement article : getHeadlineOfSearchArticle()) {
            String headlineTextArticle = article.getText();
            try {
                if (headlineTextArticle == null) {
                    break;
                } else {
                    actualListOfArticles.add(headlineTextArticle);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return actualListOfArticles.get(0);
    }
}