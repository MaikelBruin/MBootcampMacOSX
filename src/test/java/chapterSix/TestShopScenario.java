package chapterSix;

import browser.BrowserFactory;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestShopScenario {

    protected WebDriver driver;

    private String baseURL = "https://techblog.polteq.com/testshop/index.php";
    String email = "maikel.bruin@polteq.com";
    String pwd = "bootcamp";
    String expectedLoginMessage = "Welcome to your account. Here you can manage all of your personal information and orders.";
    String expectedSignInText = "Sign in";

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(baseURL);
    }


    @AfterMethod
    public void wrapUp() {
        //driver.quit();
    }
}
