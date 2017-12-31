package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.LoginPage;

public class NOK_FillInContactFormTest extends TestShopScenario {

    String email = "nope";
    String orderReference = "4321234";
    String message = "Help!";
    String contactID = "Customer service";
    String expectedErrorMessage = "Invalid email address.";

    @Test
    public void ContactFormNOKTest() {
        LoginPage loginPage = new LoginPage(driver);

        if (loginPage.isLoggedOut() == false) {
            loginPage.doLogout();
        }

            //Navigate to correct page
            driver.findElement(By.cssSelector("a[title='contact']")).click();

            //Make instance of contactUsPage class
            ContactUsPage contactUsPage = new ContactUsPage(driver);

            //Call submitForm method and pass arguments
            contactUsPage.submitForm(email, orderReference, message, contactID);

            String actualMessage = driver.findElement(By.className("alert-danger")).getText();

            Assertions.assertThat(actualMessage).as("submitForm unexpectedly was successful.")
                    .containsIgnoringCase(expectedErrorMessage);

    }
}
