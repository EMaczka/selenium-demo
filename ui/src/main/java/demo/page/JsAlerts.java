package demo.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JsAlerts {

    @FindBy(linkText = "JavaScript Alerts")
    private WebElement pageLink;

    @FindBy(xpath = "//button[contains(text(),'Click for JS Alert')]")
    private WebElement JSAlert;

    @FindBy(xpath = "//button[contains(text(),'Click for JS Confirm')]")
    private WebElement JSConfirm;

    @FindBy(xpath = "//button[contains(text(),'Click for JS Prompt')]")
    private WebElement JSPrompt;

    @FindBy(id = "result")
    private WebElement resultField;

    public JsAlerts() {
    }

    private void goToJsAlertsPage() {
        pageLink.click();
    }

    public String acceptPopup(WebDriver driver) {
        goToJsAlertsPage();
        JSAlert.click();
        Alert popup = driver.switchTo().alert();
        popup.accept();
        return resultField.getText();
    }
}
