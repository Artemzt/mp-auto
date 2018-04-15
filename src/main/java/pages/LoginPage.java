package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends Page {

    public LoginPage(PageManager pages) {
        super(pages);
    }

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//form[@name='loginForm']//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(id = "login-email-error")
    private WebElement emptyLoginFieldError;

    @FindBy(id = "login-password-error")
    private WebElement emptyPasswordFieldError;

    @FindBy(xpath = "//form[@name='loginForm']//div[@class='alert alert-danger alert-dismissable push-15']")
    private WebElement generalErrorMessage;



    public LoginPage setLogin(String userLogin) {
        loginField.sendKeys(userLogin);
        return this;
    }

    public LoginPage setPassword(String userPassword) {
        passwordField.sendKeys(userPassword);
        return this;
    }

    public LoginPage clearLoginCredentials() {
        loginField.clear();
        passwordField.clear();
        return this;
    }

    public void submitForm() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        //submitButton.click();
    }


    public boolean isValidationErrorDisplayed() {
        return emptyLoginFieldError.isDisplayed() || emptyPasswordFieldError.isDisplayed();
    }

    public boolean isGeneralValidationErrorDisplayed()  {
        return wait.until(ExpectedConditions.visibilityOf(generalErrorMessage)).isDisplayed();

    }
}
