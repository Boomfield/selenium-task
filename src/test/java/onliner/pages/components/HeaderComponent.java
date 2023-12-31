package onliner.pages.components;

import framework.elements.ElementManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import onliner.pages.components.helpers.HeaderMenuDisplayer;

public class HeaderComponent {
    private static String HeaderLinkLocator = "//span[@class='b-main-navigation__text' and text()='%s'] ";
    private final ElementManager elementManager;

    public HeaderComponent(WebDriver driver) {
        this.elementManager = new ElementManager(driver);
    }

    private By getHeaderByTextLocator(String text) {
        return By.xpath(String.format(HeaderLinkLocator, text));
    }

    public void clickByHeaderMenu(HeaderMenuDisplayer headerMenu) {
        By element = getHeaderByTextLocator(headerMenu.getDisplayName());
        elementManager.clickElement(element, ElementManager.defaultExpWait);
    }
}
