package Utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;


public class JsonUtils {

    private final static String jsonPath = "src/test/resources/Data/Dietician_Creation_Data.json";
    private static JSONParser parser = new JSONParser();

    public static String getRequestBody(String jsonKey) {
        JSONObject jsonObject;
        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(jsonPath));
            return jsonObject.toString();
        } catch (IOException | ParseException e) {
            throw new RuntimeException("Error while reading or parsing the JSON file: " + jsonPath, e);
        }
    }

    public static Object getJsonDataForKey(String key) {
        JSONObject jsonObject;
        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(jsonPath));
            return jsonObject.get(key);
        } catch (IOException | ParseException e) {
            throw new RuntimeException("Error while reading or parsing the JSON file: " + jsonPath, e);
        }
    }
}