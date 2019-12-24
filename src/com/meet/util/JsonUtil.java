package com.meet.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * JSON字符串生成类
 * @author Pluto
 */
public class JsonUtil {
	/** 实体类转换为JSON */
	public static String toJson(Object obj){
		if(obj == null) {
			return "{}";
		}
		JSONObject jo = new JSONObject(obj);
		return jo.toString();
	}
	
	/** list转换为JSON */
	public static String toJson(Collection<?> coll) {
		if(coll == null) {
			return "[]";
		}
		JSONArray ja = new JSONArray(coll);
		return ja.toString();
	}
	
	/** map转换为JSON */
	public static <K, V> String toJson(Map<K, V> map) {
		if(map == null) {
			return "{}";
		}
		List<Map<K, V>> list = new ArrayList<Map<K, V>>();
		list.add(map);
		String str = JsonUtil.toJson(list);
		return str.substring(1, str.length()-1);
	}
	
	/**
	 * JSON转换为map
	 * @param json
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <K, V> Map<K, V> toMap(String json) {
		return new JSONObject(json).getMap();
	}
	
	 /**
     * 将json字符串转换为List集合
     * @param jsonArrStr
     * @return
     */
    @SuppressWarnings("unchecked")
	public static List<Map<String, Object>> jsonObjList(String jsonArrStr) {
        List<Map<String, Object>> jsonList = new ArrayList<Map<String, Object>>();
        JSONArray jsonArr = null;
        try {
            jsonArr = new JSONArray(jsonArrStr);
            jsonList = (List<Map<String, Object>>)JsonUtil.jsonToList(jsonArr);
        } catch (JSONException e) {
            System.out.println("Json字符串转换异常！");
            e.printStackTrace();
        }
        return jsonList;
    }
    
    /**
     * 将传递近来的json数组转换为List集合
     * @param jsonArr
     * @return
     * @throws JSONException
     */
    private static List<?> jsonToList(JSONArray jsonArr)
            throws JSONException {
        List<Object> jsonToMapList = new ArrayList<Object>();
        for (int i = 0; i < jsonArr.length(); i++) {
            Object object = jsonArr.get(i);
            if (object instanceof JSONArray) {
                jsonToMapList.add(JsonUtil.jsonToList((JSONArray) object));
            } else if (object instanceof JSONObject) {
                jsonToMapList.add(JsonUtil.jsonToMap((JSONObject) object));
            } else {
                jsonToMapList.add(object);
            }
        }
        return jsonToMapList;
    }
    
    /**
     * 将传递近来的json对象转换为Map集合
     * @param jsonObj
     * @return
     * @throws JSONException
     */
    @SuppressWarnings("unchecked")
    private static Map<String, Object> jsonToMap(JSONObject jsonObj)
            throws JSONException {
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        Iterator<String> jsonKeys = jsonObj.keys();
        while (jsonKeys.hasNext()) {
            String jsonKey = jsonKeys.next();
            Object jsonValObj = jsonObj.get(jsonKey);
            if (jsonValObj instanceof JSONArray) {
                jsonMap.put(jsonKey, JsonUtil.jsonToList((JSONArray) jsonValObj));
            } else if (jsonValObj instanceof JSONObject) {
                jsonMap.put(jsonKey, JsonUtil.jsonToMap((JSONObject) jsonValObj));
            } else {
                jsonMap.put(jsonKey, jsonValObj);
            }
        }
        return jsonMap;
    }
	
}
