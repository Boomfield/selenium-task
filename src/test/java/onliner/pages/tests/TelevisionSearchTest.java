package onliner.pages.tests;

import onliner.pages.mainPage.MainPage;
import org.testng.annotations.Parameters;
import onliner.pages.productsPage.components.TvSectionData;
import org.testng.annotations.Test;
import onliner.pages.catalogPage.CataloguePage;
import onliner.pages.catalogPage.components.helpers.ElectronicMenuDisplayer;
import onliner.pages.catalogPage.components.helpers.TelevisionSubMenuDisplayer;
import onliner.pages.catalogPage.helpers.NavigateMenuDisplayer;
import onliner.pages.components.helpers.HeaderMenuDisplayer;
import onliner.pages.steps.ProductsSteps;
import onliner.pages.productsPage.ProductsPage;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class TelevisionSearchTest extends BaseTest {
    private ProductsPage productsPage;
    private ProductsSteps productsSteps;
    private CataloguePage cataloguePage;
    private MainPage mainPage;

    @Test
    @Parameters({"manufacturer", "maxPrice", "minDiagonal", "maxDiagonal", "resolution"})
    public void testTelevisionSearch(String manufacturer, Double maxPrice, int minDiagonal, int maxDiagonal, String resolution) {
        mainPage = new MainPage(driver);
        mainPage.headerComponent.clickByHeaderMenu(HeaderMenuDisplayer.CATALOGUE);
        cataloguePage = new CataloguePage(driver);
        cataloguePage.selectProductsInNavigateMenu(NavigateMenuDisplayer.ELECTRONIC, ElectronicMenuDisplayer.TELEVISIONS, TelevisionSubMenuDisplayer.TV);
        HashMap<String, String> filters = new LinkedHashMap<>();
        filters.put(manufacturer, TvSectionData.MANUFACTURER_BLOCK);
        filters.put(resolution, TvSectionData.RESOLUTION_BLOCK);
        filters.put(String.valueOf(minDiagonal), TvSectionData.DIAGONAL_BLOCK);
        filters.put(String.valueOf(maxDiagonal), TvSectionData.DIAGONAL_BLOCK);
        productsPage = new ProductsPage(driver);
        productsPage.applyFiltersAndPrice(maxPrice, filters);
        productsSteps = new ProductsSteps(driver);
        productsSteps.verifyTelevisionFilters(manufacturer, maxPrice, minDiagonal, maxDiagonal, resolution);
    }
}

