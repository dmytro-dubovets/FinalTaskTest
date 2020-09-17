package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HowToShareYourStoriesPage extends AbstractPage {
    @FindBy(xpath = "//button[@class='button']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[@class='input-error-message']")
    private List<WebElement> errorMessages;
    @FindBy(xpath = "//div[@id='orb-modules']//div[@class='checkbox'][2]//input[@type='checkbox']")
    private WebElement checkboxOver16;
    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement inputName;
    @FindBy(xpath = "//div[@class='long-text-input-container']/textarea[@class='text-input--long']")
    private WebElement textArea;
    @FindBy(xpath = "//div[@id='orb-modules']//div[@class='checkbox']//input[@type='checkbox']")
    private List<WebElement> getCheckBoxes;

    public HowToShareYourStoriesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public List<WebElement> getCheckBoxes() {
        return getCheckBoxes;
    }

    public WebElement getCheckboxOver16() {
        return checkboxOver16;
    }

    public void clickOnCheckBoxOver16() {
        getCheckboxOver16().click();
    }

    public WebElement getTextArea() {
        return textArea;
    }

    public WebElement getInputName() {
        return inputName;
    }

    public void sendName(String name) {
        getInputName().sendKeys(name + Keys.ENTER);
    }

    public void sendStory(String story) {
        getTextArea().sendKeys(story + Keys.ENTER);
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public List<WebElement> getErrorMessages() {
        return errorMessages;
    }

    public void clickOnSubmitButton() {
        getSubmitButton().click();
    }

    public boolean ifErrorsMessagesAreDisplayed() {
        boolean result = false;
        for (WebElement errorMessage : getErrorMessages()) {
            if (errorMessage.isDisplayed()) {
                result = true;
            }
        }
        return result;
    }

    public String errorMessages() {
        List<String> errorMsg = new ArrayList<>();
        for (WebElement errorMessage : getErrorMessages()) {
            String errors = errorMessage.getText();
            errorMsg.add(errors);
        }
        return errorMsg.get(0);
    }

/*    public void clickOnAllCheckBoxes() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (WebElement checkbox : getCheckBoxes()) {
            js.executeScript("arguments[0].click()", checkbox);
        }
    }*/

    public void clickOnAllCheckBoxes() {
        for (WebElement checkbox : getCheckBoxes()) {
            checkbox.click();
        }
    }
}
