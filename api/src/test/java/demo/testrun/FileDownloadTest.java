package demo.testrun;

import demo.page.CommonTestSteps;
import demo.utils.PageObjectManager;
import driver.WebDriverCreator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class FileDownloadTest {

    public static String browser=null;
    protected WebDriver driver;
    protected CommonTestSteps commonTestSteps;
    protected PageObjectManager pageObjectManager;
    protected static final String URL = "https://the-internet.herokuapp.com/";

    @Test
    public void downloadFileTest() throws Exception {

        PropertiesReader.readPropertiesFile();
        driver = new WebDriverCreator().createDriver(browser);
        commonTestSteps = new CommonTestSteps(driver);
        pageObjectManager = new PageObjectManager(driver);
        commonTestSteps.loadMainPage(URL);

        List<Integer> statusCodes = pageObjectManager.getHttpDownload()
                .checkHttp();
        for (Integer statusCode : statusCodes) {
            Assertions.assertEquals(200, statusCode);
        }

        driver.quit();
    }
}
