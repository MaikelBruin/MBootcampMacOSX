package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

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

    @FindBy(className = "alert")
    WebElement errorMessage;

    @FindBy(className = "form-error")
    WebElement formErrorMessage;

    @FindBy(css = "div[class*=form-error]>[type=email]")
    WebElement wrongEmailFormat;

    @FindBy(css = "div[class*=form-error]>[type=password]")
    WebElement wrongPwdFormat;


    //Constructor method
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoggedOut() {
        String loginText = "SIGN IN";
        String userInfo = driver.findElement(By.className("header_user_info")).getText();
        boolean isLoggedOut = userInfo.equalsIgnoreCase("SIGN IN");
        return isLoggedOut;
    }

    public void doLogin(String email, String pwd) {
        loginButton.click();
        emailField.sendKeys(email);
        pwdField.sendKeys(pwd);
        submitButton.click();
    }

    public String doNOKLogin(String email, String pwd) {
        loginButton.click();
        emailField.sendKeys(email);
        pwdField.sendKeys(pwd);
        submitButton.click();
        return errorMessage.getText();
    }

    public Boolean doNOKEmail(String email) {
        emailField.sendKeys(email);
        pwdField.click();
        return wrongEmailFormat.isDisplayed();
    }

    public Boolean doNOKPwd(String email, String pwd) {
        emailField.sendKeys(email);
        pwdField.sendKeys(pwd);
        emailField.click();
        return wrongPwdFormat.isDisplayed();
    }

    public void doLogout () {
        driver.findElement(By.className("logout")).click();
    }


}
