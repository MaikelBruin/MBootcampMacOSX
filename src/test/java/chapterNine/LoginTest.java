package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends TestShopScenario {

    @Test
    public void performLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.doLogin("maikel.bruin@polteq.com", "bootcamp");

        String actualLoginMessage = driver.findElement(By.className("info-account")).getText();
        String expectedLoginMessage =
                "Welcome to your account. Here you can manage all of your personal information and orders.";


        //Assertions
        Assertions.assertThat(actualLoginMessage)
                .as("Login message is niet zoals verwacht!").contains(expectedLoginMessage);
    }

}
