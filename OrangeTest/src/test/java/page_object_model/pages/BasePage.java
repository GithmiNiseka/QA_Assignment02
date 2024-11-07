package page_object_model.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver = null;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public OrangeHome loadUrl(String url) {   //Returns the relevant page object
        driver.get(url);
        return PageFactory.initElements(driver, OrangeHome.class);
    }
    public void scrollPage(int x, int y) {
        new Actions(driver).scrollByAmount(x, y).perform();
    }

}
