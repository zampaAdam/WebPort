package com.goDeskless.roughWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class TestProperties {

	
	public static void main(String[] args) throws IOException {
		
		
		
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
		config.load(fis);
		Date d = new Date();
		String screenshotName = d.toString().replace(":", "_").replace(" ", "_")+".jpg";
				
	}
	
	
}
