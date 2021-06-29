package testrun;

import demo.commons.CommonTestSteps;
import driver.WebDriverCreator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestRun {

    private WebDriver driver;
    private CommonTestSteps commonTestSteps;
    private static final String URL = "https://demoqa.com/elements";

    @BeforeEach
    public void setUp() {
        driver = new WebDriverCreator().createDriver("chrome");
        commonTestSteps = new CommonTestSteps(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void isPageTitleCorrect() throws Exception {
        commonTestSteps.loadMainPage(URL);
        String title = driver.getTitle();
        Assertions.assertEquals(title,"ToolsQA");
    }
}
