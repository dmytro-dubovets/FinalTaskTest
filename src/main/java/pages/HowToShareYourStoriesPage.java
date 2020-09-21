package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HowToShareYourStoriesPage extends AbstractPage {

    @FindBy(xpath = "//button[@class='button']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='input-error-message']")
    private List<WebElement> errorMessages;

    @FindBy(xpath = "//p[contains(text(), 'I am over 16 years old')]")
    private WebElement checkboxOver16;

    @FindBy(xpath = "//input[@placeholder='Name']")
    private WebElement inputName;

    @FindBy(xpath = "//div[@class='long-text-input-container']/textarea[@class='text-input--long']")
    private WebElement textArea;

    @FindBy(xpath = "//div[@id='orb-modules']//div[@class='checkbox']//input[@type='checkbox']")
    private List<WebElement> getCheckBoxes;

    public HowToShareYourStoriesPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCheckBoxes() {
        return getCheckBoxes;
    }

    public HowToShareYourStoriesPage clickOnCheckBoxOver16() {
        checkboxOver16.click();
        return this;
    }

    public WebElement getTextArea() {
        return textArea;
    }

    public WebElement getInputName() {
        return inputName;
    }

    public HowToShareYourStoriesPage sendName(String name) {
        getInputName().sendKeys(name + Keys.ENTER);
        return this;
    }

    public HowToShareYourStoriesPage sendStory(String story) {
        getTextArea().sendKeys(story + Keys.ENTER);
        return this;
    }

    public HowToShareYourStoriesPage sendNameOrStory(String story, String name) {
        getTextArea().sendKeys(story + Keys.ENTER);
        getInputName().sendKeys(name + Keys.ENTER);
        return this;
    }

    public List<WebElement> getErrorMessages() {
        return errorMessages;
    }

    public HowToShareYourStoriesPage clickOnSubmitButton() {
        submitButton.click();
        return this;
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

    public HowToShareYourStoriesPage clickOnAllCheckBoxes() {
        for (WebElement checkbox : getCheckBoxes()) {
            checkbox.click();
        }
        return this;
    }
}
