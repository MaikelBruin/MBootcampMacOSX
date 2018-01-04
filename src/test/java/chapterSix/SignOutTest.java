package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

public class SignOutTest extends TestShopScenario {

    String email = "maikel.bruin@polteq.com";
    String pwd = "bootcamp";

    @Test
    public void LogOutSuccesFull()

    {
        //Actions
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(email, pwd);

        //Actie Loguit
        driver.findElement(By.className("logout")).click();
        String signInText = driver.findElement(By.className("login")).getText();

        //Assert loguit
        Assertions.assertThat(signInText.toUpperCase())
                .as("Gebruiker is niet uitgelogd!").contains(expectedSignInText.toUpperCase());

    }


}
