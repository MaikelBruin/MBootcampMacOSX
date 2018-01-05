package browserDrivenTesting;

import browser.BrowserFactoryAdvanced;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestShopScenarioBrowserDriven {

    protected WebDriver driver;

    private String baseURL = "https://techblog.polteq.com/testshop/index.php";
    String email = "maikel.bruin@polteq.com";
    String pwd = "bootcamp";
    String expectedLoginMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";
    String expectedSignInText = "Sign in";

    @Parameters("browser")

    @BeforeMethod
    public void setUp(BrowserFactoryAdvanced.Browser browser) {
        driver = BrowserFactoryAdvanced.getDriver(browser);
        driver.get(baseURL);
    }


    @AfterMethod
    public void wrapUp() {
        driver.quit();
    }
}
