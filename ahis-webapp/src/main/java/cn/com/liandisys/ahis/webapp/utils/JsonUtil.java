package cn.com.liandisys.ahis.webapp.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {

	private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

	public static String getJsonString(LinkedHashMap<String, Object> map) {
		try {
			JSONObject json = (JSONObject) convertObjectToJsonObject(map);
			return json.toString();
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private static Object convertObjectToJsonObject(Object obj) throws JSONException {
		if (obj == null) {
			logger.debug("<>");
			return "";
		} else if (obj instanceof String) {
			logger.debug("<" + (String) obj + ">");
			return obj;
		} else if (obj instanceof List<?>) {
			JSONArray json = new JSONArray();
			logger.debug("[");
			for (Object entry : (List<Object>) obj) {
				json.put(convertObjectToJsonObject(entry));
			}
			logger.debug("]");
			return json;
		} else if (obj instanceof LinkedHashMap<?, ?>) {
			JSONObject json = new JSONObject();
			logger.debug("{");
			LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) obj;
			for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
				Object key = it.next();
				logger.debug(key + ":");
				json.put(key.toString(), convertObjectToJsonObject(map.get(key)));
			}

			logger.debug("}");
			return json;
		}
		return "";
	}

	@SuppressWarnings("unchecked")
	public static LinkedHashMap<String, Object> getJsonMap(String json) {
		try {
			JSONObject root = new JSONObject(json);
			return (LinkedHashMap<String, Object>) convertJsonToObject(root);
		} catch (JSONException e) {
			logger.warn(e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private static Object convertJsonToObject(Object obj) throws JSONException {
		if (obj instanceof String) {
			return obj;
		} else if (obj instanceof JSONArray) {
			JSONArray json = (JSONArray) obj;
			List<Object> list = new ArrayList<Object>();
			for (int i = 0; i < json.length(); i++) {
				list.add(convertJsonToObject(json.get(i)));
			}
			return list;
		} else if (obj instanceof JSONObject) {
			JSONObject json = (JSONObject) obj;
			LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
			for (Iterator<String> itr = json.keys(); itr.hasNext();) {
				String key = itr.next();
				map.put(key, convertJsonToObject(json.get(key)));
			}
			return map;
		}
		return null;
	}
}
