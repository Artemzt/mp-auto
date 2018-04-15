package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {
    public HomePage(PageManager pages) {
        super(pages);
    }

    @FindBy(id = "setting")
    private WebElement settingsButton;

    public boolean isUserLoggedIn() {
       return settingsButton.isDisplayed();
    }


}
