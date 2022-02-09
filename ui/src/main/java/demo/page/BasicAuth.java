package demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasicAuth {

    @FindBy(linkText = "Basic Auth")
    private WebElement pageLink;

    @FindBy(tagName = "p")
    private WebElement paragraph;

    public BasicAuth() {
    }

    private void goToBasicAuthPage() {
        pageLink.click();
    }

    private void provideCredentials(WebDriver driver) {
        goToBasicAuthPage();
        String pageURL = driver.getCurrentUrl();
        String trimmedPageURL = pageURL.replace("https://","");
        String URL = "http://admin:admin@"+trimmedPageURL;
        driver.get(URL);
    }

    public String getMessage(WebDriver driver) {
        provideCredentials(driver);
        return paragraph.getText();
    }
}
