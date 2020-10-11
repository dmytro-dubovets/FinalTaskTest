package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(css = "p > a > span")
    private List<WebElement> headlineOfSearchArticle;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstListOfHeadlineOfSearchArticles() {
        List<String> actualListOfArticles = new ArrayList<>();
        for (WebElement article : headlineOfSearchArticle) {
            String headlineTextArticle = article.getText();
            try {
                if (headlineTextArticle == null) {
                    break;
                } else {
                    actualListOfArticles.add(headlineTextArticle);
                }
            } catch (NullPointerException | IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        return actualListOfArticles.get(0);
    }
}