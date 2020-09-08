package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class NewsPage extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'BBC News')]")
    private WebElement expectedArticle;

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getExpectedArticle() {
        return expectedArticle;
    }

    public String getExpectedTextOfTheArticle() {
        return getExpectedArticle().getText();
    }
}

