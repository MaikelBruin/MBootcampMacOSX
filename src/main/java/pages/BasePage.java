package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

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


    public void toContactUsPage() {
        contactUsButton.click();
    }

    public void toLoginPage() {
        loginButton.click();
    }

}
