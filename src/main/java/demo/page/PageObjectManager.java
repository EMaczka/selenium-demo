package demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {

    private final WebDriver driver;
    private FileUpload fileUpload;
    private FileDownload fileDownload;
    private HttpDownload httpDownload;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public FileUpload getFileUpload() {
        if (fileUpload == null) {
            fileUpload = PageFactory.initElements(driver, FileUpload.class);
        }
        return fileUpload;
    }

    public FileDownload getFileDownload() {
        if (fileDownload == null) {
            fileDownload = PageFactory.initElements(driver, FileDownload.class);
        }
        return fileDownload;
    }

    public HttpDownload getHttpDownload() {
        if (httpDownload == null) {
            httpDownload = PageFactory.initElements(driver, HttpDownload.class);
        }
        return httpDownload;
    }
}
