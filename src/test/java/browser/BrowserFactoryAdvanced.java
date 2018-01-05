package browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriverService;

public class BrowserFactoryAdvanced {

    static WebDriver driver;

    public enum Browser {
        CHROME,
        SAFARI,
        FIREFOX;
    }

    public static WebDriver getDriver(Browser browser) {

        switch(browser) {
            case FIREFOX:
                getFirefoxDriver();
                break;
            case CHROME:
                getChromeDriver();
                break;
            case SAFARI:
                getSafariDriver();
                break;
            default:
                getChromeDriver();
                break;
        }
        return driver;
    }

    private static WebDriver getChromeDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeDriverManager.getInstance().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-fullscreen");
        chromeOptions.addArguments("ignore-certificate-errors");
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        capabilities.setCapability("chrome switches", "-verbose");
        return driver = new ChromeDriver(chromeOptions);
    }

    private static WebDriver getFirefoxDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxDriverManager.getInstance().setup();
        return driver = new FirefoxDriver();
    }

    private static WebDriver getSafariDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.safari();
        return driver = new SafariDriver();
    }
}
