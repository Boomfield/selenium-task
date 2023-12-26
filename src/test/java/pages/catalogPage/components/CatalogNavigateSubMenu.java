package pages.catalogPage.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.catalogPage.components.helpers.ElectronicCategory;
import pages.catalogPage.components.helpers.TelevisionCategory;

public class CatalogNavigateSubMenu extends BasePage {
    private static String navigationLinkLocator = "//div[@style='display: block;']//div[contains(text(),'%s')]";
    private static String productNavigationLinkLocator = "//div[contains(@class,'item_active')]//span[contains(@class,'dropdown-title') and normalize-space(text())='%s']";

    public CatalogNavigateSubMenu(WebDriver driver) {
        super(driver);
    }

    private By getCategoryByTextLocator(String text) {
        return By.xpath(String.format(navigationLinkLocator, text));
    }

    private By getProductsByTextLocator(String text) {
        return By.xpath(String.format(productNavigationLinkLocator, text));
    }

    public void moveMouseOnCategory(ElectronicCategory electronicCategory) {
        moveMouseOnElement(getCategoryByTextLocator(electronicCategory.getDisplayName()));
    }

    public void clickByProducts(TelevisionCategory televisionCategory) {
        By element = getProductsByTextLocator(televisionCategory.getDisplayName());
        clickElement(element);
    }
}
