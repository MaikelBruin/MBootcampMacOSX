package chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AdjustPersonalInfoTest extends TestShopScenario{

    @Test
    public void AdjustPersonalInfo() {
        boolean isLoggedOut = driver.findElement(By.className("login")).isDisplayed();
        System.out.println(isLoggedOut);
        String originalFirstName = "Maikel";
        String alternativeFirstName = "Brownie";

        //If no user is logged in, first log in
        if (isLoggedOut) {
            System.out.println("No user logged in, logging in...");
            driver.findElement(By.className("login")).click();
            driver.findElement(By.id("email")).sendKeys(email);
            driver.findElement(By.id("passwd")).sendKeys(pwd);
            driver.findElement(By.id("SubmitLogin")).click();
        }
        else {
            System.out.println("User already logged in, going to My Account page...");
            driver.findElement(By.className("header_user_info")).click();
        }

        //Go to My personal info page
        driver.findElement(By.className("icon-user")).click();

        //Fetch first name
        String actualFirstName = driver.findElement(By.id("firstname")).getAttribute("value");
        System.out.println(actualFirstName);

        //Compare first name to original first name

        if (actualFirstName.equalsIgnoreCase(originalFirstName)) {
            System.out.println("First name found in account information equal to \"" + actualFirstName +
                    "\", changing to alternative name...");
            driver.findElement(By.id("firstname")).clear();
            driver.findElement(By.id("firstname")).sendKeys(alternativeFirstName);
            driver.findElement(By.id("old_passwd")).sendKeys(pwd);
            driver.findElement(By.name("submitIdentity")).click();

        } else if (actualFirstName.equalsIgnoreCase(alternativeFirstName)){
            System.out.println("First name found in account information equal to \"" + actualFirstName +
                    "\", changing to original name...");
            driver.findElement(By.id("firstname")).clear();
            driver.findElement(By.id("firstname")).sendKeys(originalFirstName);
            driver.findElement(By.id("old_passwd")).sendKeys(pwd);
            driver.findElement(By.name("submitIdentity")).click();

        } else {
            System.out.println("First name found in account information equal to \"" + actualFirstName +
                    "\", changing to original name...");
            driver.findElement(By.id("firstname")).clear();
            driver.findElement(By.id("firstname")).sendKeys(originalFirstName);
            driver.findElement(By.id("old_passwd")).sendKeys(pwd);
            driver.findElement(By.name("submitIdentity")).click();
        }

        String successMessage = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .className("alert-success")))).getText();

        //To test any other text, decomment next line
        //successMessage = "lalalala";

        Assertions.assertThat(successMessage).as("Success message not present or not correct.")
                .isEqualTo("Your personal information has been successfully updated.");
    }
}
