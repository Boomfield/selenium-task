package onliner.pages.steps;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import onliner.pages.productsPage.ProductsPage;
import onliner.pages.productsPage.components.ProductInfoHelper;

import java.util.List;

public class ProductsSteps {
    private ProductsPage productsPage;
    private final SoftAssert softAssert;

    public ProductsSteps(WebDriver driver) {
        this.productsPage = new ProductsPage(driver);
        this.softAssert = new SoftAssert();
    }

    private void verifyAllProductsTitleResultContain(String text) {
        List<String> list = productsPage.getProductsTitle();
        softAssert.assertTrue(list.stream().allMatch(element -> element.contains(text)), "This product doesn't contain " + text);
    }

    private void verifyAllProductsPriceResultLessThen(Double price) {
        List<Double> list = productsPage.getPricesValue();
        softAssert.assertTrue(list.stream().allMatch(element -> element <= price), "This product has more then " + price);
    }

    private void verifyAllProductsDescriptionStartsWithInDiaposon(int startRange, int endRange) {
        List<Integer> list = productsPage.extractPropertyFromDescription(ProductInfoHelper.extractTvDiagonal);
        softAssert.assertTrue(list.stream().allMatch(value -> value >= startRange && value <= endRange), "This product not between " + startRange + " and " + endRange);
    }

    private void verifyAllProductsDescriptionContain(String text) {
        List<String> list = productsPage.getProductsDescription();
        softAssert.assertTrue(list.stream().allMatch(element -> element.contains(text)), "This product description doesn't contain " + text);
    }

    public void verifyTelevisionFilters(String titleText, Double price, int startRange, int endRange, String descriptionText) {
        verifyAllProductsTitleResultContain(titleText);
        verifyAllProductsPriceResultLessThen(price);
        verifyAllProductsDescriptionStartsWithInDiaposon(startRange, endRange);
        verifyAllProductsDescriptionContain(descriptionText);
        softAssert.assertAll();
    }
}
