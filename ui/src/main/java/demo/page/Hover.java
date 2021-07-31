package demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Hover {

    @FindBy(linkText = "Hovers")
    private WebElement pageLink;

    @FindBy(className = "figure")
    private List<WebElement> avatars;

    @FindBy(className = "figcaption")
    private List<WebElement> captions;

    public Hover() {
    }

    private void goToHoverPage() {
        pageLink.click();
    }

    private boolean hover(WebDriver driver) {
        Actions builder = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,1);

        for (int i=0; i<avatars.size(); i++) {
            builder.moveToElement(avatars.get(i)).build().perform();
            wait.until(ExpectedConditions.visibilityOf(captions.get(i)));
            if (!captions.get(i).isDisplayed()) return false;
        }
        return true;
    }

    public boolean isCaptionVisible(WebDriver driver) {
        goToHoverPage();
        return hover(driver);
    }





}
