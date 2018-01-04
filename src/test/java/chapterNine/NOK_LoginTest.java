package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class NOK_LoginTest extends TestShopScenario {
    String email = "maikel.bruin@polteq.com";
    String pwd = "bootcamp";
    String pwdWrong = "lalalal";

    @Test
    public void wrongAuthenticationTest() {
        LoginPage loginPage = new LoginPage(driver);
        String expectedErrorMessage = "Authentication failed.";


        if (loginPage.isLoggedOut() == false) {
            loginPage.doLogout();
        }

        String actualErrorMessage = loginPage.doNOKLogin(email, pwdWrong);

        //Assertions
        Assertions.assertThat(actualErrorMessage)
                .as("Error message is niet zoals verwacht!").contains(expectedErrorMessage);
    }

    @Test
    public void wrongEmailFormatTest() {
        HomePage homePage = new HomePage(driver);
        homePage.toLoginPage();

        LoginPage loginPage = new LoginPage(driver);

        if (loginPage.isLoggedOut() == false) {
            loginPage.doLogout();
        }

        String emailWrongFormat = "lalala";

        Boolean formErrorMessage = loginPage.doNOKEmail(emailWrongFormat);

        //Assertions
        Assertions.assertThat(formErrorMessage)
                .as("Error message niet getoond!").isTrue();
    }

    @Test
    public void emptyPasswordTest() {
        HomePage homePage = new HomePage(driver);
        homePage.toLoginPage();

        LoginPage loginPage = new LoginPage(driver);

        if (loginPage.isLoggedOut() == false) {
            loginPage.doLogout();
        }

        String expectedErrorMessage = "Password is required.";
        String actualErrorMessage = loginPage.doNOKLogin(email, "");

        //Assertions
        Assertions.assertThat(actualErrorMessage)
                .as("Error message is not as expected!").contains(expectedErrorMessage);
    }

    @Test
    public void emptyEmailTest() {
        HomePage homePage = new HomePage(driver);
        homePage.toLoginPage();

        LoginPage loginPage = new LoginPage(driver);

        if (loginPage.isLoggedOut() == false) {
            loginPage.doLogout();
        }

        String expectedErrorMessage = "An email address required.";
        String actualErrorMessage = loginPage.doNOKLogin("", "");

        //Assertions
        Assertions.assertThat(actualErrorMessage)
                .as("Error message is not as expected!").contains(expectedErrorMessage);
    }

    @Test
    public void tooShortPwdTest() {
        HomePage homePage = new HomePage(driver);
        homePage.toLoginPage();

        LoginPage loginPage = new LoginPage(driver);

        if (loginPage.isLoggedOut() == false) {
            loginPage.doLogout();
        }

        String shortPwd = "1234";
        Boolean formErrorMessage = loginPage.doNOKPwd(email,shortPwd);

        //Assertions
        Assertions.assertThat(formErrorMessage)
                .as("Error message niet getoond!").isTrue();
    }

    @Test
    public void nonExistentUserTest() {
        HomePage homePage = new HomePage(driver);
        homePage.toLoginPage();

        LoginPage loginPage = new LoginPage(driver);

        if (loginPage.isLoggedOut() == false) {
            loginPage.doLogout();
        }


    }
}
