package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SpecialPage extends ExtendedPage {
    public SpecialPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Elements

    @FindBy (css = "h1")
    public WebElement headerText;


    public String getHeaderText() {
        String headerTextStr = headerText.getText();
        return headerTextStr;
    }
}
