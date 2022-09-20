package com.hirepp.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

public class config {
	public Properties prop = new Properties();
	public FileReader fr;

	
	public String getPropertyVal(String property) {
		Reporter.log("Inside the getPropertyVal method",true);
		if(prop.getProperty(property)==null) {
			Reporter.log("property val not found");
		}
		return prop.getProperty(property);
	}
	
	
	public void loadConfigFile() throws IOException {
		String propertyFilePath= "//config//Config.properties";
		Reporter.log("Inside loadConfigFile method",true );
		fr = new FileReader(System.getProperty("user.dir") + propertyFilePath);
		prop.load(fr);

	}
}
