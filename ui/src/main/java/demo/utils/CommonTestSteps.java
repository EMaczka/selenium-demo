package demo.utils;

import demo.page.PageObjectManager;
import org.openqa.selenium.WebDriver;

public class CommonTestSteps {

    private final PageObjectManager pageObjectManager;
    private final WebDriver driver;

    public CommonTestSteps(WebDriver driver) {
        this.driver = driver;
        pageObjectManager = new PageObjectManager(driver);
    }

    public void loadMainPage(String url) {
        driver.navigate().to(url);
    }
}
