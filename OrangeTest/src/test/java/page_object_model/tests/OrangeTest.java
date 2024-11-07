package page_object_model.tests;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_object_model.pages.*;
import page_object_model.utilities.Utilities;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class OrangeTest  extends Utilities {
    public WebDriver driver;
    @Test
    public void SearchLogo() throws InterruptedException {
        //BasePage basePage = new BasePage(driver);
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        OrangeHome homePage = basePage.loadUrl("https://www.orangehrm.com/");

        Assert.assertTrue(homePage.LogoImg.isDisplayed());
        Thread.sleep(5000);

    }

    @Test
    public void ChangeLanguage() throws InterruptedException {
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        OrangeHome homePage = basePage.loadUrl("https://www.orangehrm.com/");

        homePage.SelectLanguage("Es");
        Thread.sleep(5000);
    }

    @Test
    public void ViewBlogs() throws InterruptedException {
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        OrangeHome homePage = basePage.loadUrl("https://www.orangehrm.com/");

        homePage.SelectResources();
        eBookPage blogpage = PageFactory.initElements(browserFactory.getDriver(), eBookPage.class);
        blogpage.ViewABlog();
        Thread.sleep(5000);
    }

    @Test(dataProvider = "excelData")
    public void registerForTrial(String subdomain, String fName, String email, String contact, String country) throws InterruptedException {
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        OrangeHome homePage = basePage.loadUrl("https://www.orangehrm.com/");
        homePage.FreeTiarlRegister();
        TrialRegisterPage registerPage = PageFactory.initElements(browserFactory.getDriver(), TrialRegisterPage.class);
        registerPage.fillForm(subdomain, fName, email, contact, country);
        Thread.sleep(30000);
    }

    @DataProvider(name = "excelData")
    public Object[][] getExcelData() throws IOException, InvalidFormatException {
        String filePath = "C:\\Users\\ASUS\\Downloads\\RegisterPage.xlsx";
        return ReadExcelFile.getTestData(filePath, "Sheet1");
    }



    @Test
    public void testVideoPlaying() throws InterruptedException {
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        OrangeHome homePage = basePage.loadUrl("https://www.orangehrm.com/");

        homePage.scrollToVideoIframe();

        homePage.switchToVideoIframe();
        homePage.clickVideoToPlay();
        homePage.switchBackFromIframe();

        // Wait a moment to ensure scrolling has happened
        Thread.sleep(5000);


    }

    @Test
    public void VieweBooks() throws InterruptedException {
        BasePage basePage = PageFactory.initElements(browserFactory.getDriver(), BasePage.class);
        OrangeHome homePage = basePage.loadUrl("https://www.orangehrm.com/");

        homePage.FindeBook();
        BlogPage ebookpage = PageFactory.initElements(browserFactory.getDriver(), BlogPage.class);
        ebookpage.scrollPage(0, 200);
        Thread.sleep(5000);
    }
}


