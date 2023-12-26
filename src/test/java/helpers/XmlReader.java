package helpers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;

public class XmlReader<T> {
    public static <T> T readXmlFile(String filePath, Class<T> valueType) {
        try {
            ObjectMapper objectMapper = new XmlMapper();
            return objectMapper.readValue(new File(filePath), valueType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
