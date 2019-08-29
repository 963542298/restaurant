package com.restaurant.util;

import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 */
public class ConfigUtils {
	
	private static Properties prop=null;
	
	static{
		try {
			InputStream is= Resources.getResourceAsStream("db.properties");
			prop=new Properties();
			prop.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(String name){
		return prop.getProperty(name);
	}
	
	public static int getIntValue(String name){
		return Integer.valueOf(prop.getProperty(name));
	}


}
