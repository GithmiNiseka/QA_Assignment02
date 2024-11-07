package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class eBookPage  extends BasePage{
    public eBookPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//h4[text()='OrangeHRM 7.15 Enhancing HR with Precision and Efficiency']")
    public WebElement BlogItem;


    public void ViewABlog() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(BlogItem));
        BlogItem.click();
    }
}
