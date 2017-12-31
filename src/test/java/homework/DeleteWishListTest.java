package homework;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.WishListPage;

import java.util.ArrayList;
import java.util.List;

public class DeleteWishListTest extends TestShopScenario {

    String emailForAssignment = "maikel@bruin.com";
    String pwdForAssignment = "1qazxsw2";
    String wishListName = "Feel the pain";

    /*
    deleteTableRowTest does the following:
    1. Logs in
    2. Goes to wishlist page
    3. Creates new wishlist
    4. Validates that new wishlist is present in the table
    5. Create matrix (list in ist) of WebElements
    6. Searches matrix for specific wishlist (added in step 3)
    7. Deletes wishlist from WebTable
    8. Validates that wishlist is deleted from the WebTable

    Notes: The validation in step 8 originally failed due to not proper reloading of the WebTable elements
            Error is "stale element reference: element is not attached to the page document"
            Current workaround is navigating to other page and back, which costs some time but not much.
     */

    @Test
    public void deleteTableRowTest() {

        //Make LoginPage object and log in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(emailForAssignment, pwdForAssignment);

        //Make WishListPage object and create new wishlist
        WishListPage wishListPage = new WishListPage(driver);
        wishListPage.createWishList(wishListName);

        //Make list of rows
        List rowTextList = wishListPage.makeRowList();

        //Assert that specific wishlist is added to table
        Assertions.assertThat(rowTextList.toString()).as("'Feel the pain' wish list not added!")
                .contains(wishListName);

        //Delete wishlist from table
        wishListPage.deleteWishList(wishListName);

        //Wait until page is back and navigate to my account page (workaround for stale element error)
        WebElement accountButton = new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.className("account")));

        accountButton.click();

        //Go to wishList
        driver.findElement(By.className("lnk_wishlist")).click();

        //Make new WebElement list of rows and an empty String list
       List newRowTextList = wishListPage.makeRowList();

        //Validate that "Feel the pain" row is not present anymore in remaining table on the page
        Assertions.assertThat(newRowTextList.toString()).as("'Feel the pain' wish list still present")
                .doesNotContain(wishListName);
    }
}





