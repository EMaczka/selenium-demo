package demo.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FileDownload {

    @FindBy (linkText = "File Download")
    private WebElement pageLink;

    @FindBy (tagName = "a")
    private List<WebElement> allLinks;

    public FileDownload() {
    }

    private void goToDownloadPage() {
        pageLink.click();
    }

    private void downloadFiles() {
       //the first and last link are not the desired elements
        for (int i = 1; i < allLinks.size()-1 ; i++) {
            allLinks.get(i).click();
        }
    }

    public void download() throws InterruptedException {
        goToDownloadPage();
        downloadFiles();
    }
}
