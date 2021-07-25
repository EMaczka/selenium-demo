package demo.utils;

import demo.page.HttpDownload;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {

    private final WebDriver driver;
    private HttpDownload httpDownload;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HttpDownload getHttpDownload() {
        if (httpDownload == null) {
            httpDownload = PageFactory.initElements(driver, HttpDownload.class);
        }
        return httpDownload;
    }
}
