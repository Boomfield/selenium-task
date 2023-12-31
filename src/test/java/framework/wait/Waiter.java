package framework.wait;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    private WebDriver driver;
    private WebDriverWait wait;

    public Waiter(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator, int sec) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitAttributeToBe(By element, String attribute, String value, int seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
    }

    public WebElement waitElementIsClickable(By element, int sec) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}

