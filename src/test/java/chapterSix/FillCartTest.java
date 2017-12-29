package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FillCartTest extends TestShopScenario {

    @Test
    public void CartIsFilled() {

        //Check if cart is empty
        boolean cartIsEmpty = driver.findElement(By.className("ajax_cart_no_product")).isDisplayed();

        Assertions.assertThat(cartIsEmpty).as("Cart is not empty!").isTrue();

        //Add iPod Shuffle to cart
        driver.findElement(By.cssSelector("[title='More about ipod']")).click();
        driver.findElement(By.cssSelector("[title='iPod shuffle']")).click();
        driver.findElement(By.id("add_to_cart")).click();

        //Wait for popup window to appear and find "Continue shopping" button
        WebElement popUpButton = (new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .cssSelector("[class='icon-chevron-left left']"))));

        boolean popUpButtonIsDisplayed = popUpButton.isDisplayed();

        popUpButton.click();

        //Check if shopping cart is filled
        String cartIsFilled = driver.findElement(By.cssSelector("[class='ajax_cart_quantity unvisible']")).getText();
        Assertions.assertThat(cartIsFilled).as("Cart is not filled!").contains("1");

    }
}
