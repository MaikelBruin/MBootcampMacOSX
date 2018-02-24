package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExtendedPage extends BasePage {
    public ExtendedPage(WebDriver driver) {
        super.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Elements
    @FindBy (css = "[id='special_block_right']>p a")
    public WebElement specialButton;


    public void goToSpecials() {
        specialButton.click();
    }

    public SpecialPage goToSpecialPage() {
        specialButton.click();
        return new SpecialPage(driver);
    }
}
