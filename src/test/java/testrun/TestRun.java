package testrun;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestRun extends TestBase{

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

        Assertions.assertNotEquals(0, pageObjectManager.getFileDownload()
                .isFilesDownloaded());
        pageObjectManager.getFileDownload().clear();
    }
}