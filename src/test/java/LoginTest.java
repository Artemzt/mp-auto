import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void loginWithEmptyFieldsTest() {
        pageManager.loginPage
                .submitForm();

        Assert.assertTrue(pageManager.loginPage.isValidationErrorDisplayed());
    }

    @Test
    public void loginWithInvalidDataTest() {
        pageManager.loginPage
                .setLogin("test_26@test.com")
                .setPassword("Password1")
                .submitForm();

        Assert.assertTrue(pageManager.loginPage.isGeneralValidationErrorDisplayed());
    }

   @Test
    public void successLoginTest() {
        pageManager.loginPage
                .clearLoginCredentials()
                .setLogin("test_27@test.com")
                .setPassword("Password1")
                .submitForm();

        Assert.assertTrue(pageManager.homePage.isUserLoggedIn());
    }
}
