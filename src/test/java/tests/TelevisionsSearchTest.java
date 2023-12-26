package tests;

import tests.data.PagesUrl;
import helpers.PropertyHelper;
import helpers.XmlReader;
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
import tests.data.helpers.TelevisionsSearchData;
import tests.data.helpers.AssertParameters;

import java.util.Map;

public class TelevisionsSearchTest extends BaseTest {
    private ProductsPage productsPage;
    private ProductsSteps productsSteps;
    private CatalogNavigateSubMenu catalogNavigateSubMenu;
    private HeaderComponent headerComponent;
    private CatalogPage catalogPage;
    private CommonSteps commonSteps;
    private Map<String, String> filters;
    private AssertParameters assertParameters;
    private static final String TELEVISION_SEARCH_DATA = "src//test//resources//television-search-data.xml";

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
        TelevisionsSearchData televisionsSearchData = XmlReader.readXmlFile(TELEVISION_SEARCH_DATA, TelevisionsSearchData.class);
        filters = televisionsSearchData.toMap();
        assertParameters = televisionsSearchData.getTestParameters();
    }

    @Test
    public void testTelevisionsSearch() {
        browser.navigateToUrl(PropertyHelper.getUrl());
        headerComponent.clickByHeaderMenu(HeaderMenu.CATALOG);
        commonSteps.verifyCurrentUrlEquals(PropertyHelper.getUrlCatalog());
        catalogPage.clickByCatalogNavigateMenu(NavigateMenu.ELECTRONIC);
        catalogNavigateSubMenu.moveMouseOnCategory(ElectronicCategory.TELEVISIONS);
        catalogNavigateSubMenu.clickByProducts(TelevisionCategory.TV);
        commonSteps.verifyCurrentUrlEquals(PagesUrl.TV_URL);
        productsPage.clickFilters(filters);
        productsPage.writeBeforePriceInputFilter(assertParameters.getMaxPrice());
        productsPage.waitForResultsLoaded();

        productsSteps.verifyAllProductsTitleResultContain(assertParameters.getManufacturer());
        productsSteps.verifyAllProductsPriceResultLessThen(assertParameters.getMaxPrice());
        productsSteps.verifyAllProductsDescriptionStartsWithInDiaposon(assertParameters.getMinDiagonal(), assertParameters.getMaxDiagonal());
        productsSteps.verifyAllProductsDescriptionContain(assertParameters.getResolution());
    }
}

