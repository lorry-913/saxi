package com.midea.saximanager.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.TreeMap;

public class GetRequestParams {

	public static String paramsGet(HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		Map<String, String[]> params = request.getParameterMap();
		Map<String, String[]> treeParams = new TreeMap<String, String[]>(params);
		String queryString = "";
		for (String key : treeParams.keySet()) {
			String[] values = treeParams.get(key);
			for (int i = 0; i < values.length; i++) {
				String value = values[i];
				queryString += key + "=" + value + "&";
			}
		}
		// 去掉最后一个空格
		int length = queryString.length();
		if (length > 0) {
			queryString = queryString.substring(0, queryString.length() - 1);
		}
		return queryString;
	}

	public static String paramsGet(Map<String, String[]> params) {
		Map<String, String[]> treeParams = new TreeMap<String, String[]>(params);
		String queryString = "";
		for (String key : treeParams.keySet()) {
			String[] values = treeParams.get(key);
			for (int i = 0; i < values.length; i++) {
				String value = values[i];
				queryString += key + "=" + value + "&";
			}
		}
		// 去掉最后一个空格
		int length = queryString.length();
		if (length > 0) {
			queryString = queryString.substring(0, queryString.length() - 1);
		}
		return queryString;
	}
}
