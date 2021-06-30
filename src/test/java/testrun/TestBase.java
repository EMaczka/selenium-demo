package testrun;

import demo.commons.CommonTestSteps;
import demo.page.PageObjectManager;
import driver.WebDriverCreator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class TestBase {

    protected WebDriver driver;
    protected CommonTestSteps commonTestSteps;
    protected PageObjectManager pageObjectManager;
    protected static final String URL = "https://demoqa.com/elements";

    @BeforeEach
    public void setUp() {
        driver = new WebDriverCreator().createDriver("chrome");
        commonTestSteps = new CommonTestSteps(driver);
        pageObjectManager = new PageObjectManager(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}