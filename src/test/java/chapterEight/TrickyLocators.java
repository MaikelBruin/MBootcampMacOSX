package chapterEight;

import chapterSix.TestShopScenario;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TrickyLocators extends TestShopScenario {

    @Test
    public void findThings() {

        //locator for "Accessories" button on homepage
//        driver.findElement(By.cssSelector("ul[class*='menu-content']>li>a[title='Accessories']")).click();

        //Locator for "iPod" button under "Categories"
        driver.findElement(By.cssSelector("ul[class='dynamized']>li>[title*='iPod,']")).click();


    }
}
