package org.finalExam.utils.data;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Class for getting data from external file for the Web automation feature.
 */
public class WebData {

    private static final String JSON_FILE_PATH = "src/test/resources/web_data.json";
    private static final JsonParser parser = new JsonParser();

    /**
     * Allows to get desired information from the external file.
     * @param neededData String, key in JSON file
     * @return The value of the requested key in the JSON file
     */
    public static String returnData(String neededData) {
        return getJsonDataProperty(neededData);
    }

    /**
     * Method for get data form JSON file.
     * @param property String
     * @return String
     */
    private static String getJsonDataProperty(String property) {
        try {
            Object obj = parser.parse(new FileReader(JSON_FILE_PATH));
            JsonObject jsonObject = (JsonObject) obj;
            return jsonObject.get(property)
                    .getAsString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
