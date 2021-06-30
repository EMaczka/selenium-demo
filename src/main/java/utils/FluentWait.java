package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class FluentWait {

    private WebDriver driver;

    public FluentWait(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement fluentWait(final By locator) {

        org.openqa.selenium.support.ui.FluentWait<WebDriver> wait = new org.openqa.selenium.support.ui.FluentWait<>(driver)
                .pollingEvery(Duration.ofMillis(2000))
                .withTimeout(Duration.ofSeconds(15))
                .ignoring(NoSuchElementException.class);
        WebElement foo = wait.until(new Function<>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return foo;
    }
}
