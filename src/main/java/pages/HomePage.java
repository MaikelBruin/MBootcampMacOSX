package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    //Find elements
    @FindBy(className = "login")
    WebElement loginButton;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "passwd")
    WebElement pwdField;

    @FindBy(id = "SubmitLogin")
    WebElement submitButton;

    @FindBy(css = "a[title='contact']")
    WebElement contactUsButton;

    //Constructor method
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void toContactUsPage() {
        contactUsButton.click();
    }

    public void toLoginPage() {
        loginButton.click();
    }
}
