package com.sauce.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
	public static String projectpath = System.getProperty("user.dir");
	
	public static FileInputStream fis;
	
	public static Properties data;
	public static Properties mainProp;
	public static Properties childProp;
	
	public static void init() throws IOException {
		fis = new FileInputStream(projectpath+"//dataSources//commondata.properties");
		data = new Properties();
		data.load(fis);
		
		fis = new FileInputStream(projectpath+"//dataSources//environment.properties");
		mainProp = new Properties();
		mainProp.load(fis);
		String e = mainProp.getProperty("env");
		System.out.println(e);
		
		fis = new FileInputStream(projectpath+"//dataSources//"+e+".properties");
		mainProp = new Properties();
		mainProp.load(fis);
		String webUrl = mainProp.getProperty("url");
		System.out.println(webUrl);
	}

}
