package testrun;

import demo.page.PageObjectManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static driver.WebDriverCreator.CHROMEDRIVER_PATH;

public class FileDownloadTest {

    //This class checks the same functionality as downloadFileTest() in BasicTestsRun

    private ChromeDriver driver;
    private PageObjectManager pageObjectManager;
    private static final String URL = "https://the-internet.herokuapp.com/";
    private File folder;

    @BeforeEach
    public void setUp() {

        //download folder setup
        folder = new File(UUID.randomUUID().toString());
        folder.mkdir();

        String downloadFilePath = folder.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilePath);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--test-type");
        options.addArguments("start-maximized", "disable-popup-blocking");
        driver = new ChromeDriver(options);

        pageObjectManager = new PageObjectManager(driver);
    }

    @Test
    public void downloadFileTest() throws Exception {

        driver.get(URL);

        pageObjectManager.getFileDownload()
                .download();

        File[] listOfFiles = folder.listFiles();
        int downloadedFilesAmount = listOfFiles.length;
        Assertions.assertNotEquals(0, downloadedFilesAmount);
        Thread.sleep(15000);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();

        //files and folder drop after Test
        for (File file: folder.listFiles()) {
            file.delete();
        }
        folder.delete();
    }
}



