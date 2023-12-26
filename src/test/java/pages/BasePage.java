package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import wait.Waiter;

import java.util.List;
import java.util.stream.Collectors;

public class BasePage {
    private WebDriver driver;
    private Actions actions;
    protected Waiter waiter;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.waiter = new Waiter(driver);
    }

    protected void scrollIntoVieW(By element) {
        WebElement el = waiter.waitElementIsPresent(element, 5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", el);
    }

    protected void clickElement(By element) {
        waiter.waitElementIsClickable(element, 5).click();
    }

    protected List<WebElement> findElements(By element) {
        return driver.findElements(element);
    }

    protected void moveMouseOnElement(By element) {
        WebElement el = driver.findElement(element);
        actions.moveToElement(el).perform();
    }

    protected void sendKey(By element, String text) {
        WebElement el = driver.findElement(element);
        el.sendKeys(text);
    }

    protected List<String> getElementsTextList(By locator) {
        List<WebElement> elements = findElements(locator);
        return elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
