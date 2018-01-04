package chapterNine;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;

public class NOK_LoginTest extends TestShopScenario {
    String email = "maikel.bruin@polteq.com";
    String pwd = "lalalal";
    String expectedLoginMessage =
            "Welcome to your account. Here you can manage all of your personal information and orders.";

    @Test
    public void performNOKLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

//        loginPage.doLogin(email, pwd);


        if (loginPage.isLoggedOut() == true) {
            loginPage.doLogin(email, pwd);
        } else {
            System.out.println("(Other) user was already logged in, relogging");
            loginPage.doLogout();
            loginPage.doLogin(email, pwd);
        }

        String actualLoginMessage = driver.findElement(By.className("info-account")).getText();


        //Assertions
        Assertions.assertThat(actualLoginMessage)
                .as("Login message is niet zoals verwacht!").contains(expectedLoginMessage);
    }
}
