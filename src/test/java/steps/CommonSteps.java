package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import wait.Waiter;

public class CommonSteps {
    private Waiter waiter;
    private WebDriver driver;

    public CommonSteps(WebDriver driver) {
        this.driver = driver;
        this.waiter = new Waiter(driver);
    }

    public void verifyCurrentUrlContain(String partUrl) {
        waiter.waitForUrlContains(partUrl, 5);
        Assert.assertTrue(driver.getCurrentUrl().contains(partUrl), "URL doesn't contain expected part: " + partUrl);
    }
}
