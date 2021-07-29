package demo.testrun;

import demo.page.PageObjectManager;
import demo.utils.CommonTestSteps;
import driver.WebDriverCreator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public abstract class TestBase {

    public static String browser=null;
    protected WebDriver driver;
    protected CommonTestSteps commonTestSteps;
    protected PageObjectManager pageObjectManager;
    protected static final String URL = "https://the-internet.herokuapp.com/";
    private static Logger logger = LogManager.getLogger(TestBase.class);

    @BeforeEach
    public void setUp() throws IOException {

        PropertiesReader.readPropertiesFile();
        driver = new WebDriverCreator().createDriver(browser);
        commonTestSteps = new CommonTestSteps(driver);
        pageObjectManager = new PageObjectManager(driver);
        commonTestSteps.loadMainPage(URL);
        logger.info(browser + " opened");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
        logger.info(browser + " closed");
    }
}
