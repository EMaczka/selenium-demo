package demo.page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContextMenu {

    @FindBy(linkText = "Context Menu")
    private WebElement pageLink;

    @FindBy(id = "hot-spot")
    private WebElement box;

    public ContextMenu() {
    }

    private void goToContextMenuPage() {
        pageLink.click();
    }

    public String getAlertText(WebDriver driver) {
        goToContextMenuPage();

        Actions action = new Actions(driver);
        action.contextClick(box).perform();
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
}
