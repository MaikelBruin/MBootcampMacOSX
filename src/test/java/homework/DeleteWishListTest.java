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

    @Test
    public void deleteTableRowTest() {

        //Make LoginPage object and log in
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(emailForAssignment, pwdForAssignment);

        //Make WishListPage object and create new wishlist
        WishListPage wishListPage = new WishListPage(driver);
        wishListPage.createWishList(wishListName);

        //Create list of table rows
        List<WebElement> rowList = driver.findElements(By.cssSelector("tbody tr"));

        //Assert that specific wishlist is added to table
        List<String> rowTextList = new ArrayList<>();
        for (WebElement row : rowList) {
            rowTextList.add(row.getText());
        }

        Assertions.assertThat(rowTextList.toString()).as("'Feel the pain' wish list not added!")
                .contains(wishListName);


        //Iterate over the rowList to get all the columns and print the text so that the entire tabel is printed
        for (int row = 0;row<rowList.size(); row++) {
            List<WebElement> columnsList = rowList.get(row).findElements(By.tagName("td"));

            //Store text of rows in variable
            String rowText = rowList.get(row).getText();
            //System.out.println(rowText);

            //Find the correct row containing "Feel the pain"
            if (rowText.contains(wishListName)) {
                System.out.println(wishListName + " row present in table, now deleting...");

                //Iterate over all the columns for this row
                for(int column=0;column<columnsList.size();column++) {
//                    System.out.println(columnsList.get(column).getText());

                    //Store text of column in a variable
                    String columnText = columnsList.get(column).getText();

                    //Store class of column in a variable
                    String columnClass = columnsList.get(column).getAttribute("class");


                    //Find the correct column containing the delete button
                    if (columnClass.contains("wishlist_delete")) {
//                        System.out.println(columnClass);

                        //Locate and click deleteButton
                        WebElement deleteButton = columnsList.get(column).findElement(By.className("icon-remove"));
//                        System.out.println(deleteButton.getAttribute("class"));
                        deleteButton.click();

                        //Click OK on pop-up window
                        Alert alert = driver.switchTo().alert();
                        driver.switchTo().alert().accept();

                        //Use underneath line to check assertion
//                        driver.switchTo().alert().dismiss();
                    }
                }
            }
        }

        //Wait until page is back and navigate to my account page (workaround for stale element error)
        WebElement accountButton = new WebDriverWait(driver, 10)
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.className("account")));

        accountButton.click();

        //Go to wishList
        driver.findElement(By.className("lnk_wishlist")).click();

        //Make new WebElement list of rows and an empty String list
        List<WebElement> newRowList = driver.findElements(By.cssSelector("tbody tr"));
        List<String> newRowTextList = new ArrayList<>();

        //Fill String list with the text of the WebElements
        for (WebElement newRow : newRowList) {
            newRowTextList.add(newRow.getText());
//            System.out.println(newRow.getText());
        }

        //Validate that "Feel the pain" row is not present anymore in remaining table on the page
        Assertions.assertThat(newRowTextList.toString()).as("Feel the pain wish list still present")
                .doesNotContain(wishListName);
    }
}

