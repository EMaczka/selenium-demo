package demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {

    private final WebDriver driver;
    private FileUpload fileUpload;
    private FileDownload fileDownload;
    private HttpDownload httpDownload;
    private NestedFrames nestedFrames;
    private IFrame iFrame;
    private MultipleWindows multipleWindows;
    private DropdownList dropdownList;

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

    public NestedFrames getNestedFrames() {
        if (nestedFrames == null) {
            nestedFrames = PageFactory.initElements(driver, NestedFrames.class);
        }
        return nestedFrames;
    }

    public IFrame getIFrame() {
        if (iFrame == null) {
            iFrame = PageFactory.initElements(driver, IFrame.class);
        }
        return iFrame;
    }

    public MultipleWindows getMultipleWindows() {
        if (multipleWindows == null) {
            multipleWindows = PageFactory.initElements(driver, MultipleWindows.class);
        }
        return multipleWindows;
    }

    public DropdownList getDropdownList() {
        if (dropdownList == null) {
            dropdownList = PageFactory.initElements(driver, DropdownList.class);
        }
        return dropdownList;
    }
}
