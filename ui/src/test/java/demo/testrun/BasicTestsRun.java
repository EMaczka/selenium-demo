package demo.testrun;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BasicTestsRun extends TestBase {

    @Test
    public void isPageTitleCorrect() throws Exception {

        String title = driver.getTitle();
        Assertions.assertEquals(title, "The Internet");
    }

    @Test
    public void uploadFileTest() throws Exception {

        String result = pageObjectManager.getFileUpload()
                .uploadFile("file");
        Assertions.assertEquals("file", result);
    }

    @Test
    public void checkboxTest() throws Exception {
        Assertions.assertTrue(pageObjectManager.getCheckbox().areEditableTest());
    }

    @Test
    public void nestedFramesTest() throws Exception {

        ArrayList<String> framesNames = pageObjectManager.getNestedFrames()
                .getFrameNames(driver);
        ArrayList<String> frames = new ArrayList<String>(
                Arrays.asList("LEFT", "MIDDLE", "RIGHT", "BOTTOM"));
        Assertions.assertEquals(frames, framesNames);
    }

    @Test
    public void iFrameTest() throws Exception {

        String text = "new text in editor";
        String fillingTest = pageObjectManager.getIFrame().writeInEditor(driver, text);
        Assertions.assertEquals(text, fillingTest);
    }

    @Test
    public void multipleWindowsTest() throws Exception {

        pageObjectManager.getMultipleWindows().switchWindow(driver);
        Assertions.assertEquals("New Window", driver.getTitle());
    }

    @Test
    public void dropdownListTest() throws Exception {

        String option = "Option 1";
        String selected = pageObjectManager.getDropdownList().checkOption(option);
        Assertions.assertEquals(option, selected);
    }

    @Test
    public void basicAuthTest() throws Exception {

        String pageMessage = "Congratulations!";
        String displayedText = pageObjectManager.getBasicAuth().getMessage(driver);
        Assertions.assertTrue(displayedText.contains(pageMessage));
    }

    @Test
    public void hoverTest() throws Exception {

        boolean isHoverDisplayCaptions = pageObjectManager.getHover().isCaptionVisible(driver);
        Assertions.assertTrue(isHoverDisplayCaptions);
    }

    @Test
    public void JavaScriptAlertsTest() throws Exception {

        String JSAlertResultText = "You successfully clicked an alert";

        String JSConfirmResultText = "You clicked: Ok";
        String JSDismissResultText = "You clicked: Cancel";

        String textToEnterInPrompt = "test";
        String JSPrompt = "You entered:" + textToEnterInPrompt;

        Assertions.assertEquals(JSAlertResultText, pageObjectManager.getJsAlerts().acceptPopup(driver));
    }
}