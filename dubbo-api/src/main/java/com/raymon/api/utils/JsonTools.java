package com.raymon.api.utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class JsonTools {
	/**
	 * 将json格式的字符串转换为map
	 * @param json
	 * @return
	 */
	public static Map<String, Object> jsonToMap(String json) {
		Map<String, Object> map = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		try {
			map = mapper.readValue(json, new TypeReference<HashMap<String, Object>>() {});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	public static void main(String[] args) {
		//String json = "{\"method\":\"\",\"params\":[{\"skuString\":\"1_31772\"},{\"skuString2\":\"1_3177222222\"}]}";
	//List list = (List)JsonTools.jsonToMap(json).get("params");
		//Map<String,String> s = (Map<String,String>)list.get(1);
	}
}
