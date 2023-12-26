package pages.productsPage.components;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductInfoHelper {
    //[43" 1920x1080 (Full HD), -> 43]
    public static Function<String, Integer> extractTvDiagonal = d -> {
        Matcher matcher = Pattern.compile("^\\d+").matcher(d);
        return matcher.find() ? Integer.parseInt(matcher.group(0)) : null;
    };
}
