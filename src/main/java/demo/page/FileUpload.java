package demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class FileUpload {

    @FindBy(linkText = "File Upload")
    private WebElement pageLink;

    @FindBy(id = "file-upload")
    private WebElement uploadButton;

    @FindBy(id = "file-submit")
    private WebElement submitFileButton;

    @FindBy(id = "uploaded-files")
    private WebElement uploadedFile;

    public FileUpload() {
    }

    public void goToPage() {
        pageLink.click();
    }

    public void chooseFile(String fileToUpload) {
        String filename = fileToUpload;
        File file = new File(filename);
        String path = file.getAbsolutePath();
        uploadButton.sendKeys(path);
    }

    public void submitFile() {
        submitFileButton.click();
    }

    public String uploadFile(String fileToUpload) {
        goToPage();
        chooseFile(fileToUpload);
        submitFile();
        return uploadedFile.getText();
    }
}
