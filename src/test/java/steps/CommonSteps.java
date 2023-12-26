package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import wait.Waiter;

public class CommonSteps {
    Waiter waiter;
    WebDriver driver;

    public CommonSteps(WebDriver driver) {
        this.waiter = new Waiter(driver);
        this.driver = driver;
    }

    public void verifyCurrentUrlEquals(String partUrl) {
        waiter.waitForUrlContains(partUrl, 5);
        Assert.assertTrue(driver.getCurrentUrl().contains(partUrl), "URL doesn't contain expected part: " + partUrl);
    }
}
