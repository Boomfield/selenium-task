package onliner.pages.tests;

import framework.configuration.Browser;
import framework.helpers.PropertyHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    protected WebDriver driver;
    protected Browser browser;

    @BeforeSuite
    public void onStart() {
        PropertyHelper.initProperty("src/test/resources/config.properties");
        browser = new Browser(PropertyHelper.getBrowser());
    }

    @BeforeMethod
    public void setUp() {
        driver = browser.getDriver();
        browser.navigateToUrl(PropertyHelper.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        browser.closeBrowser();
    }
}
