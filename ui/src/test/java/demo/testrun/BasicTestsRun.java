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
    public void javaScriptAlertsTest() throws Exception {

        String jSAlertResultText = "You successfully clicked an alert";

        String jSConfirmResultText = "You clicked: Ok";
        String jSDismissResultText = "You clicked: Cancel";

        String textToEnterInPrompt = "test";
        String jSPrompt = "You entered: " + textToEnterInPrompt;

        pageObjectManager.getJsAlerts().goToJsAlertsPage();

        Assertions.assertEquals(jSAlertResultText, pageObjectManager.getJsAlerts().acceptPopup(driver));
        Assertions.assertEquals(jSConfirmResultText, pageObjectManager.getJsAlerts().confirmPopup(driver));
        Assertions.assertEquals(jSDismissResultText, pageObjectManager.getJsAlerts().dismissPopup(driver));
        Assertions.assertEquals(jSPrompt, pageObjectManager.getJsAlerts().sendTextToPopup(driver, textToEnterInPrompt));
    }

    @Test
    public void contextMenuTest() throws Exception {

        String alertText = "You selected a context menu";
        Assertions.assertEquals(alertText, pageObjectManager.getContextMenu().getAlertText(driver));
    }

    @Test
    public void tablesSortTest() throws Exception {

        String columnToBeSorted = "Last Name";    //Last Name, First Name, Email, Due, Website
        String sortingMethod = "desc";       //DESC or ASC
        Assertions.assertTrue(pageObjectManager.getTables().isColumnSorted(columnToBeSorted, sortingMethod));
    }

    @Test
    public void highlightElementTest() throws Exception {

        pageObjectManager.getHighlighting().highlighting(driver, 3);
    }
}