package com.tigo.EmShareKernel.utils;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;

public class JsonParser {

	public static <T> T getFromJson(String json, String path, Class<T> type) {
	    try {
	      Object value = JsonPath.read(json, path);
	      if (type.isInstance(value)) {
	        return type.cast(value);
	      }
	    } catch (PathNotFoundException ex) {
	      System.out.println("Json value not found ..." + path);
	    }
	    return null;
	  }
	
}
