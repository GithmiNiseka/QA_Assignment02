package page_object_model.pages;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class OrangeHome extends BasePage {
    public WebDriverWait wait;


    public OrangeHome(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[@src='/public/_resources/themes/orangehrm/dist/images/OrangeHRM_Logo.svg']")
    public WebElement LogoImg;

    @FindBy(xpath = "//select[@name='locale']")
    public WebElement SelectLanguageBox;

    String visibleText = "";

    public void SelectLanguage(String visibleText) {
        this.visibleText = visibleText;
        new Select(SelectLanguageBox).selectByVisibleText                                                                                                                                                            (visibleText);
    }

    @FindBy(xpath = "//a[text()='Resources']")
    public WebElement ResourceOption;

    @FindBy(xpath = "//a[@href='/en/resources/blog']")
    public WebElement BlogOption;

    @FindBy(xpath = "//a[@href='/en/resources/e-books']")
    public WebElement eBookOption;

    public void SelectResources() {

        ResourceOption.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(BlogOption));
        BlogOption.click();
    }

    public void FindeBook() {

        ResourceOption.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(eBookOption));
        eBookOption.click();
    }



    @FindBy(xpath = "//iframe[@id='694669293']")
    public WebElement VideoElement;

    public void scrollToVideoIframe() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", VideoElement);
    }

    public void switchToVideoIframe() {
        driver.switchTo().frame(VideoElement);
    }

    public void clickVideoToPlay() {
        VideoElement.click();
    }

    public void switchBackFromIframe() {
        driver.switchTo().defaultContent();
    }



    @FindBy(xpath = "//input[@id='Form_submitForm_action_request']")
    public WebElement TrialButton;


    public void FreeTiarlRegister() {
        TrialButton.click();
    }

}


