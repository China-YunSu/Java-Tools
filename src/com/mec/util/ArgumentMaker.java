package com.mec.util;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class ArgumentMaker {
	public static Gson gson = new GsonBuilder().create();
	private Map<String, String> argumentPool;
	private Type type =  new TypeToken<Map<String, String>>(){}.getType(); 
	
	public ArgumentMaker() {
		argumentPool = new HashMap<String, String>();;
	}
	
	public Object getVaule(String parameter, Type type) {
		String para = argumentPool.get(parameter);
		return gson.fromJson(para, type);
	}

	public Object getVaule(String parameter, Class<?> type) {
		String para = argumentPool.get(parameter);
		return gson.fromJson(para, type);
	}
	
	public ArgumentMaker(String map) {
		argumentPool = gson.fromJson(map, type);
	}
	
	public ArgumentMaker add(String parameter, Object value) {
		argumentPool.put(parameter,gson.toJson(value));
		return this;
	}
	
	public String toString() {
		return gson.toJson(argumentPool);
	}
	
}
