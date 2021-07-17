package demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class MultipleWindows {

    @FindBy(linkText = "Multiple Windows")
    private WebElement pageLink;

    @FindBy (linkText = "Click Here")
    private WebElement newWindowLink;

    public MultipleWindows() {
    }

    private void goToMultipleWindowPage() {
        pageLink.click();
    }

    private void callNewWindow() {
        newWindowLink.click();
    }

    public void switchWindow(WebDriver driver) {
        goToMultipleWindowPage();
        String baseWindow = driver.getWindowHandle();
        String newWindow = "";
        callNewWindow();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            if (!window.equals(baseWindow)) {
                newWindow = window;
            }
        }
        driver.switchTo().window(newWindow);
    }
}
