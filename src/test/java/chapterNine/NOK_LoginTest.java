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


    @Test
    public void wrongAuthenticationTest() {
        LoginPage loginPage = init();

        //Define variables and expected/actual outcomes
        String pwdWrong = "lalalal";
        String actualErrorMessage = loginPage.doNOKLogin(email, pwdWrong);
        String expectedErrorMessage = "Authentication failed.";

        //Assertions
        Assertions.assertThat(actualErrorMessage)
                .as("Error message is niet zoals verwacht!").contains(expectedErrorMessage);
    }

    @Test
    public void wrongEmailFormatTest() {
        //Init
        LoginPage loginPage = init();

        //Define variables and expected/actual outcomes
        String emailWrongFormat = "lalala";

        Boolean formErrorMessage = loginPage.doNOKEmail(emailWrongFormat);

        //Assertions
        Assertions.assertThat(formErrorMessage)
                .as("Error message niet getoond!").isTrue();
    }

    @Test
    public void emptyPasswordTest() {
        //Init
        LoginPage loginPage = init();

        //Define variables and expected/actual outcomes
        String expectedErrorMessage = "Password is required.";
        String actualErrorMessage = loginPage.doNOKLogin(email, "");

        //Assertions
        Assertions.assertThat(actualErrorMessage)
                .as("Error message is not as expected!").contains(expectedErrorMessage);
    }

    @Test
    public void emptyEmailTest() {
        //Init
        LoginPage loginPage = init();

        //Define variables and expected/actual outcomes
        String expectedErrorMessage = "An email address required.";
        String actualErrorMessage = loginPage.doNOKLogin("", "");

        //Assertions
        Assertions.assertThat(actualErrorMessage)
                .as("Error message is not as expected!").contains(expectedErrorMessage);
    }

    @Test
    public void tooShortPwdTest() {
        //Init
        LoginPage loginPage = init();

        //Define variables and expected/actual outcomes
        String shortPwd = "1234";
        Boolean formErrorMessage = loginPage.doNOKPwd(email,shortPwd);

        //Assertions
        Assertions.assertThat(formErrorMessage)
                .as("Error message niet getoond!").isTrue();
    }

    private LoginPage init() {
        //Init
        HomePage homePage = new HomePage(driver);
        homePage.toLoginPage();
        LoginPage loginPage = new LoginPage(driver);

        if (loginPage.isLoggedOut() == false) {
            loginPage.doLogout();
        }
        return loginPage;
    }
}
