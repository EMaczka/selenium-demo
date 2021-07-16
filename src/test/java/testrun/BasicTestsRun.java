package testrun;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicTestsRun extends TestBase{

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

    @Test
    public void downloadFileTest() throws Exception {

        List<Integer> statusCodes = pageObjectManager.getHttpDownload()
                .checkHttp();
        for (Integer statusCode : statusCodes) {
            Assertions.assertEquals(200,statusCode);
        }
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
}