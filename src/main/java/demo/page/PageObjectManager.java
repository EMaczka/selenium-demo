package demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {

    private final WebDriver driver;
    private FileUpload fileUpload;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public FileUpload getFileUpload() {
        if (fileUpload == null) {
            fileUpload = PageFactory.initElements(driver, FileUpload.class);
        }
        return fileUpload;
    }
}
