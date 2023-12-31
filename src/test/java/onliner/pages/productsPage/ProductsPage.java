package onliner.pages.productsPage;

import framework.elements.ElementManager;
import onliner.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {
    private static String filterLinkLocator = "//div[@class='schema-filter__label' and .//span[text()='%s']]/following-sibling::div//span[contains(text(),'%s')]";
    private static By inputBeforePriceLinkLocator = By.xpath("//input[@placeholder='до']");
    private static By priceValueLinkLocator = By.xpath("//a[contains(@class,'price-value')]");
    private static By productTitleLinkLocator = By.className("schema-product__title");
    private static By productDescriptionLinkLocator = By.className("schema-product__description");
    private static By productsBlockLinkLocator = By.id("schema-products");

    public ProductsPage(WebDriver driver) {
        super(driver, productTitleLinkLocator);
    }

    private By getFilterByTextLocator(String nameFilterBlock, String nameFilter) {
        return By.xpath(String.format(filterLinkLocator, nameFilterBlock, nameFilter));
    }

    public void clickFilter(String filterBlock, String filter) {
        By element = getFilterByTextLocator(filterBlock, filter);
        elementManager.scrollIntoView(element, ElementManager.defaultExpWait);
        elementManager.clickElement(element, ElementManager.defaultExpWait);
    }

    public void applyFiltersAndPrice(Double price, Map<String, String> filters) {
        writeBeforePriceInputFilter(price);
        for (Map.Entry<String, String> entry : filters.entrySet()) {
            clickFilter(entry.getValue(), entry.getKey());
        }
        waitForResultsLoaded();
    }

    public void writeBeforePriceInputFilter(Double value) {
        elementManager.sendKey(inputBeforePriceLinkLocator, Double.toString(value), ElementManager.defaultExpWait);
    }

    private String convertPriceToString(String price) {
        return price.replaceAll("[^0-9,]+", "").replace(',', '.');
    }

    public List<Double> getPricesValue() {

        List<String> productsPrInString = elementManager.getElementsTextList(priceValueLinkLocator);
        return productsPrInString.stream()
                .map(this::convertPriceToString)
                .mapToDouble(Double::parseDouble)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<String> getProductsTitle() {
        return elementManager.getElementsTextList(productTitleLinkLocator);
    }

    public List<String> getProductsDescription() {
        return elementManager.getElementsTextList(productDescriptionLinkLocator);
    }

    public List<Integer> extractPropertyFromDescription(Function<String, Integer> extractData) {
        List<String> descriptions = getProductsDescription();
        return descriptions.stream()
                .map(extractData)
                .collect(Collectors.toList());
    }

    public void waitForResultsLoaded() {
        try {
            waiter.waitAttributeToBe(productsBlockLinkLocator, "class",
                    "schema-products schema-products_processing", ElementManager.resultLoadingExpWait);
            waiter.waitAttributeToBe(productsBlockLinkLocator, "class",
                    "schema-products", ElementManager.resultLoadingExpWait);
        } catch (Exception ignored) {
            System.out.println(ignored.getMessage());
        }
    }
}
