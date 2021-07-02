package testrun;

import demo.commons.CommonTestSteps;
import demo.page.PageObjectManager;
import driver.WebDriverCreator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestRun {

    protected WebDriver driver;
    protected CommonTestSteps commonTestSteps;
    protected PageObjectManager pageObjectManager;
    protected static final String URL = "https://the-internet.herokuapp.com/";

    @BeforeEach
    public void setUp() {
        driver = new WebDriverCreator().createDriver("chrome");
        commonTestSteps = new CommonTestSteps(driver);
        pageObjectManager = new PageObjectManager(driver);
        commonTestSteps.loadMainPage(URL);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void isPageTitleCorrect() throws Exception {

        String title = driver.getTitle();
        Assertions.assertEquals(title,"The Internet");
    }

    @Test
    public void uploadFileTest() throws Exception {

        String result = pageObjectManager.getFileUpload()
                .uploadFile("file");
        Assertions.assertEquals("file", result);
    }
}