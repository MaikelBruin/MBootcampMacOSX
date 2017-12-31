package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class WishListPage {
    private WebDriver driver;

    //Find elements
    @FindBy(className = "lnk_wishlist")
    WebElement wishListButton;

    @FindBy(id = "name")
    WebElement createNewWishListField;

    @FindBy(id = "submitWishlist")
    WebElement submitWishListButton;

    //Constructor method
    public WishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createWishList(String wishListName) {
        wishListButton.click();
        createNewWishListField.sendKeys(wishListName);
        submitWishListButton.click();
    }

    public List makeRowList () {
        List<WebElement> rowList = driver.findElements(By.cssSelector("tbody tr"));

        //Add text of WebElements to a String list
        List<String> rowTextList = new ArrayList<>();

        for (WebElement row : rowList) {
            rowTextList.add(row.getText());
        }
        return rowTextList;
    }

    public void deleteWishList(String wishListName) {

        //Create list of table rows
        List<WebElement> rowList = driver.findElements(By.cssSelector("tbody tr"));

        //Iterate over the rowList to get all the columns and print the text so that the entire tabel is printed
        for (int row = 0;row<rowList.size(); row++) {
            List<WebElement> columnsList = rowList.get(row).findElements(By.tagName("td"));

            //Store text of rows in variable
            String rowText = rowList.get(row).getText();

            //Find the correct row containing "Feel the pain"
            if (rowText.contains(wishListName)) {
                System.out.println(wishListName + " row present in table, now deleting...");

                //Iterate over all the columns for this row
                for(int column=0;column<columnsList.size();column++) {

                    //Store class of column in a variable
                    String columnClass = columnsList.get(column).getAttribute("class");

                    //Find the correct column containing the delete button
                    if (columnClass.contains("wishlist_delete")) {

                        //Locate and click deleteButton
                        WebElement deleteButton = columnsList.get(column).findElement(By.className("icon-remove"));
                        deleteButton.click();

                        //Click OK on pop-up window
                        driver.switchTo().alert().accept();

                        //Use underneath line to check assertion
//                        driver.switchTo().alert().dismiss();
                    }
                }
            }
        }
    }


}
