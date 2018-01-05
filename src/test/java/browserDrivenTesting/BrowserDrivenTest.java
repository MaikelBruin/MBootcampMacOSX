package browserDrivenTesting;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.LoginPage;

public class BrowserDrivenTest extends TestShopScenarioBrowserDriven {

    @Test
    public void FillinContactForm() {

        LoginPage loginPage = new LoginPage(driver);

        if (loginPage.isLoggedOut() == false) {
            loginPage.doLogout();
        }

        //Navigate to correct page
        driver.findElement(By.cssSelector("a[title='contact']")).click();

        //Make instance of contactUsPage class
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        //Call submitForm method and pass arguments
        contactUsPage.submitForm("maikel.bruin@polteq.com",
                "222222a",
                "Hallo ik ben Maikel en ik heb een klacht.",
                "Customer service",
                "/Users/maikel/Documents/bijlageTest.txt");

        String successMessage = driver.findElement(By.className("alert-success")).getText();

        Assertions.assertThat(successMessage).as("submitForm not successful.")
                .isEqualTo("Your message has been successfully sent to our team.");

    }



}
