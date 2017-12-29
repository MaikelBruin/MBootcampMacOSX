package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class FillinContactFormTest extends TestShopScenario{

    @Test
    public void FillinContactForm() {

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
