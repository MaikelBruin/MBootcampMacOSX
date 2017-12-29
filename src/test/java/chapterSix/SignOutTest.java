package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SignOutTest extends TestShopScenario {

    @Test
    public void LogOutSuccesFull()

    {
        //Actions
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(pwd);
        driver.findElement(By.id("SubmitLogin")).click();
        String actualLoginMessage = driver.findElement(By.className("info-account")).getText();
        String actualName = driver.findElement(By.className("account")).getText().toUpperCase();

        //Assertions
        Assertions.assertThat(actualLoginMessage)
                .as("Login message is niet zoals verwacht!").contains(expectedLoginMessage);

        //Actie Loguit
        driver.findElement(By.className("logout")).click();
        String signInText = driver.findElement(By.className("login")).getText();

        //Assert loguit
        Assertions.assertThat(signInText.toUpperCase())
                .as("Gebruiker is niet uitgelogd!").contains(expectedSignInText.toUpperCase());

    }
}
