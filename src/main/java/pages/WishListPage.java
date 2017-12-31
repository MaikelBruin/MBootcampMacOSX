package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


}
