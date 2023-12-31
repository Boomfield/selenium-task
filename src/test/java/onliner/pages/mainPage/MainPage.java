package onliner.pages.mainPage;

import onliner.pages.BasePage;
import onliner.pages.components.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public final HeaderComponent headerComponent;
    private static By bannerLinkLocator = By.className("b-tiles-banner");

    public MainPage(WebDriver driver) {
        super(driver, bannerLinkLocator);
        this.headerComponent = new HeaderComponent(driver);
    }
}
