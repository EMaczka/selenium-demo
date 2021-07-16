package demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IFrame {

    @FindBy(linkText = "Frames")
    private WebElement pageLink;

    @FindBy (linkText = "iFrame")
    private WebElement subPageLink;

    @FindBy (id = "tinymce")
    private WebElement editor;

    public IFrame() {
    }

    private void goToIFramePage() {
        pageLink.click();
        subPageLink.click();
    }

    private void activateEditor(WebDriver driver) {
        goToIFramePage();
        driver.switchTo().frame("mce_0_ifr");
    }

    public String writeInEditor(WebDriver driver, String text) {
        activateEditor(driver);
        editor.clear();
        editor.sendKeys(text);
        return editor.getText();
    }
}
