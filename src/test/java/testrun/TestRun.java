package testrun;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRun extends TestBase {

    @Test
    public void isPageTitleCorrect() throws Exception {
        commonTestSteps.loadMainPage(URL);
        String title = driver.getTitle();
        Assertions.assertEquals(title,"ToolsQA");
    }
}
