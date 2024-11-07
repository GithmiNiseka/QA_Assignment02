package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TrialRegisterPage extends BasePage {
    private WebDriverWait wait;

    public TrialRegisterPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//input[@id='Form_getForm_subdomain']")
    public WebElement subDomain;

    @FindBy(xpath = "//input[@id='Form_getForm_Name_Holder']")
    public WebElement FName;

    @FindBy(xpath = "//input[@id='Form_getForm_Email_Holder']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='Form_getForm_Contact_Holder']")
    public WebElement contact;

    @FindBy(xpath = "//input[@id='Form_getForm_Country_Holder']")
    public WebElement selectOption;

    @FindBy(xpath = "//input[@id='Form_getForm_action_submitForm']")
    public WebElement submitButton;

    public void fillForm(String subdomainData, String fNameData, String emailData, String contactData, String countryData) {
        wait.until(ExpectedConditions.visibilityOf(subDomain));
        subDomain.sendKeys(subdomainData);
        Assert.assertEquals(subDomain.getAttribute("value"), subdomainData);

        wait.until(ExpectedConditions.visibilityOf(FName));
        FName.sendKeys(fNameData);
        Assert.assertEquals(FName.getAttribute("value"), fNameData);

        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys(emailData);
        Assert.assertEquals(email.getAttribute("value"), emailData);

        wait.until(ExpectedConditions.visibilityOf(contact));
        contact.sendKeys(contactData);
        Assert.assertEquals(contact.getAttribute("value"), contactData);

        wait.until(ExpectedConditions.visibilityOf(selectOption));
        selectOption.sendKeys(countryData);
        Assert.assertEquals(selectOption.getAttribute("value"), countryData);

        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }
}
