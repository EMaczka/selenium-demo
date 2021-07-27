package demo.testrun;

import demo.page.PageObjectManager;
import demo.utils.CommonTestSteps;
import driver.WebDriverCreator;
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

    @BeforeEach
    public void setUp() throws IOException {

        PropertiesReader.readPropertiesFile();
        driver = new WebDriverCreator().createDriver(browser);
        commonTestSteps = new CommonTestSteps(driver);
        pageObjectManager = new PageObjectManager(driver);
        commonTestSteps.loadMainPage(URL);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
