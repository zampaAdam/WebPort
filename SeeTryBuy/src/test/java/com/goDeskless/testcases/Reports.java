package com.goDeskless.testcases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.goDeskless.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Reports extends TestBase {
	
	@Test(priority = 1)
	public void Reports_Navigation() throws SQLException {
		
		log.debug("---------Navigate to Reports page testcase 1 ---------");
		test = rep.startTest("Reports_Navigation");

		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		UserName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement Password = driver.findElement(By.xpath(OR.getProperty("Password")));
		Password.sendKeys(password);
		log.debug("Password is entered");

		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked");
		// Reporter.log("SignIn button is clicked");
		try {
			Thread.sleep(1000);
			WebElement reports = driver.findElement(By.xpath(OR.getProperty("Reports")));
			reports.click();
			Thread.sleep(3000);
			String actualURL =driver.getCurrentUrl();
			String expectedURL = instanceurl+"reports";
			Assert.assertEquals(actualURL, expectedURL);
			log.debug("Navigated to reports tab successfully.");
			test.log(LogStatus.PASS,"Navigated to reports tab successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to naviagte reports page");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 2)
	public void Reports_Validation() throws SQLException {
		
		log.debug("---------Navigate to reports page testcase 2 ---------");
		test = rep.startTest("Reports_Validation");

		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		UserName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement Password = driver.findElement(By.xpath(OR.getProperty("Password")));
		Password.sendKeys(password);
		log.debug("Password is entered");

		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked");
		// Reporter.log("SignIn button is clicked");
		try {
			Thread.sleep(1000);
			WebElement reports = driver.findElement(By.xpath(OR.getProperty("Reports")));
			reports.click();
			Thread.sleep(3000);
			boolean reportValidation= driver.findElement(By.xpath(OR.getProperty("ReportValidation"))).isDisplayed();
			Assert.assertTrue(reportValidation);
			log.debug("validated Reports page successfully.");
			test.log(LogStatus.PASS,"Validated to  Reports page successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to validate Reports page");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 3)
	public void Reports_FieldTechnicians_Navigation() throws SQLException {
		
		log.debug("---------Navigate to FieldTechnicians page testcase 1 ---------");
		test = rep.startTest("Reports_FieldTechnicians_Navigation");

		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		UserName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement Password = driver.findElement(By.xpath(OR.getProperty("Password")));
		Password.sendKeys(password);
		log.debug("Password is entered");

		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked");
		// Reporter.log("SignIn button is clicked");
		try {
			Thread.sleep(1000);
			WebElement reports = driver.findElement(By.xpath(OR.getProperty("Reports")));
			reports.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("FieldTechnician"))).click();
			Thread.sleep(1000);
			String actualURL =driver.getCurrentUrl();
			String expectedURL = instanceurl+"ft-summary-report";
			Assert.assertEquals(actualURL, expectedURL);
			log.debug("Navigated to field technician reports tab successfully.");
			test.log(LogStatus.PASS,"Navigated to field technician reports tab successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to naviagte field technician reports page");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 4)
	public void Reports_VisitReport_Navigation() throws SQLException {
		
		log.debug("---------Navigate to Visit report page testcase 1 ---------");
		test = rep.startTest("Reports_VisitReport_Navigation");

		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		UserName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement Password = driver.findElement(By.xpath(OR.getProperty("Password")));
		Password.sendKeys(password);
		log.debug("Password is entered");

		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked");
		// Reporter.log("SignIn button is clicked");
		try {
			Thread.sleep(1000);
			WebElement reports = driver.findElement(By.xpath(OR.getProperty("Reports")));
			reports.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("VisitReport"))).click();
			Thread.sleep(1000);
			String actualURL =driver.getCurrentUrl();
			String expectedURL = instanceurl+"ticket-ageing-report";
			Assert.assertEquals(actualURL, expectedURL);
			log.debug("Navigated to visit reports tab successfully.");
			test.log(LogStatus.PASS,"Navigated to visit reports tab successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to naviagte visit reports page");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 5)
	public void Reports_GroupVisit_Navigation() throws SQLException {
		
		log.debug("---------Navigate to GroupVisit Reports page testcase 1 ---------");
		test = rep.startTest("Reports_GroupVisit_Navigation");

		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		UserName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement Password = driver.findElement(By.xpath(OR.getProperty("Password")));
		Password.sendKeys(password);
		log.debug("Password is entered");

		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked");
		// Reporter.log("SignIn button is clicked");
		try {
			Thread.sleep(1000);
			WebElement reports = driver.findElement(By.xpath(OR.getProperty("Reports")));
			reports.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("VisitGroupReport"))).click();
			Thread.sleep(1000);
			String actualURL =driver.getCurrentUrl();
			String expectedURL = instanceurl+"group-summary-report";
			Assert.assertEquals(actualURL, expectedURL);
			log.debug("Navigated to GroupVisit reports tab successfully.");
			test.log(LogStatus.PASS,"Navigated to GroupVisit reports tab successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to naviagte GroupVisit reports page");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 6)
	public void Reports_FieldRepresentative_Navigation() throws SQLException {
		
		log.debug("---------Navigate to FieldRepresentative Reports page testcase 1 ---------");
		test = rep.startTest("Reports_FieldRepresentative_Navigation");

		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		UserName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement Password = driver.findElement(By.xpath(OR.getProperty("Password")));
		Password.sendKeys(password);
		log.debug("Password is entered");

		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked");
		// Reporter.log("SignIn button is clicked");
		try {
			Thread.sleep(1000);
			WebElement reports = driver.findElement(By.xpath(OR.getProperty("Reports")));
			reports.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("FieldReport"))).click();
			Thread.sleep(1000);
			String actualURL =driver.getCurrentUrl();
			String expectedURL = instanceurl+"agent-glance-report";
			Assert.assertEquals(actualURL, expectedURL);
			log.debug("Navigated to reports tab successfully.");
			test.log(LogStatus.PASS,"Navigated to reports tab successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to naviagte reports page");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 7)
	public void Reports_GroupReport_Navigation() throws SQLException {
		
		log.debug("---------Navigate to GroupReport Reports page testcase 1 ---------");
		test = rep.startTest("Reports_GroupReport_Navigation");

		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		UserName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement Password = driver.findElement(By.xpath(OR.getProperty("Password")));
		Password.sendKeys(password);
		log.debug("Password is entered");

		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked");
		// Reporter.log("SignIn button is clicked");
		try {
			Thread.sleep(1000);
			WebElement reports = driver.findElement(By.xpath(OR.getProperty("Reports")));
			reports.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("GroupReport"))).click();
			Thread.sleep(1000);
			String actualURL =driver.getCurrentUrl();
			String expectedURL = instanceurl+"group-glance-report";
			Assert.assertEquals(actualURL, expectedURL);
			log.debug("Navigated to Group reports tab successfully.");
			test.log(LogStatus.PASS,"Navigated to group reports tab successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to naviagte group reports page");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	
	@Test(priority = 8)
	public void Report_ToDate_Required() throws InterruptedException, SQLException {
		
		log.debug("---------Test report  to date required testcase---------");
		
		test = rep.startTest("Report_ToDate_Required");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		UserName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement Password = driver.findElement(By.xpath(OR.getProperty("Password")));
		Password.sendKeys(password);
		log.debug("Password is entered");

		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked");
		// Reporter.log("SignIn button is clicked");
		
		try {
			
			WebElement reports = driver.findElement(By.xpath(OR.getProperty("Reports")));
			reports.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("FieldTechnician"))).click();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY");  
			LocalDateTime now = LocalDateTime.now();  
			WebElement FromDate = driver.findElement(By.xpath(OR.getProperty("FormDateReport")));
			FromDate.sendKeys(dtf.format(now));
			driver.findElement(By.xpath(OR.getProperty("SubmitButtonReport"))).click();
			Thread.sleep(1000);
			String ActualMsg = driver.findElement(By.xpath(OR.getProperty("SearchErrorPopUp"))).getText();
			String ExpectedMsg= "Please select To Date to proceed";
			Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
			log.debug("Empty to date search error messages are displayed on screen");
			test.log(LogStatus.PASS,"Empty to date search error messages are displayed on screen");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed Empty to date search error message is not displayed on screen");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	
	@Test(priority = 9)
	public void Reports_FormDate_Required() throws InterruptedException, SQLException {
		
		log.debug("---------Validate with Empty from date Search testcase---------");
		
		test = rep.startTest("Reports_FormDate_Required");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement UserName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		UserName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement Password = driver.findElement(By.xpath(OR.getProperty("Password")));
		Password.sendKeys(password);
		log.debug("Password is entered");

		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked");
		// Reporter.log("SignIn button is clicked");
		
		try {
	
			WebElement report = driver.findElement(By.xpath(OR.getProperty("Reports")));
			report.click();
			Thread.sleep(3000);		    
			driver.findElement(By.xpath(OR.getProperty("FieldTechnician"))).click();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY");  
			LocalDateTime now = LocalDateTime.now();  
			WebElement ToDateReport = driver.findElement(By.xpath(OR.getProperty("ToDateReport")));
			ToDateReport.sendKeys(dtf.format(now));
			driver.findElement(By.xpath(OR.getProperty("SubmitButtonReport"))).click();
			Thread.sleep(1000);
			String ActualMsg = driver.findElement(By.xpath(OR.getProperty("SearchErrorPopUp"))).getText();
			String ExpectedMsg= "Please select From Date to proceed";
			Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
			log.debug("Empty to date search error messages are displayed on screen");
			test.log(LogStatus.PASS,"Empty from date search error messages are displayed on screen");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed Empty from date search error message is not displayed on screen");
			test.log(LogStatus.FAIL,e);
		}
	}
}
