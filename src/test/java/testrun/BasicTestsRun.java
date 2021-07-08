package testrun;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}