package demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class NestedFrames {

    @FindBy (linkText = "Frames")
    private WebElement pageLink;

    @FindBy (linkText = "Nested Frames")
    private WebElement subPageLink;

    @FindBy (tagName = "body")
    private WebElement frameText;

    public NestedFrames() {
    }

    private void goToNestedFramePage() {
        pageLink.click();
        subPageLink.click();
    }

    private void switchToFrame(WebDriver driver, String frameName) {
        driver.switchTo().frame(frameName);
    }


    public ArrayList<String> getFrameNames(WebDriver driver) {
        goToNestedFramePage();
        ArrayList<String> names = new ArrayList<>();
        switchToFrame(driver, "frame-top");
        switchToFrame(driver, "frame-left");
        names.add(frameText.getText());
        driver.switchTo().defaultContent();
        switchToFrame(driver, "frame-top");
        switchToFrame(driver, "frame-middle");
        names.add(frameText.getText());
        driver.switchTo().defaultContent();
        switchToFrame(driver, "frame-top");
        switchToFrame(driver, "frame-right");
        names.add(frameText.getText());
        driver.switchTo().defaultContent();
        switchToFrame(driver, "frame-bottom");
        names.add(frameText.getText());
        return names;
    }







}
