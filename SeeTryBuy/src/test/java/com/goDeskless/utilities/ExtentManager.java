package com.goDeskless.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance() {
		
		if(extent==null) {
			
			
			extent = new ExtentReports(System.getProperty("user.dir")+"/target/surefire-reports/html/extent.html",false);
				
			extent.loadConfig(new File(System.getProperty("user.dir")+"/src/test/resources/extentconfig/ReportsConfig.xml"));
			
		}
		
		return extent;
		
	}

}
