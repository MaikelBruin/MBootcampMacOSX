package chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class EmptyCartTest extends TestShopScenario {

    @Test
    public void cartIsEmpty() {

        //To test "else" code, uncomment next block of code
//        driver.findElement(By.cssSelector("#tags_block_left > div > a.tag_level3.first_item")).click();
//        driver.findElement(By.xpath("//*[@id=\'product_list\']/li[2]/div/div[2]/h5/a")).click();
//        driver.findElement(By.xpath("//*[@id=\'add_to_cart\']/button")).click();
//
//        //Wait for popup window to appear and click "Continue shopping" button
//        WebElement popUpButton = (new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.visibilityOfElementLocated(By
//                        .cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span"))));
//
//        boolean popUpButtonIsDisplayed = popUpButton.isDisplayed();
//        popUpButton.click();



        boolean cartIsEmpty = driver.findElement(By.className("ajax_cart_no_product")).isDisplayed();

        //If cart was not empty to begin with, tell the tester
        if (cartIsEmpty) {
            //If cart is empty, put an item in the cart
            driver.findElement(By.cssSelector("[title='More about ipod']")).click();
            driver.findElement(By.cssSelector("[title='iPod shuffle']")).click();
            driver.findElement(By.id("add_to_cart")).click();

            //Wait for popup window to appear and click "Continue shopping" button
            WebElement popUpButton = (new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(By
                            .cssSelector("[class='icon-chevron-left left']"))));

            boolean popUpButtonIsDisplayed = popUpButton.isDisplayed();
            popUpButton.click();

            //Check if shopping cart is filled
            //String cartIsFilled = driver.findElement(By.xpath("//*[@id=\'header\']/div[2]/div/div/div[3]/div/a/span[1]")).getText();
            String cartIsFilled = driver.findElement(By.cssSelector("[class='ajax_cart_quantity unvisible']")).getText();


            Assertions.assertThat(cartIsFilled).as("Cart is not filled!").contains("1");

            //Open cart
            driver.findElement(By.cssSelector("[title='View my shopping cart']")).click();

            //Delete item from cart
            driver.findElement(By.cssSelector("[title='Delete']")).click();

            //Wait for cart to be emptied and get text saying that cart is empty
            String emptyText = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.visibilityOfElementLocated(By
                            .cssSelector("[class='alert alert-warning']"))).getText();

            //Assert that cart is empty
            Assertions.assertThat(emptyText).as("Shopping cart is not empty")
                    .contains("Your shopping cart is empty.");
        } else System.out.println("Cart was not empty to begin with.");
    }
}
