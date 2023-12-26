package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.productsPage.ProductsPage;
import pages.productsPage.components.ProductInfoHelper;

import java.util.List;

public class ProductsSteps {
    private ProductsPage productsPage;

    public ProductsSteps(WebDriver driver) {
        this.productsPage = new ProductsPage(driver);
    }

    public void verifyAllProductsTitleResultContain(String text) {
        List<String> list = productsPage.getProductsTitle();
        Assert.assertListContains(list, element -> element.contains(text), "This product doesn't contain " + text);
    }

    public void verifyAllProductsPriceResultLessThen(Double price) {
        List<Double> list = productsPage.getPricesValue();
        Assert.assertTrue(list.stream().allMatch(element -> element <= price), "This product has more then " + price);
    }

    public void verifyAllProductsDescriptionStartsWithInDiaposon(int startRange, int endRange) {
        List<Integer> list = productsPage.extractPropertyFromDescription(ProductInfoHelper.extractTvDiagonal);
        Assert.assertTrue(list.stream().allMatch(value -> value >= startRange && value <= endRange), "This product not between " + startRange + " and " + endRange);
    }

    public void verifyAllProductsDescriptionContain(String text) {
        List<String> list = productsPage.getProductsDescription();
        Assert.assertTrue(list.stream().allMatch(element -> element.contains(text)), "This product description doesn't contain " + text);
    }
}
