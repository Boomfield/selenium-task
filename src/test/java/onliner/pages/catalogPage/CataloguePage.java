package onliner.pages.catalogPage;

import framework.elements.ElementManager;
import onliner.pages.BasePage;
import onliner.pages.catalogPage.components.CatalogueNavigateSubMenu;
import onliner.pages.catalogPage.components.helpers.ElectronicMenuDisplayer;
import onliner.pages.catalogPage.components.helpers.TelevisionSubMenuDisplayer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import onliner.pages.catalogPage.helpers.NavigateMenuDisplayer;

public class CataloguePage extends BasePage {
    private static String catalogNavigateLinkLocator = "//span[@class='catalog-navigation-classifier__item-title-wrapper' and text()='%s']";
    private static By catalogTitleLinkLocator = By.className("catalog-navigation__title");
    private CatalogueNavigateSubMenu catalogueNavigateSubMenu;

    public CataloguePage(WebDriver driver) {
        super(driver, catalogTitleLinkLocator);
        this.catalogueNavigateSubMenu = new CatalogueNavigateSubMenu(driver);
    }

    private By getCatalogNavigateMenuByTextLocator(String text) {
        return By.xpath(String.format(catalogNavigateLinkLocator, text));
    }

    private void clickByCatalogNavigateMenu(NavigateMenuDisplayer navigateMenu) {
        By element = getCatalogNavigateMenuByTextLocator(navigateMenu.getDisplayName());
        elementManager.clickElement(element, ElementManager.defaultExpWait);
    }

    public void selectProductsInNavigateMenu(NavigateMenuDisplayer navigateMenu, ElectronicMenuDisplayer electronicMenu, TelevisionSubMenuDisplayer televisionSubMenu) {
        clickByCatalogNavigateMenu(navigateMenu);
        catalogueNavigateSubMenu.moveMouseOnCategory(electronicMenu);
        catalogueNavigateSubMenu.clickByProducts(televisionSubMenu);
    }
}
