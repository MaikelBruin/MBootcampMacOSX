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
    String targetRow = "Feel the pain";

    @Test
    public void deleteTableRowTest() {

        //Login
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
        System.out.println("Number of rows: " + rowList.size());

        //Create empty string list
        List<String> wishStringList = new ArrayList<String>();


        //Iterate over the rowList to get all the columns and print the text so that the entire tabel is printed
        for (int row = 0;row<rowList.size(); row++) {
            List<WebElement> columnsList = rowList.get(row).findElements(By.tagName("td"));
//            System.out.println("Number of columns:"+columnsList.size());

            String rowText = rowList.get(row).getText();

            wishStringList.add(rowText);

            //Find the correct row containing "Feel the pain"
            if (rowText.contains("Feel the pain")) {

                //Iterate over all the columns for this row
                for(int column=0;column<columnsList.size();column++) {
                    System.out.println(columnsList.get(column).getText());
                    String columnText = columnsList.get(column).getText();
                    String columnClass = columnsList.get(column).getAttribute("class");
//                    System.out.println(columnsList.get(column).getAttribute("class"));



                    //Find the correct column containing the delete button
                    if (columnClass.contains("wishlist_delete")) {
                        System.out.println(columnClass);
                        WebElement deleteButton = columnsList.get(column).findElement(By.className("icon-remove"));

                        System.out.println(deleteButton.getAttribute("class"));
                        deleteButton.click();

                        Alert alert = driver.switchTo().alert();
                        driver.switchTo().alert().accept();
                    }
                }
            }
        }


        //Put assert here
    }
}

