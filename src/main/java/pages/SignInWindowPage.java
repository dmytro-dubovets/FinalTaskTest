package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInWindowPage extends AbstractPage {
    protected WebDriverWait wait;

    public SignInWindowPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//button[@class='sign_in-exit']")
    private WebElement closeButton;

    public void waitAndClosePopUp() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(closeButton)).click();
    }
}
