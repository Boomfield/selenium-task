package pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.components.helpers.HeaderMenu;

public class HeaderComponent extends BasePage {
    private static String HeaderLinkLocator = "//span[@class='b-main-navigation__text' and text()='%s'] ";

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    private By getHeaderByTextLocator(String text) {
        return By.xpath(String.format(HeaderLinkLocator, text));
    }

    public void clickByHeaderMenu(HeaderMenu headerMenu) {
        By element = getHeaderByTextLocator(headerMenu.getDisplayName());
        clickElement(element);
    }
}
