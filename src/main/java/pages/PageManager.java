package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageManager {

    protected WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
        loginPage = initializePageObjects(new LoginPage(this));
        homePage = initializePageObjects(new HomePage(this));

    }


    private <T extends Page> T initializePageObjects(T page) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), page);
        return page;
    }

    public WebDriver getWebDriver() {
        return driver;
    }


}
