package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import pages.LoginPage;

public class NOK_ContactFormEmailFormatTest extends TestShopScenario {

    String email = "nope";
    String orderReference = "4321234";
    String message = "Help!";
    String contactID = "Customer service";
    String expectedErrorMessage = "Invalid email address.";

    @Test
    public void ContactFormEmailNOKTest() {
        LoginPage loginPage = new LoginPage(driver);

        if (loginPage.isLoggedOut() == false) {
            loginPage.doLogout();
        }

        //Navigate to correct page
        HomePage homePage = new HomePage(driver);
        homePage.toContactUsPage();

        //Make instance of contactUsPage class
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        //Call isEmailInCorrect method
        boolean emailInCorrect = contactUsPage.isEmailInCorrect(email);

        Assertions.assertThat(emailInCorrect).as("No (correct) error message given!").isTrue();



    }
}
