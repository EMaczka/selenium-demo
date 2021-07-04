package demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.UUID;

import static driver.WebDriverCreator.CHROMEDRIVER_PATH;

public class FileDownload {

    File folder;

    @FindBy (linkText = "File Download")
    private WebElement pageLink;

    @FindBy (linkText = "sampleJPEG.jpeg")
    private WebElement jpeg;

    @FindBy (linkText = "FFF.jpg")
    private WebElement jpg;

    @FindBy (linkText = "news.sql")
    private WebElement sql;

    @FindBy (linkText = "logo.png")
    private WebElement png;

    @FindBy (linkText = "textFile.txt")
    private WebElement txt;

    @FindBy (linkText = "sample.png")
    private WebElement png2;

    @FindBy (linkText = "test100k.file")
    private WebElement file;

    @FindBy (linkText = "AssSwe.docx")
    private WebElement docx;

    @FindBy (linkText = "some-file.txt")
    private WebElement txt2;

    @FindBy (linkText = "a1.txt")
    private WebElement txt3;

    public FileDownload() {
    }

    WebDriver driver;

    private void setChromeDownloadConfig() {
        folder = new File(UUID.randomUUID().toString());
        folder.mkdir();

        System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--browser.download.dir=", folder.getAbsolutePath());
        options.addArguments("--browser.download.folderList=2");

        driver = new ChromeDriver(options);
    }

    private void goToDownloadPage() {
        pageLink.click();
    }

    private void downloadFiles() {
        WebElement[] webElements = {jpg, jpeg, txt, txt2, txt3, file, docx, png, png2, sql};
        for (WebElement element : webElements) {
            element.click();
        }
    }

    public int isFilesDownloaded() throws InterruptedException {

        setChromeDownloadConfig();

        for(String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.get("https://the-internet.herokuapp.com/");

        goToDownloadPage();
        downloadFiles();

        Thread.sleep(5000);
        File[] listOfFiles = folder.listFiles();
        int length = listOfFiles.length;
        return length;
    }

    public void clear() {
        for (File file: folder.listFiles()) {
            file.delete();
        }
        folder.delete();
    }
}
