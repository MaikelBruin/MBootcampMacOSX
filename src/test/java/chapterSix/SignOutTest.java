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

        //Actie Loguit
        driver.findElement(By.className("logout")).click();
        String signInText = driver.findElement(By.className("login")).getText();

        //Assert loguit
        Assertions.assertThat(signInText.toUpperCase())
                .as("Gebruiker is niet uitgelogd!").contains(expectedSignInText.toUpperCase());

    }


}
