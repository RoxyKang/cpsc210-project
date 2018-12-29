package JSONController;

import org.json.JSONArray;

import java.io.*;


public class JSONHelper {
    public enum jsonType {
        SQL
    }

    public static JSONArray getJSONArray(String jsonName, jsonType type) {
        String path = "./json/" + type.toString() + "/" + jsonName + ".json";
        JSONArray jsonarray = new JSONArray(ReadFile(path));
        return jsonarray;
    }


    public static String ReadFile(String path) {
        String laststr = "";
        File file = new File(path);
        BufferedReader reader = null;
        try {
            FileInputStream in = new FileInputStream(file);
            reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr = laststr + tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException el) {
                }
            }
        }
        return laststr;

    }

}
