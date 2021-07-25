package demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {

    private final WebDriver driver;
    private FileUpload fileUpload;
    private NestedFrames nestedFrames;
    private IFrame iFrame;
    private MultipleWindows multipleWindows;
    private DropdownList dropdownList;
    private BasicAuth basicAuth;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public FileUpload getFileUpload() {
        if (fileUpload == null) {
            fileUpload = PageFactory.initElements(driver, FileUpload.class);
        }
        return fileUpload;
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

    public BasicAuth getBasicAuth() {
        if (basicAuth == null) {
            basicAuth = PageFactory.initElements(driver, BasicAuth.class);
        }
        return basicAuth;
    }
}