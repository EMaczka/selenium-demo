package driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.util.concurrent.TimeUnit;

public class WebDriverCreator {

    public static String CHROMEDRIVER_PATH = "../common-utils/src/main/resources/seleniumdrivers/chromedrivers/chromedriver-win32/chromedriver.exe";
    public static String FIREFOXDRIVER_PATH = "../common-utils/src/main/resources/seleniumdrivers/firefoxdrivers/geckodriver-v0.30.0-win32/geckodriver.exe";

    public WebDriver createDriver(String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
                WebDriver chromeDriver = new ChromeDriver();
                setDefaultSettings(chromeDriver);
                return chromeDriver;
            case "headless":
                return new HtmlUnitDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver",FIREFOXDRIVER_PATH);
                WebDriver firefoxDriver = new FirefoxDriver();
                setDefaultSettings(firefoxDriver);
                return firefoxDriver;
            default:
                throw new IllegalArgumentException("The browser type is undefined");
        }
    }

    private static void setDefaultSettings(WebDriver driver) {
        driver.manage().window().setSize(new Dimension(1920, 1024));
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }
}
