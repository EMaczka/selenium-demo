package demo.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Highlighting {

    @FindBy(linkText = "Large & Deep DOM")
    private WebElement pageLink;

    @FindBy(id = "sibling-2.3")
    private WebElement elementToHighlight;

    public Highlighting() {
    }

    private void goToHighlightPage() {
        pageLink.click();
    }

    private void highlightElement(WebDriver driver, int duration) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String original_style = elementToHighlight.getAttribute("style");

        js.executeScript(
                "arguments[0].setAttribute(arguments[1], arguments[2])",
                elementToHighlight,
                "style",
                "border: 2px solid red; border-style: dashed;");

        if (duration > 0) {
            Thread.sleep(duration * 1000L);
            js.executeScript(
                    "arguments[0].setAttribute(arguments[1], arguments[2])",
                    elementToHighlight,
                    "style",
                    original_style);
        }
    }

    public void highlighting(WebDriver driver, int duration) {
        goToHighlightPage();
        try {
            highlightElement(driver, duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
