package browser;

import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverService;

public class BrowserFactory {

    static WebDriver driver;

    public static WebDriver getDriver(String browser) {

        switch(browser.toLowerCase()) {
            case "firefox":
                driver = getFirefoxDriver();
                break;
            case "chrome":
                getChromeDriver();
                break;
            default:
                getChromeDriver();
                break;
        }
        return driver;
    }

    private static WebDriver getChromeDriver() {
        ChromeDriverManager.getInstance().setup();
        return driver = new ChromeDriver();
    }

    private static WebDriver getFirefoxDriver() {
        FirefoxDriverManager.getInstance().setup();
        return driver = new FirefoxDriver();
    }
}
