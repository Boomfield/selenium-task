package onliner.pages.catalogPage.components;

import framework.elements.ElementManager;
import onliner.pages.catalogPage.components.helpers.ElectronicMenuDisplayer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import onliner.pages.catalogPage.components.helpers.TelevisionSubMenuDisplayer;

public class CatalogueNavigateSubMenu {
    private static String navigationLinkLocator = "//div[@style='display: block;']//div[contains(text(),'%s')]";
    private static String productNavigationLinkLocator = "//div[contains(@class,'item_active')]//span[contains(@class,'dropdown-title') and normalize-space(text())='%s']";
    private final ElementManager elementManager;

    public CatalogueNavigateSubMenu(WebDriver driver) {
        this.elementManager = new ElementManager(driver);
    }

    private By getCategoryByTextLocator(String text) {
        return By.xpath(String.format(navigationLinkLocator, text));
    }

    private By getProductsByTextLocator(String text) {
        return By.xpath(String.format(productNavigationLinkLocator, text));
    }

    public void moveMouseOnCategory(ElectronicMenuDisplayer electronicMenu) {
        elementManager.moveMouseOnElement(getCategoryByTextLocator(electronicMenu.getDisplayName()), ElementManager.defaultExpWait);
    }

    public void clickByProducts(TelevisionSubMenuDisplayer televisionSubMenu) {
        By element = getProductsByTextLocator(televisionSubMenu.getDisplayName());
        elementManager.clickElement(element, ElementManager.defaultExpWait);
    }
}
