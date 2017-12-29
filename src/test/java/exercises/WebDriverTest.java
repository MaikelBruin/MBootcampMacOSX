package exercises;

import chapterSix.TestShopScenario;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebDriverTest extends TestShopScenario {

    String baseURL = "https://techblog.polteq.com/testshop/index.php";
    String email = "maikel.bruin@polteq.com";
    String firstName = email.split("\\.")[0].toUpperCase();
    String pwd = "bootcamp";
    String expectedLoginMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";

    @Test
    public void loginSuccesfull() {
//        //Init driver
//        ChromeDriverManager.getInstance().setup();
//        WebDriver driver = new ChromeDriver();
//
//        //Start URL
//        driver.get(baseURL);

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

        Assertions.assertThat(actualName).as("Naam niet correct weergeven").contains(firstName);

        //Wrapup
        driver.quit();
    }
}
