package homework;

import chapterSix.TestShopScenario;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class DeleteWishListTest extends TestShopScenario {

    String email2 = "maikel@bruin.com";
    String pwd2 = "1qazxsw2";

    @Test
    public void deleteTableRowTest() {

        //Login (create method from this)
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys(email2);
        driver.findElement(By.id("passwd")).sendKeys(pwd2);
        driver.findElement(By.id("SubmitLogin")).click();

        //Go to wishList
        driver.findElement(By.className("lnk_wishlist")).click();

        //Define table
        WebElement table = driver.findElement(By.tagName("tbody"));

        //Create list of rows
        List<WebElement> rowList = driver.findElements(By.cssSelector("tbody tr"));

        //Print # of rows
        System.out.println("Number of rows: " + rowList.size());


        //Iterate over the rowList to get all the columns and print the text so that the entire tabel is printed
        for (int row = 0;row<rowList.size(); row++) {
            List<WebElement> columnsList = rowList.get(row).findElements(By.tagName("td"));

            //Store text of rows in variable
            String rowText = rowList.get(row).getText();
            System.out.println(rowText);

            //Find the correct row containing "Feel the pain"
            if (rowText.contains("Feel the pain")) {

                //Iterate over all the columns for this row
                for(int column=0;column<columnsList.size();column++) {
                    System.out.println(columnsList.get(column).getText());

                    //Store text of column in a variable
                    String columnText = columnsList.get(column).getText();

                    //Store class of column in a variable
                    String columnClass = columnsList.get(column).getAttribute("class");


                    //Find the correct column containing the delete button
                    if (columnClass.contains("wishlist_delete")) {
                        System.out.println(columnClass);

                        //Locate and click deleteButton
                        WebElement deleteButton = columnsList.get(column).findElement(By.className("icon-remove"));

                        System.out.println(deleteButton.getAttribute("class"));
                        deleteButton.click();

                        //Click OK on pop-up window
                        Alert alert = driver.switchTo().alert();
                        driver.switchTo().alert().accept();
                    }
                }
            }

            //Validate that "Feel the pain" row is not present
            Assertions.assertThat(rowText).as("Feel the pain wishlist still present")
                    .doesNotContain("Feel the pain");
        }
    }
}

