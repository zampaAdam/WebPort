package com.goDeskless.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.goDeskless.utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	
	
	
	public static  WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static Statement stmt = null;
	public static Statement pstmt = null;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String instanceurl = null;
	
	
	
	@BeforeMethod
	public void setUp() {
		
		//PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\java\\log4j.properties");
		//PropertyConfigurator.configure("D:\\Mobile Automation\\Appium WorkSpace\\SeeTryBuy\\src\\test\\java\\log4j.properties");
		
		

		//if (driver==null)
		{	
			
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//properties//config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file is loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 try {
				fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//properties//OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file is loaded");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {				
				log.info("Connecting to database... ");
				Connection conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir")+"//src//test//resources//database//seetrybuy");
				stmt = conn.createStatement();
				log.info("SQLite Database connection made successfully!");
				Connection postgresconn = DriverManager.getConnection("jdbc:postgresql://multitenancydev-mobility-rds-r1.cse7c3solg0d.us-west-2.rds.amazonaws.com/python_demo_migration","audetemi",
						"Admin123");
				pstmt = postgresconn.createStatement();
				String query = "select * from "+config.getProperty("instancename")+".user_auth_user";
				ResultSet rs = pstmt.executeQuery(query);
				rs.next();
			}catch(SQLException e) {
				e.printStackTrace();
				}
			if (config.getProperty("browser").equals("firefox")) {
				
				//System.setProperty("webdriver.gecko.driver", "/home/dhanshree/Downloads/geckodriver-v0.26.0-linux64/geckodriver");
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//src//test//resources//executables//geckodriver");
				driver = new FirefoxDriver();
				log.debug("Firefox browser is launched successfully");
				
				
			}else if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//executables//chromedriver.exe");
				driver = new ChromeDriver();
				log.debug("Chrome browser is launched successfully");

				
				
			}else if (config.getProperty("browser").equals("ie")) {
				
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//src//test//resources//executables//IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
				
			}
			try {
				instanceurl = config.getProperty("httpstream")+config.getProperty("instancename")+"."+config.getProperty("domainname")+"/#/";

			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			driver.get(instanceurl);
			log.debug("Navigated to : "+config.getProperty("httpstream")+config.getProperty("instacename")+config.getProperty("domainname")) ;

			driver.manage().window().maximize();
			log.debug("Browser is maximize");

			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
			
				
			
		}
	}
	
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		
		
		//if (driver==null) 
		
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL,"Test Case failed is: "+ result.getName());
			test.log(LogStatus.FAIL,"Test Case failed is: "+ result.getThrowable());
			String screenshotPath = getScreenshot(driver, result.getName());
			//To add it in the extent report 
			test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath));
	
		}else if(result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.FAIL,"Test Case failed is: "+ result.getName());
		}	
		driver.quit();
		log.debug("test execution is completed\n");
		rep.endTest(test);
	}
	
	
	
	private String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		                //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}


	@AfterTest
	public void endReport() {
		rep.flush();
		rep.close();
	}
	
	
	
	
}
			
			