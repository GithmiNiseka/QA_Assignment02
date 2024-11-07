package page_object_model.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Utilities {
    // WebDriver driver;
    protected BrowserFactory browserFactory;

    @BeforeTest   //Run only once for entire test.    //@BeforeMethod- Run before each testcase
    public void initializeBrowser () {
         browserFactory =BrowserFactory.getBrowserFactory();

        //initialize browser
        //driver = WebDriverManager.firefoxdriver().create();
        //driver = new ChromeDriver(); //if we directly create a Driver
        //driver = WebDriverManager.chromedriver().create(); //if we use Web Driver Manager
        browserFactory.getDriver().manage().window().maximize();
//
    }
    @AfterTest
    public void closeBrowser () {
        // browserFactory.getDriver().quit();
        //driver.close();
    }
}
