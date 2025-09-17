package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.remote.JsonToWebElementConverter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtils {
    private static String path = "src/test/resources/TestData/";

    public static String getJsonData(String fileName, String field) throws FileNotFoundException {
        FileReader reader = new FileReader(path + fileName + ".json");
        JsonElement jsonElement = JsonParser.parseReader(reader);
        return jsonElement.getAsJsonObject().get(field).getAsString();
    }

    public static String getPropertyData(String fileName, String field) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(path + fileName + ".properties"));
        return properties.getProperty(field);
    }
}