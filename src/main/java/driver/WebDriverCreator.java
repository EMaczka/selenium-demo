package driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class WebDriverCreator {

    public static String CHROMEDRIVER_PATH = "src/main/resources/seleniumdrivers/chromedrivers/chromedriver-win32/chromedriver.exe";

    public WebDriver createDriver(String browser) {
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
                WebDriver chromeDriver = new ChromeDriver();
                setDefaultSettings(chromeDriver);
                return chromeDriver;

            default:
                throw new IllegalArgumentException("The browser type is undefined");
        }
    }

    private static void setDefaultSettings(WebDriver driver) {
        driver.manage().window().setSize(new Dimension(1920, 1024));
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
    }
}
