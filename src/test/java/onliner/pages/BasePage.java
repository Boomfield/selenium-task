package onliner.pages;

import framework.elements.ElementManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import framework.wait.Waiter;
import org.testng.Assert;

public abstract class BasePage {
    protected Waiter waiter;
    protected ElementManager elementManager;

    public BasePage(WebDriver driver, By element) {
        this.waiter = new Waiter(driver);
        this.elementManager = new ElementManager(driver);
        verifyPageIsOpen(element);
    }

    private void verifyPageIsOpen(By element) {
        boolean result = waiter.isElementPresent(element, ElementManager.defaultExpWait);
        Assert.assertTrue(result, "Page wasn't loaded");
    }
}
