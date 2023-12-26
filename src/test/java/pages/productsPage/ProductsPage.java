package pages.productsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {
    private static String filterLinkLocator = "//div[@class='schema-filter__label' and .//span[text()='%s']]/following-sibling::div//span[text()='%s']";
    private static By inputBeforePriceLinkLocator = By.xpath("//input[@placeholder='до']");
    private static By priceValueLinkLocator = By.xpath("//a[contains(@class,'price-value')]");
    private static By productTitleLinkLocator = By.className("schema-product__title");
    private static By productDescriptionLinkLocator = By.className("schema-product__description");
    private static By productsBlockLinkLocator = By.id("schema-products");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private By getFilterByTextLocator(String nameFilterBlock, String nameFilter) {
        return By.xpath(String.format(filterLinkLocator, nameFilterBlock, nameFilter));
    }

    private void clickFilter(String filterBlock, String filter) {
        By element = getFilterByTextLocator(filterBlock, filter);
        scrollIntoVieW(element);
        clickElement(element);
    }

    public void writeBeforePriceInputFilter(Double value) {
        sendKey(inputBeforePriceLinkLocator, Double.toString(value));
    }

    //[от 1399,00 р. -> 1399.0]
    private String convertPriceToString(String price) {
        return price.replaceAll("[^0-9,]+", "").replace(',', '.');
    }

    public List<Double> getPricesValue() {
        List<String> productsPrInString = getElementsTextList(priceValueLinkLocator);
        return productsPrInString.stream()
                .map(this::convertPriceToString)
                .mapToDouble(Double::parseDouble)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<String> getProductsTitle() {
        return getElementsTextList(productTitleLinkLocator);
    }

    public List<String> getProductsDescription() {
        return getElementsTextList(productDescriptionLinkLocator);
    }

    public List<Integer> extractPropertyFromDescription(Function<String, Integer> extractData) {
        List<String> descriptions = getProductsDescription();
        return descriptions.stream()
                .map(extractData)
                .collect(Collectors.toList());
    }

    public void clickFilters(Map<String, String> filterMap) {
        for (Map.Entry<String, String> entry : filterMap.entrySet()) {
            clickFilter(entry.getValue(), entry.getKey());
        }
    }

    public void waitForResultsLoaded() {
        try {
            waiter.waitAttributeToBe(productsBlockLinkLocator, "class",
                    "schema-products schema-products_processing", 1);
        } catch (Exception ignored) {
            System.out.println(ignored.getMessage());
        }
    }
}
