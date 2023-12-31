package framework.configuration;

import framework.helpers.PropertyHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Browser {
    private WebDriver driver;
    private String browserType;

    public Browser(String browserType) {
        this.browserType = browserType;
    }

    private void setupChromeDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(PropertyHelper.getImplicitlyWait()));
        driver.manage().window().maximize();
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public WebDriver getDriver() {
        if (driver == null) {
            switch (browserType.toLowerCase()) {
                case "chrome":
                    setupChromeDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser type: " + browserType);
            }
        }
        return driver;
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
