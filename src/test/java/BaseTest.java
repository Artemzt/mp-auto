import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.PageManager;

public class BaseTest {


    protected static final String BASE_URL = "https://my-sandbox.maxpay.com/#/signin";
    protected WebDriver driver;
    protected PageManager pageManager;

    @BeforeClass
    public void initWebDriver() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\AutomationBrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        pageManager = new PageManager(driver);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}