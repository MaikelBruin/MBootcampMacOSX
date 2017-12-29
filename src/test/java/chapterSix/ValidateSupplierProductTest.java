package chapterSix;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ValidateSupplierProductTest extends TestShopScenario {


    @Test
    public void validSuppliers () {
        Select dropdown = new Select(driver.findElement(By.name("supplier_list")));
        dropdown.selectByVisibleText("AppleStore");
        String expectedProduct = "MacBook Air";
        String actualProduct = "";

        //Zet alle producten in een lijst

        List<WebElement> productList = driver.findElements(By.className("product-container"));

        //Idee: stop de productStrings ook weer in een lijst en doe een assert op de hele lijst!
    for (WebElement product : productList) {
        //System.out.println(product);
        String productString = product.getText();
        //System.out.println(productString);

        if (productString.contains("MacBook Air")) {
            //System.out.println("Ik ben een MacBook Air");
            actualProduct = productString;
        }
    }

        //Check that found product is indeed a MacBook Air (or a phony).
        // If no hits found then the empty string will fail the test.
        Assertions.assertThat(actualProduct)
                .as("MacBook Air not found in Apple products.")
                .contains(expectedProduct);

    }
}
