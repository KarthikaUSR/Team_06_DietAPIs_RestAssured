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

//    private final static String jsonPath = "src/test/resources/Data/Dietician_Creation_Data.json";
//    private static JSONParser parser = new JSONParser();

    private final static String jsonPath = "src/test/resources/Data/Dietician_Creation_Data.json";

    public static JSONObject getJsonDataForKey(String Key) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(jsonPath));
        return (JSONObject) jsonObject.get(Key);

    }
}