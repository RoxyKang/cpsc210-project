package JSONController;

import org.json.JSONArray;

public class JSON4SQL {
    public static String getSQL(String jsonName, String sqlName){
        String sql = "";
        JSONArray jsonArray = JSONHelper.getJSONArray(jsonName, JSONHelper.jsonType.SQL);
        if (jsonArray != null && jsonArray.length() > 0) {
            for (int i = 0; i < jsonArray.length(); i++) {
                if (jsonArray.getJSONObject(i).get("Name").toString().equals(sqlName)) {
                    sql = jsonArray.getJSONObject(i).get("SqlStr").toString();
                    break;
                }
            }
        }
        return sql;
    }
}
