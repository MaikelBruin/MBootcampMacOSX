package dataDrivenTesting;

import chapterSix.TestShopScenario;
import com.beust.jcommander.Parameter;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.LoginPage;

public class DataDrivenTest extends TestShopScenario {

    @Parameters({"email", "orderReference", "message", "contactID", "pathToFile"})

    @Test
    public void FillinContactForm(String email, String orderReference, String message, String contactID, String pathToFile) {

        LoginPage loginPage = new LoginPage(driver);

        if (loginPage.isLoggedOut() == false) {
            loginPage.doLogout();
        }

        //Navigate to correct page
        driver.findElement(By.cssSelector("a[title='contact']")).click();

        //Make instance of contactUsPage class
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        //Call submitForm method and pass arguments
        contactUsPage.submitForm(email, orderReference, message, contactID, pathToFile);

        String successMessage = driver.findElement(By.className("alert-success")).getText();

        Assertions.assertThat(successMessage).as("submitForm not successful.")
                .isEqualTo("Your message has been successfully sent to our team.");

    }



}
