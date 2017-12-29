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

    //Constructor method
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Submit form method
    public void submitForm(String email, String orderReference, String message, String contactID, String pathToFile) {
        emailField.sendKeys(email);
        orderReferenceField.sendKeys(orderReference);
        messageField.sendKeys(message);

        Select idContactSelectBox = new Select(driver.findElement(By.id("id_contact")));
        idContactSelectBox.selectByVisibleText(contactID);

        fileUploadField.sendKeys(pathToFile);


        submitButton.click();

    }

    public void submitForm(String email, String orderReference, String message, String contactID) {
        emailField.sendKeys(email);
        orderReferenceField.sendKeys(orderReference);
        messageField.sendKeys(message);

        Select idContactSelectBox = new Select(driver.findElement(By.id("id_contact")));
        idContactSelectBox.selectByVisibleText(contactID);

        submitButton.click();
    }
}
