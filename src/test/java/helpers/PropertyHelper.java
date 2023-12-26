package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyHelper {
    private static Properties properties;

    public static Properties initProperty(String pathToPropertiesFile) {
        properties = new Properties();
        try (FileInputStream input = new FileInputStream(pathToPropertiesFile)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String getUrlCatalog() {
        return properties.getProperty("urlCatalog");
    }

    public static String getBrowser() {
        return properties.getProperty("browser");
    }

}