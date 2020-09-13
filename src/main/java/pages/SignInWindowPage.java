package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInWindowPage extends AbstractPage {

    public SignInWindowPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//button[@class='sign_in-exit']")
    private WebElement closeButton;

    protected By windowOff = By.xpath("//button[@class='sign_in-exit']");


    public void closePopUp() {
        closeButton.click();
    }


    public SignInWindowPage writeTextMsgIfWindowIsDisplayed(WebElement element) {
        while (element.isDisplayed()) {
            try {
                element.click();
                break;
            } catch (Exception e) {
                e.printStackTrace();
                closePopUp();
            }
        }
        return this;
    }
}
