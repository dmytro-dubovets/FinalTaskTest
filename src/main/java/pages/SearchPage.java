package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchPage extends AbstractPage {

    @FindBy(css = "p > a > span")
    private List<WebElement> headlineOfSearchArticle;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstListOfHeadlineOfSearchArticles() {
        return headlineOfSearchArticle.stream().map(WebElement::getText)
                .findFirst()
                .orElse(null);

    }
}