package com.goDeskless.testcases;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.goDeskless.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Dashboard extends TestBase {
	
	@Test(priority = 1)
	public void Dashboard_Navigation() throws SQLException, InterruptedException {
		
		test = rep.startTest("Dashboard_Navigation");
		log.debug("---------Testcase 1 to navigate to dashboard page ---------");
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
		log.debug("SignIn button is clicked"); //
		Reporter.log("SignIn button is clicked");
		Thread.sleep(8000);
		String ActualDashbaordLink = driver.getCurrentUrl();
		String ExpectedDashboardLink = instanceurl+"dashboard";
		try {
			Assert.assertEquals(ActualDashbaordLink, ExpectedDashboardLink);
			log.debug("User is navigated to Dashboard");
			test.log(LogStatus.PASS,"Navigated to Dashboard page");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Failed to navigate to Dashboard page");
			test.log(LogStatus.FAIL,e);
		}

	}
	
	
	@Test(priority = 2)
	public void Dashboard_Scrolling_Bar() throws InterruptedException, SQLException{
		
		test = rep.startTest("Dashboard_Scrolling_Bar");
		log.debug("---------Testcase 2 Scroll page down---------");
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
		Thread.sleep(5000);
		WebElement SignIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		SignIn.click();
		log.debug("SignIn button is clicked"); 
		Reporter.log("SignIn button is clicked");

		try {
			Thread.sleep(6000);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,1000)","");
			Thread.sleep(6000);
		    driver.findElement(By.xpath(OR.getProperty("ResolvedVisits")));
			Assert.assertTrue(true);
			log.debug("Page is scroll down ");
			test.log(LogStatus.PASS,"Page is scroll down successfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to scroll down page");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	
	@Test(priority = 3)
	public void Dashboard_Verify_LoggedIn_FR() throws InterruptedException, SQLException {
		
		test = rep.startTest("Dashboard_Verify_LoggedIn_FR");
		log.debug("---------Testcase 3 Logged-in FR---------");
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
		
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		Reporter.log("SignIn button is clicked");

		driver.findElement(By.xpath(OR.getProperty("LoggedInFR"))).click();
		Thread.sleep(2000);
		log.debug("Logged-in FR clicked");
		try {
			driver.findElement(By.xpath(OR.getProperty("SearchInput")));
			log.debug("Logged-in FR list window is opened");
			Assert.assertTrue(true);
			test.log(LogStatus.PASS,"Logged-in FR list window is opened");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Failed as child of saerch FR is not opened");
			test.log(LogStatus.FAIL,e);
			
		}		
	}
	
	@Test(priority = 4)
	public void Dashboard_Search_User() throws InterruptedException, SQLException {
		
		test = rep.startTest("Dashboard_Search_User");
		log.debug("---------Testcase 4 Search FR from list---------");
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
		
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		Reporter.log("SignIn button is clicked");

		driver.findElement(By.xpath(OR.getProperty("LoggedInFR"))).click();
		Thread.sleep(2000);
		log.debug("Logged-in FR clicked");
		
		try {
			Thread.sleep(2000);
			boolean actualMsg= driver.findElement(By.xpath(OR.getProperty("FRList"))).isDisplayed();
			if(actualMsg == false) {
			driver.findElement(By.xpath(OR.getProperty("SearchInput"))).sendKeys("Cole Strauss");
			log.debug("FR is searched succesfully");
			Assert.assertTrue(true);
			test.log(LogStatus.PASS,"FR is searched succesfully");
		}}catch (Exception e) {
			// TODO: handle exception
			log.error("Failed to search FR succesfully");
			test.log(LogStatus.FAIL,e);	
		}	
	}
	
	
	@Test(priority = 5)
	public void Dashboard_Search_Invalid_User() throws InterruptedException, SQLException {
		
		test = rep.startTest("Dashboard_Search_Invalid_User");
		log.debug("---------Testcase 5 Search Invalid FR---------");
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
		
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		Reporter.log("SignIn button is clicked");

		driver.findElement(By.xpath(OR.getProperty("LoggedInFR"))).click();
		Thread.sleep(7000);
		log.debug("Logged-in FR clicked");
		
		try {
			driver.findElement(By.xpath(OR.getProperty("SearchInput"))).sendKeys("jenny loafer");
			String ActualMessage =driver.findElement(By.xpath(OR.getProperty("SearchFRMsg"))).getText();
			String ExpectedMessage="Field representative does not exist.";
			Assert.assertEquals(ActualMessage,ExpectedMessage);
			test.log(LogStatus.PASS,"Searched FR Error message is Displayed");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Searched FR Error message is incorrect");
			test.log(LogStatus.FAIL,e);	
		}	
	}
	
	
	@Test(priority = 6)
	public void Dashboard_Closing_LoggedIn_FR() throws InterruptedException, SQLException {
		
		test = rep.startTest("Dashboard_Closing_LoggedIn_FR");
		log.debug("---------Testcase 6 validate Logged-in FR child window---------");
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
		
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		Reporter.log("SignIn button is clicked");

		driver.findElement(By.xpath(OR.getProperty("LoggedInFR"))).click();
		Thread.sleep(2000);
		log.debug("Logged-in FR clicked");
		
		try {
			driver.findElement(By.xpath(OR.getProperty("CloseFR"))).click();
			driver.findElement(By.xpath(OR.getProperty("LoggedInFR")));
			Assert.assertTrue(true);
			test.log(LogStatus.PASS,"logged-in FR list window  is closed");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Failed to close logged-in FR list window");
			test.log(LogStatus.FAIL,e);	
		}	
	}
	
	
	@Test(priority = 7)
	public void Dashboard_Reopen_LoggedIn_FR() throws InterruptedException, SQLException {
		
		test = rep.startTest("Dashboard_Reopen_LoggedIn_FR");
		log.debug("---------Login_dashboard testcase 3Logged-in FR---------");
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
		
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		Reporter.log("SignIn button is clicked");		
		try {
			driver.findElement(By.xpath(OR.getProperty("LoggedInFR"))).click();
			Thread.sleep(2000);
			log.debug("Logged-in FR clicked");
			WebElement SearchFR = driver.findElement(By.xpath(OR.getProperty("SearchInput")));
			SearchFR.sendKeys("Cole Strauss");
			log.debug("FR is searched succesfully");
			driver.findElement(By.xpath(OR.getProperty("CloseFR"))).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath(OR.getProperty("LoggedInFR"))).click();
			Thread.sleep(4000);
			boolean actualmsg=driver.findElement(By.xpath(OR.getProperty("SearchInput"))).isDisplayed();
			Assert.assertTrue(actualmsg);
			log.debug("Logged-in FR list window is opened");
			test.log(LogStatus.PASS,"Logged-in FR list window is opened");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Failed to open Searched FR window");
			test.log(LogStatus.FAIL,e);	
		}	
	} 
	
	@Test(priority = 8)
	public void Dashboard_Validating_TotalUser_Count() throws InterruptedException, SQLException {
		
		test = rep.startTest("Dashboard_Validating_TotalUser_Count");
		log.debug("---------Validate count of total users count on dashboard page---------");
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
		
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		Reporter.log("SignIn button is clicked");		
		try {
			String query="SELECT count(*) FROM "+config.getProperty("instancename")+".user_auth_user WHERE is_deleted = False AND NOT (((username LIKE '%audetemitest%' AND username IS NOT NULL) OR (role = 'Normal User' AND role IS NOT NULL)))";
			ResultSet rs1 = pstmt.executeQuery(query);
			rs1.next();
			int expected= rs1.getInt("count");
			String actualUser=driver.findElement(By.xpath(OR.getProperty("TotalUser"))).getText();
			String expectedUser="Total Users";
			if(actualUser.contains(expectedUser)) {
				WebElement  count= driver.findElement(By.xpath(OR.getProperty("TotalUserCount")));
				int actual = Integer.parseInt(count.getText());
				Assert.assertEquals(actual, expected);
				log.debug("Total users count is validated");
				test.log(LogStatus.PASS,"Total users count is validated");
		}}catch (Exception e) {
			// TODO: handle exception
			log.error("Incorrect count");
			test.log(LogStatus.FAIL,e);	
		}	
	} 
	
	
	@Test(priority = 9)
	public void Dashboard_Validating_OpenTickets_Count() throws InterruptedException, SQLException {
		
		test = rep.startTest("Dashboard_Validating_OpenTickets_Count");
		log.debug("---------Validate count of open tickets on dashboard page---------");
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
		
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		Reporter.log("SignIn button is clicked");		
		try {
			String query="SELECT count(*) FROM "+config.getProperty("instancename")+".ticket WHERE ticket.ticket_status = 'Open'";
			ResultSet rs1 = pstmt.executeQuery(query);
			rs1.next();
			int expected= rs1.getInt("count");
			WebElement  count= driver.findElement(By.xpath(OR.getProperty("OpenTicketCount")));
			int actual = Integer.parseInt(count.getText());
			Assert.assertEquals(actual, expected);
			log.debug("Open Tickets count is validated");
			test.log(LogStatus.PASS,"Open Tickets count is validated");
			//test.log(LogStatus.PASS,"Logged-in FR list window is opened");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Incorrect count");
			test.log(LogStatus.FAIL,e);	
		}	
	}
	
	@Test(priority = 10)
	public void Dashboard_Validating_CloseTickets_Count() throws InterruptedException, SQLException {
		
		test = rep.startTest("Dashboard_Validating_CloseTickets_Count");
		log.debug("---------Validate count of close tickets on dashboard page---------");
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
		
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		Reporter.log("SignIn button is clicked");		
		try {
			String query="SELECT count(*) FROM "+config.getProperty("instancename")+".ticket WHERE ticket.ticket_status = 'Closed'";
			ResultSet rs1 = pstmt.executeQuery(query);
			rs1.next();
			int expected= rs1.getInt("count");
			WebElement  count= driver.findElement(By.xpath(OR.getProperty("CloseTicketCount")));
			int actual = Integer.parseInt(count.getText());
			Assert.assertEquals(actual, expected);
			log.debug("Close Tickets count is validated");
			test.log(LogStatus.PASS,"Close Tickets count is validated");
			//test.log(LogStatus.PASS,"Logged-in FR list window is opened");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Incorrect count");
			test.log(LogStatus.FAIL,e);	
		}	
	}
	
	@Test(priority = 11)
	public void Dashboard_Validating_ResolvedTickets_Count() throws InterruptedException, SQLException {
		
		test = rep.startTest("Dashboard_Validating_ResolvedTickets_Count");
		log.debug("--------Validate count of Resolved Tickets on dashboard page---------");
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
		
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		Reporter.log("SignIn button is clicked");		
		try {
			String query="SELECT count(*) FROM "+config.getProperty("instancename")+".ticket WHERE ticket.ticket_status = 'Resolved'";
			ResultSet rs1 = pstmt.executeQuery(query);
			rs1.next();
			int expected= rs1.getInt("count");
			WebElement  count= driver.findElement(By.xpath(OR.getProperty("ResolvedTicketCount")));
			int actual = Integer.parseInt(count.getText());
			Assert.assertEquals(actual, expected);
			log.debug("Resolved Tickets count is validated");
			test.log(LogStatus.PASS,"Resolved Tickets count is validated");
			//test.log(LogStatus.PASS,"Logged-in FR list window is opened");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Incorrect count");
			test.log(LogStatus.FAIL,e);	
		}	
	}
	
	@Test(priority = 12)
	public void Dashboard_Validating_OpenVisits_Count() throws InterruptedException, SQLException {
		
		test = rep.startTest("Dashboard_Validating_OpenVisits_Count");
		log.debug("---------Validate count of Open visits on dashboard page---------");
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
		
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		Reporter.log("SignIn button is clicked");		
		try {
			String query="SELECT count(*)  FROM "+config.getProperty("instancename")+".visits WHERE is_deleted = False AND status = 8";
			ResultSet rs1 = pstmt.executeQuery(query);
			rs1.next();
			int expected= rs1.getInt("count");
			WebElement  count= driver.findElement(By.xpath(OR.getProperty("OpenVisitCount")));
			int actual = Integer.parseInt(count.getText());
			Assert.assertEquals(actual, expected);
			log.debug("Logged-in FR list window is opened");
			test.log(LogStatus.PASS,"Open visits count is validated");
			//test.log(LogStatus.PASS,"Logged-in FR list window is opened");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Failed to open Searched FR window");
			test.log(LogStatus.FAIL,e);	
		}	
	}
	
	@Test(priority = 13)
	public void Dashboard_Validating_CloseVisits_Count() throws InterruptedException, SQLException {
		
		test = rep.startTest("Dashboard_Validating_CloseVisits_Count");
		log.debug("---------Validate count of Close visits on dashboard page---------");
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
		
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		Reporter.log("SignIn button is clicked");		
		try {
			String query="SELECT count(*)  FROM "+config.getProperty("instancename")+".visits WHERE is_deleted = False AND status = 3";
			ResultSet rs1 = pstmt.executeQuery(query);
			rs1.next();
			int expected= rs1.getInt("count");
			WebElement  count= driver.findElement(By.xpath(OR.getProperty("CloseVisitCount")));
			int actual = Integer.parseInt(count.getText());
			Assert.assertEquals(actual, expected);
			log.debug("Close visits count is validated");
			test.log(LogStatus.PASS,"Close visits count is validated");
			//test.log(LogStatus.PASS,"Logged-in FR list window is opened");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Incorrect count");
			test.log(LogStatus.FAIL,e);	
		}	
	}
	
	@Test(priority = 14)
	public void Dashboard_Validating_ResolvedVisits_Count() throws InterruptedException, SQLException {
		
		test = rep.startTest("Dashboard_Validating_ResolvedVisits_Count");
		log.debug("---------Validate count of Resolved visits on dashboard page---------");
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
		
	    driver.findElement(By.xpath(OR.getProperty("SignIn"))).click();
		log.debug("SignIn button is clicked"); //
		Reporter.log("SignIn button is clicked");		
		try {
			String query="SELECT count(*)  FROM "+config.getProperty("instancename")+".visits WHERE is_deleted = False AND status = 6";
			ResultSet rs1 = pstmt.executeQuery(query);
			rs1.next();
			int expected= rs1.getInt("count");
			WebElement  count= driver.findElement(By.xpath(OR.getProperty("ResolvedVisitCount")));
			int actual = Integer.parseInt(count.getText());
			Assert.assertEquals(actual, expected);
			log.debug("Resolved visits count is validated");
			test.log(LogStatus.PASS,"Resolved visits count is validated");
			//test.log(LogStatus.PASS,"Logged-in FR list window is opened");
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Incorrect count");
			test.log(LogStatus.FAIL,e);	
		}	
	}
}
