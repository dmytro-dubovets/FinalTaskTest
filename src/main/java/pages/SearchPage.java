package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='css-l100ew-PromoContentSummary ett16tt10']/p/a")
    private List<WebElement> headlineOfSearchArticle;

    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return actualListOfArticles.get(0);
    }
}