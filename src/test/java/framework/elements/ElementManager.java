package framework.elements;

import framework.helpers.PropertyHelper;
import framework.wait.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

public class ElementManager {
    private WebDriver driver;
    private Waiter waiter;
    private Actions actions;
    public static int resultLoadingExpWait = PropertyHelper.getExplicitlyWaitOneSec();
    public static int defaultExpWait = PropertyHelper.getDefaultExplicitlyWait();

    public ElementManager(WebDriver driver) {
        this.driver = driver;
        this.waiter = new Waiter(driver);
        this.actions = new Actions(driver);
    }

    protected WebElement findElement(By element, int sec) {
        waiter.isElementPresent(element, sec);
        return driver.findElement(element);
    }

    public void scrollIntoView(By element, int sec) {
        WebElement el = findElement(element, sec);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", el);
    }

    public void clickElement(By element, int sec) {
        WebElement el = waiter.waitElementIsClickable(element, sec);
        el.click();
    }

    protected List<WebElement> findElements(By element) {
        return driver.findElements(element);
    }

    public void moveMouseOnElement(By element, int sec) {
        WebElement el = findElement(element, sec);
        actions.moveToElement(el).perform();
    }

    public void sendKey(By element, String text, int sec) {
        WebElement el = findElement(element, sec);
        el.sendKeys(text);
    }

    public List<String> getElementsTextList(By locator) {
        List<WebElement> elements = findElements(locator);
        return elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
