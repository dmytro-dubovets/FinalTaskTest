package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Form extends AbstractPage {

    private final String name = "* type some NAME *";
    private final String story = "* type some STORY *";

    Map<FormFields, String> fields = new LinkedHashMap<>();
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

    public Form(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCheckBoxes() {
        return getCheckBoxes;
    }

    public Form clickOnCheckBoxOver16() {
        checkboxOver16.click();
        return this;
    }

    public WebElement getTextArea() {
        return textArea;
    }

    public WebElement getInputName() {
        return inputName;
    }

    public Form sendName(String name) {
        getInputName().sendKeys(name + Keys.ENTER);
        return this;
    }

    public Form sendStory(String story) {
        getTextArea().sendKeys(story + Keys.ENTER);
        return this;
    }

    public Form sendNameOrStory(String story, String name) {
        getTextArea().sendKeys(story + Keys.ENTER);
        getInputName().sendKeys(name + Keys.ENTER);
        return this;
    }

    public List<WebElement> getErrorMessages() {
        return errorMessages;
    }

    public Form clickOnSubmitButton() {
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

    public Form clickOnAllCheckBoxes() {
        for (WebElement checkbox : getCheckBoxes()) {
            checkbox.click();
        }
        return this;
    }

    public Form fillForm(FormFields field) {
        setValue(name, story);
        for (Map.Entry<FormFields, String> entry : fields.entrySet()) {
            System.out.println(entry.getValue());
            if (field.equals(FormFields.NAME) && field.equals(entry.getKey())) {
                inputName.sendKeys(entry.getValue());
                break;
            } else if (field.equals(FormFields.STORY) && field.equals(entry.getKey())) {
                textArea.sendKeys(entry.getValue());
                break;
            }
        }
        return new Form(driver);
    }

    public void setValue(String name, String story) {
        fields.put(FormFields.NAME, name);
        fields.put(FormFields.STORY, story);
    }

    public enum FormFields {
        NAME,
        STORY
    }
}
