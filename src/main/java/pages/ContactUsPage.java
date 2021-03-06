package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    private WebDriver driver;

    //Find WebElements
    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "id_order")
    private WebElement orderReferenceField;

    @FindBy(id = "message")
    private WebElement messageField;

    @FindBy(id = "fileUpload")
    private WebElement fileUploadField;

    @FindBy(id = "submitMessage")
    private WebElement submitButton;

    @FindBy(className = "form-error")
    private WebElement emailFormatError;

    @FindBy(className = "alert-danger")
    private WebElement submitFormError;

    //Constructor method
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    //Enter email
    public boolean isEmailInCorrect(String email) {
        emailField = driver.findElement(By.id("email"));
        emailField.sendKeys(email);
        driver.findElement(By.id("id_order")).click();
        boolean emailInCorrect = driver.findElement(By.className("form-error")).isDisplayed();

        return emailInCorrect;
    }

    //Submit form method with attachment
    public void submitForm(String email, String orderReference, String message, String contactID, String pathToFile) {
        emailField.sendKeys(email);
        orderReferenceField.sendKeys(orderReference);
        messageField.sendKeys(message);

        Select idContactSelectBox = new Select(driver.findElement(By.id("id_contact")));
        idContactSelectBox.selectByVisibleText(contactID);

        fileUploadField.sendKeys(pathToFile);
        submitButton.click();

    }

    //Submit form method without attachment
    public void submitForm(String email, String orderReference, String message, String contactID) {
        emailField.sendKeys(email);
        orderReferenceField.sendKeys(orderReference);
        messageField.sendKeys(message);

        Select idContactSelectBox = new Select(driver.findElement(By.id("id_contact")));
        idContactSelectBox.selectByVisibleText(contactID);

        submitButton.click();
    }
}
