package tests;

import org.testng.annotations.Parameters;
import pages.productsPage.components.TvSectionData;
import tests.data.PagesUrl;
import helpers.PropertyHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.catalogPage.CatalogPage;
import pages.catalogPage.components.CatalogNavigateSubMenu;
import pages.catalogPage.components.helpers.ElectronicCategory;
import pages.catalogPage.components.helpers.TelevisionCategory;
import pages.catalogPage.helpers.NavigateMenu;
import pages.components.HeaderComponent;
import pages.components.helpers.HeaderMenu;
import pages.productsPage.ProductsPage;
import steps.CommonSteps;
import steps.ProductsSteps;

public class TelevisionsSearchTest extends BaseTest {
    private ProductsPage productsPage;
    private ProductsSteps productsSteps;
    private CatalogNavigateSubMenu catalogNavigateSubMenu;
    private HeaderComponent headerComponent;
    private CatalogPage catalogPage;
    private CommonSteps commonSteps;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        headerComponent = new HeaderComponent(driver);
        catalogPage = new CatalogPage(driver);
        catalogNavigateSubMenu = new CatalogNavigateSubMenu(driver);
        productsPage = new ProductsPage(driver);
        productsSteps = new ProductsSteps(driver);
        commonSteps = new CommonSteps(driver);
    }

    @Test
    @Parameters({"manufacturer", "maxPrice", "minDiagonal", "maxDiagonal", "resolution"})
    public void testTelevisionsSearch(String manufacturer, Double maxPrice, int minDiagonal, int maxDiagonal, String resolution) {
        browser.navigateToUrl(PropertyHelper.getUrl());
        headerComponent.clickByHeaderMenu(HeaderMenu.CATALOG);
        commonSteps.verifyCurrentUrlContain(PropertyHelper.getUrlCatalog());
        catalogPage.clickByCatalogNavigateMenu(NavigateMenu.ELECTRONIC);
        catalogNavigateSubMenu.moveMouseOnCategory(ElectronicCategory.TELEVISIONS);
        catalogNavigateSubMenu.clickByProducts(TelevisionCategory.TV);
        commonSteps.verifyCurrentUrlContain(PagesUrl.TV_URL);
        productsPage.clickFilter(TvSectionData.MANUFACTURER_BLOCK, manufacturer);
        productsPage.writeBeforePriceInputFilter(maxPrice);
        productsPage.clickFilter(TvSectionData.RESOLUTION_BLOCK, resolution);
        productsPage.clickFilter(TvSectionData.DIAGONAL_BLOCK, String.valueOf(minDiagonal));
        productsPage.clickFilter(TvSectionData.DIAGONAL_BLOCK, String.valueOf(maxDiagonal));
        productsPage.waitForResultsLoaded();
        productsSteps.verifyAllProductsTitleResultContain(manufacturer);
        productsSteps.verifyAllProductsPriceResultLessThen(maxPrice);
        productsSteps.verifyAllProductsDescriptionContain(resolution);
        productsSteps.verifyAllProductsDescriptionStartsWithInDiaposon(minDiagonal, maxDiagonal);
    }
}

