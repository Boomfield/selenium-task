package pages.catalogPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.catalogPage.helpers.NavigateMenu;

public class CatalogPage extends BasePage {
    private static String catalogNavigateLinkLocator = "//span[@class='catalog-navigation-classifier__item-title-wrapper' and text()='%s']";

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    private By getCatalogNavigateMenuByTextLocator(String text) {
        return By.xpath(String.format(catalogNavigateLinkLocator, text));
    }

    public void clickByCatalogNavigateMenu(NavigateMenu navigateMenu) {
        By element = getCatalogNavigateMenuByTextLocator(navigateMenu.getDisplayName());
        clickElement(element);
    }
}
