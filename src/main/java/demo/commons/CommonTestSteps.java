package demo.commons;

import org.openqa.selenium.WebDriver;

public class CommonTestSteps {

    private final WebDriver driver;

    public CommonTestSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void loadMainPage(String url) {
        driver.navigate().to(url);
    }
}
