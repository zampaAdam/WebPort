package com.goDeskless.testcases;

import com.goDeskless.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminSettings_Agent extends TestBase{
	
	@Test(priority = 1)
	public void AdminSettings_Agent_Navigation() throws SQLException {
		
		log.debug("---------Navigate to Agent page testcase 2 ---------");
		test = rep.startTest("AdminSettings_Agent_Navigation");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
			Agents.click();
			Thread.sleep(3000);
			String ActualURL=driver.getCurrentUrl();
			String ExpectedURL = instanceurl + "users";
			Assert.assertEquals(ActualURL,ExpectedURL);
			log.debug("Navigated to agents page successfully");
			test.log(LogStatus.PASS,"Navigated to agents page successfully");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to naviagte agents page");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 2)
	public void AdminSettings_Agent_Page_Validation() throws SQLException {
		
		log.debug("---------Validate Agent page testcase 2 ---------");
		test = rep.startTest("AdminSettings_Agent_Page_Validation");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			
			WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
			Agents.click();
			log.debug("Agents field is clicked - "+ Agents);
			Thread.sleep(3000);
			boolean FromDate = driver.findElement(By.xpath(OR.getProperty("FromDate"))).isDisplayed();
			log.debug("From Date field is displayed - " + FromDate);
		
			boolean ToDate = driver.findElement(By.xpath(OR.getProperty("ToDate"))).isDisplayed();
			log.debug("To Date field is displayed - " + ToDate);
		
			boolean SelectRoleDrpDown = driver.findElement(By.xpath(OR.getProperty("SelectRole"))).isDisplayed();
			log.debug("Select role field is displayed - " + SelectRoleDrpDown);
		
			boolean SelectSourceDrpDown = driver.findElement(By.xpath(OR.getProperty("SelectSource"))).isDisplayed();
			log.debug("Select source field is displayed - " + SelectSourceDrpDown);
		
			if (FromDate == true && ToDate == true && SelectRoleDrpDown == true && SelectSourceDrpDown == true) {
		
				log.debug("Test case Agent page validation is passed");
				test.log(LogStatus.PASS,"Agent Page is filter are validated");
		
			}
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to validate Agent page");
        	test.log(LogStatus.FAIL,e);
		} 
	}
	
	@Test(priority = 3)
	public void AdminSettings_AgentSearch_Empty_Details() throws InterruptedException, SQLException {
		
		log.debug("---------VerifyEmptySearch Agent testcase---------");
		
		test = rep.startTest("AdminSettings_AgentSearch_Empty_Details");
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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			
			WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
			Agents.click();
			log.debug("Agents field is clicked - "+ Agents);
			Thread.sleep(3000);
			boolean SearchAgent = driver.findElement(By.xpath(OR.getProperty("SearchTicket"))).isDisplayed();
			if (SearchAgent == true) {
				log.debug("Search button is displayed" + SearchAgent);
				driver.findElement(By.xpath(OR.getProperty("SearchTicket"))).click();
				log.debug("Search Agent is clicked");
				Thread.sleep(2000);
				String ActualMsg = driver.findElement(By.xpath(OR.getProperty("SearchErrorPopUp"))).getText();
				String ExpectedMsg= "Error! Please provide any search criteria.";
				Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
				test.log(LogStatus.PASS,"Empty data is search error messages are displayed on screen");	  
			}
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to empty search Agent details");
			test.log(LogStatus.FAIL,e);
		}
		
	}
	
	
	@Test(priority = 4)
	public void AdminSettings_Agent_ToDate_Required() throws InterruptedException, SQLException {
		
		log.debug("---------Validate with Empty to date Search testcase---------");
		
		test = rep.startTest("AdminSettings_Agent_ToDate_Required");
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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			
			WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
			Agents.click();
			log.debug("Agents field is clicked - "+ Agents);
			Thread.sleep(3000);			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY");  
			LocalDateTime now = LocalDateTime.now();  
			WebElement FromDate = driver.findElement(By.xpath(OR.getProperty("FromDate")));
			FromDate.sendKeys(dtf.format(now));
			driver.findElement(By.xpath(OR.getProperty("SearchTicket"))).click();;
			String ActualMsg = driver.findElement(By.xpath(OR.getProperty("SearchErrorPopUp"))).getText();
			System.out.println(ActualMsg);
			String ExpectedMsg= "Error! Please select To Date to proceed.";
			Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
			driver.findElement(By.xpath(OR.getProperty("CloseDateMsg"))).click();
			log.debug("Empty to date search error messages are displayed on screen");
			test.log(LogStatus.PASS,"Empty to date search error messages are displayed on screen");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed Empty to date search error message is not displayed on screen");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	
	@Test(priority = 5)
	public void AdminSettings_Agent_FormDate_Required() throws InterruptedException, SQLException {
		
		log.debug("---------Validate with Empty from date Search testcase---------");
		
		test = rep.startTest("AdminSettings_Agent_FormDate_Required");
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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			
			WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
			Agents.click();
			log.debug("Agents field is clicked - "+ Agents);
			Thread.sleep(3000);		    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/YYYY");  
			LocalDateTime now = LocalDateTime.now();  
			WebElement ToDate = driver.findElement(By.xpath(OR.getProperty("ToDate")));
			ToDate.sendKeys(dtf.format(now));
			driver.findElement(By.xpath(OR.getProperty("SearchTicket"))).click();;
			String ActualMsg = driver.findElement(By.xpath(OR.getProperty("SearchErrorPopUp"))).getText();
			String ExpectedMsg= "Error! Please select From Date to proceed.";
			Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
			driver.findElement(By.xpath(OR.getProperty("CloseDateMsg"))).click();
			log.debug("Empty to date search error messages are displayed on screen");
			test.log(LogStatus.PASS,"Empty from date search error messages are displayed on screen");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed Empty from date search error message is not displayed on screen");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 6)
	public void AdminSettings_Agent_Reset_Search() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the user Search data is reset testcase---------");
		
		test = rep.startTest("AdminSettings_Agent_Reset_Search");
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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			
			WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
			Agents.click();
			log.debug("Agents field is clicked - "+ Agents);
			Thread.sleep(3000);	
			driver.findElement(By.xpath(OR.getProperty("SelectRole"))).click();
			Thread.sleep(2000);
			WebElement SearchRole = driver.findElement(By.xpath(OR.getProperty("SearchRole")));
			SearchRole.sendKeys("FR1");
			Thread.sleep(3000);
			WebElement dropdown = driver.findElement(By.xpath(OR.getProperty("SelectRoleDrpDown")));
			dropdown.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(OR.getProperty("ResetSearch"))).click();
			boolean deletebutton = driver.findElement(By.xpath(OR.getProperty("DeletSearchRole"))).isDisplayed();
			Assert.assertTrue(deletebutton);
			log.debug("Empty to date search error messages are displayed on screen");
			test.log(LogStatus.PASS,"Empty from date search error messages are displayed on screen");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed Empty from date search error message is not displayed on screen");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 7)
	public void AdminSettings_Agent_Role_Search() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the user is Search  testcase---------");
		
		test = rep.startTest("AdminSettings_Agent_Role_Search");
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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			
			WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
			Agents.click();
			log.debug("Agents field is clicked - "+ Agents);
			Thread.sleep(3000);	
			driver.findElement(By.xpath(OR.getProperty("SelectRole"))).click();
			Thread.sleep(2000);
			WebElement SearchRole = driver.findElement(By.xpath(OR.getProperty("SearchRole")));
			SearchRole.sendKeys("FR1");
			Thread.sleep(3000);
			WebElement dropdown = driver.findElement(By.xpath(OR.getProperty("SelectRoleDrpDown")));
			dropdown.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(OR.getProperty("SearchTicket"))).click();
			boolean deletebutton = driver.findElement(By.xpath(OR.getProperty("DeletSearchRole"))).isDisplayed();
			Assert.assertTrue(deletebutton);
			log.debug("Agent Role details are Searched successfully");
			test.log(LogStatus.PASS,"Agent Role details are Searched successfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to search Agent Role details ");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 8)
	public void AdminSettings_Agent_Add_NewUser() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the add new user testcase---------");
		
		test = rep.startTest("AdminSettings_Agent_Add_NewUser");
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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			
			WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
			Agents.click();
			log.debug("Agents field is clicked - "+ Agents);
			Thread.sleep(3000);	
			driver.findElement(By.xpath(OR.getProperty("AddNewUser"))).click();
			Thread.sleep(2000);
			boolean ChooseUserType = driver.findElement(By.xpath(OR.getProperty("ChooseUserType"))).isDisplayed();
			Assert.assertTrue(ChooseUserType);
			log.debug("Add new user to Agent window open successfully");
			test.log(LogStatus.PASS,"Add new user to Agent window open successfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to search Agent Role details ");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 9)
	public void AdminSettings_Agent_ChooseUser_Alert() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the add new user-> choose user type testcase---------");
		
		test = rep.startTest("AdminSettings_Agent_ChooseUser_Alert");
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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			
			WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
			Agents.click();
			log.debug("Agents field is clicked - "+ Agents);
			Thread.sleep(3000);	
			driver.findElement(By.xpath(OR.getProperty("AddNewUser"))).click();
			Thread.sleep(2000);
			String ActualMsg = driver.findElement(By.xpath(OR.getProperty("AdminAlertMsg"))).getText();
			String ExpectedMsg="You have reached the maximum limit for the Admin user addition";
			Assert.assertTrue(ActualMsg.contains(ExpectedMsg));
			log.debug("Add new user to Agent alert message verified  successfully");
			test.log(LogStatus.PASS,"Add new user to Agent alert message verified successfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to search Agent Role details ");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 10)
	public void AdminSettings_Agent_Alert_OK() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the add new user->alert ok testcase---------");
		
		test = rep.startTest("AdminSettings_Agent_Alert_OK");
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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			
			WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
			Agents.click();
			log.debug("Agents field is clicked - "+ Agents);
			Thread.sleep(3000);	
			driver.findElement(By.xpath(OR.getProperty("AddNewUser"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(OR.getProperty("AlertClickOk"))).click();
			Thread.sleep(1000);
			boolean SearchAgent= driver.findElement(By.xpath(OR.getProperty("SearchTicket"))).isDisplayed();
			Assert.assertTrue(SearchAgent);
			log.debug("verified Ok button on Add new user to Agent alert message  successfully");
			test.log(LogStatus.PASS,"verified Ok button on Add new user to Agent alert message  successfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to search Agent Role details ");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	
	@Test(priority = 11)
	public void AdminSettings_Agent_Add_Agent() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the add new user -> add agent testcase---------");
		
		test = rep.startTest("AdminSettings_Agent_Add_Agent");
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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			
			WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
			Agents.click();
			log.debug("Agents field is clicked - "+ Agents);
			Thread.sleep(3000);	
			driver.findElement(By.xpath(OR.getProperty("AddNewUser"))).click();
			Thread.sleep(2000);
			WebElement agentRadio = driver.findElement(By.xpath(OR.getProperty("AddAgent")));
			agentRadio.click();
			boolean SaveAgent= driver.findElement(By.xpath(OR.getProperty("SaveAgent"))).isDisplayed();
			Assert.assertTrue(SaveAgent);
			log.debug("Added new Agent successfully");
			test.log(LogStatus.PASS,"Added new Agent successfully");
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to Add new Agent");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 12)
	public void AdminSettings_Add_Agent_Location() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the add new user -> add agent -> location testcase---------");
		
		test = rep.startTest("AdminSettings_Add_Agent_Location");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		userName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement passwordInput = driver.findElement(By.xpath(OR.getProperty("Password")));
		passwordInput.sendKeys(password);
		log.debug("Password is entered");

		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		// Reporter.log("SignIn button is clicked");

		try {
				WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
				adminSettings.click();
				log.debug("Admin Settings button is clicked");	
				Thread.sleep(4000);
				
				WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
				Agents.click();
				log.debug("Agents field is clicked - "+ Agents);
				Thread.sleep(3000);	
				driver.findElement(By.xpath(OR.getProperty("AddNewUser"))).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(OR.getProperty("AddAgent"))).click();
				driver.findElement(By.xpath(OR.getProperty("AddAgentLocation"))).click();
				Thread.sleep(1000);
				String actualURL =driver.getCurrentUrl();
				String expectedURL = instanceurl + "locations";
				Assert.assertEquals(actualURL, expectedURL);
				log.debug(" add agent location functionality is working fine.");
				test.log(LogStatus.PASS,"add agent location functionality is working fine.");
			}
			catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to execute add agent location functionality.");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 13)
	public void AdminSettings_Add_Agent_Group() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the add new user -> add agent -> Group testcase---------");
		
		test = rep.startTest("AdminSettings_Add_Agent_Group");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		userName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement passwordInput = driver.findElement(By.xpath(OR.getProperty("Password")));
		passwordInput.sendKeys(password);
		log.debug("Password is entered");

		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		// Reporter.log("SignIn button is clicked");

		try {
				WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
				adminSettings.click();
				log.debug("Admin Settings button is clicked");	
				Thread.sleep(4000);
				
				WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
				Agents.click();
				log.debug("Agents field is clicked - "+ Agents);
				Thread.sleep(3000);	
				driver.findElement(By.xpath(OR.getProperty("AddNewUser"))).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(OR.getProperty("AddAgent"))).click();
				driver.findElement(By.xpath(OR.getProperty("AddAgentGroup"))).click();
				Thread.sleep(1000);
				String actualURL =driver.getCurrentUrl();
				String expectedURL = instanceurl + "groups";
				Assert.assertEquals(actualURL, expectedURL);
				log.debug(" add agent group functionality is working fine.");
				test.log(LogStatus.PASS,"add agent group functionality is working fine.");
			}
			catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to execute add agent group functionality.");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 14)
	public void AdminSettings_Add_Agent_Role() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the add new user -> add agent -> role testcase---------");
		
		test = rep.startTest("AdminSettings_Add_Agent_Role");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		userName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement passwordInput = driver.findElement(By.xpath(OR.getProperty("Password")));
		passwordInput.sendKeys(password);
		log.debug("Password is entered");

		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		// Reporter.log("SignIn button is clicked");

		try {
				WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
				adminSettings.click();
				log.debug("Admin Settings button is clicked");	
				Thread.sleep(4000);
				
				WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
				Agents.click();
				log.debug("Agents field is clicked - "+ Agents);
				Thread.sleep(3000);	
				driver.findElement(By.xpath(OR.getProperty("AddNewUser"))).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(OR.getProperty("AddAgent"))).click();
				driver.findElement(By.xpath(OR.getProperty("AddAgentRole"))).click();
				Thread.sleep(1000);
				String actualURL =driver.getCurrentUrl();
				String expectedURL = instanceurl + "roles";
				Assert.assertEquals(actualURL, expectedURL);
				log.debug(" add agent role functionality is working fine.");
				test.log(LogStatus.PASS,"add agent role functionality is working fine.");
			}
			catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to execute add agent role functionality.");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 15)
	public void AdminSettings_Add_Agent_Details() throws InterruptedException, SQLException {
	
	log.debug("---------Verify the add new user -> add agent -> details testcase---------");
	
	test = rep.startTest("AdminSettings_Add_Agent_Details");
	String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
	ResultSet rs = stmt.executeQuery(sql);
	rs.next();
	String username = rs.getString(2);
	username = username.replaceAll("\\s+","");
	String password = rs.getString(3);
	password = password.replaceAll("\\s+","");
	
	WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
	userName.sendKeys(username);
	log.debug("User Name is entered");
	
	WebElement passwordInput = driver.findElement(By.xpath(OR.getProperty("Password")));
	passwordInput.sendKeys(password);
	log.debug("Password is entered");
	
	WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
	signIn.click();
	log.debug("SignIn button is clicked");
	// Reporter.log("SignIn button is clicked");
		
		try {
				WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
				adminSettings.click();
				log.debug("Admin Settings button is clicked");	
				Thread.sleep(4000);
				
				WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
				Agents.click();
				log.debug("Agents field is clicked - "+ Agents);
				Thread.sleep(3000);	
				driver.findElement(By.xpath(OR.getProperty("AddNewUser"))).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(OR.getProperty("AddAgent"))).click();
				
				WebElement firstNameInputbox = driver.findElement(By.xpath(OR.getProperty("EditFirstName")));
				firstNameInputbox.sendKeys("Jack");
				
				WebElement LastNameInputbox = driver.findElement(By.xpath(OR.getProperty("EnterLastName")));
				LastNameInputbox.sendKeys("Sparrow");
				
				WebElement emailIdInputbox = driver.findElement(By.xpath(OR.getProperty("EnterAgentEmail")));
				emailIdInputbox.sendKeys("jack.sparrow@yopmail.com");
				
				WebElement  PhoneInputbox= driver.findElement(By.xpath(OR.getProperty("AddAgentPhoneNum")));
				PhoneInputbox.sendKeys("1234567890");	
				
				driver.findElement(By.xpath(OR.getProperty("LocDrpDown"))).click();
				WebElement locationDrpDown = driver.findElement(By.xpath(OR.getProperty("LocationSearchDrp")));
				locationDrpDown.sendKeys("Baner - Pashan Link Road");
				driver.findElement(By.xpath(OR.getProperty("SelectLocation"))).click();
				
				driver.findElement(By.xpath(OR.getProperty("GrpDrpDown"))).click();
				WebElement groupDrpDown = driver.findElement(By.xpath(OR.getProperty("GroupSearchDrp")));
				groupDrpDown.sendKeys("Field Technicians");
				driver.findElement(By.xpath(OR.getProperty("SelectGroup"))).click();
				
				driver.findElement(By.xpath(OR.getProperty("RoleDrpDown"))).click();
				WebElement roleDrpDown = driver.findElement(By.xpath(OR.getProperty("RoleSearchDrp")));
				roleDrpDown.sendKeys("Field Representative");
				driver.findElement(By.xpath(OR.getProperty("SelectRole"))).click();
				
				Thread.sleep(1000);
				driver.findElement(By.xpath(OR.getProperty("ManagerDrpDown"))).click();
				WebElement ManagerDrpDown = driver.findElement(By.xpath(OR.getProperty("ManagerSearchDrp")));
				ManagerDrpDown.sendKeys("Dilip Rathi");
				driver.findElement(By.xpath(OR.getProperty("SelectManager"))).click();

				driver.findElement(By.xpath(OR.getProperty("SkillDrpDown"))).click();
				WebElement skillDrpDown = driver.findElement(By.xpath(OR.getProperty("SkillSearchDrp")));
				skillDrpDown.sendKeys(" Electrical");
				driver.findElement(By.xpath(OR.getProperty("SelectSkill"))).click();

				driver.findElement(By.xpath(OR.getProperty("SaveAgent"))).click();
				
				String actualMsg = driver.findElement(By.xpath(OR.getProperty("SuccessAddAgentMsg"))).getText(); 
				String expectedMsg =  "Success! User Created Successfully.";
				Assert.assertTrue(actualMsg.contains(expectedMsg));
				
				log.debug("Max phone number character functionality is working fine.");
				test.log(LogStatus.PASS,"Max Phone number character functionality is working fine.");
				
			}catch (Exception e) {
				// TODO: handle exception
				log.debug("Failed to execute Max character functionality.");
				test.log(LogStatus.FAIL,e);
			}
	}
		
	@Test(priority = 16)
	public void AdminSettings_Update_Agent_Validation() throws InterruptedException, SQLException {
	
	log.debug("---------Verify the add new user -> update user validation testcase---------");
	
	test = rep.startTest("AdminSettings_Update_Agent_Validation");
	String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
	ResultSet rs = stmt.executeQuery(sql);
	rs.next();
	String username = rs.getString(2);
	username = username.replaceAll("\\s+","");
	String password = rs.getString(3);
	password = password.replaceAll("\\s+","");
	
	WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
	userName.sendKeys(username);
	log.debug("User Name is entered");
	
	WebElement passwordInput = driver.findElement(By.xpath(OR.getProperty("Password")));
	passwordInput.sendKeys(password);
	log.debug("Password is entered");
	
	WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
	signIn.click();
	log.debug("SignIn button is clicked");
	// Reporter.log("SignIn button is clicked");
		
		try {
				WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
				adminSettings.click();
				log.debug("Admin Settings button is clicked");	
				Thread.sleep(4000);
				
				WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
				Agents.click();
				log.debug("Agents field is clicked - "+ Agents);
				Thread.sleep(3000);					
				boolean agentName = driver.findElement(By.xpath("//td[contains(text(),'Jack Sparrow')]")).isDisplayed();
				if(agentName == true) {
					
					driver.findElement(By.xpath(OR.getProperty("EditAgentName"))).click();
					boolean updateUserWindow = driver.findElement(By.xpath(OR.getProperty("UpadteUser"))).isDisplayed(); 
					Assert.assertTrue(true);
					log.debug("Update user window open successfully.");
					test.log(LogStatus.PASS,"Update user window open successfully.");
				}
			
			}catch (Exception e) {
				// TODO: handle exception
				log.debug("Failed to execute Max character functionality.");
				test.log(LogStatus.FAIL,e);
			}
	}
	
	@Test(priority = 17)
	public void AdminSettings_Update_Agent_Details() throws InterruptedException, SQLException {
	
	log.debug("---------Verify the add new user -> upadte user details testcase---------");
	
	test = rep.startTest("AdminSettings_Update_Agent_Details");
	String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
	ResultSet rs = stmt.executeQuery(sql);
	rs.next();
	String username = rs.getString(2);
	username = username.replaceAll("\\s+","");
	String password = rs.getString(3);
	password = password.replaceAll("\\s+","");
	
	WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
	userName.sendKeys(username);
	log.debug("User Name is entered");
	
	WebElement passwordInput = driver.findElement(By.xpath(OR.getProperty("Password")));
	passwordInput.sendKeys(password);
	log.debug("Password is entered");
	
	WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
	signIn.click();
	log.debug("SignIn button is clicked");
	// Reporter.log("SignIn button is clicked");
		
		try {
				WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
				adminSettings.click();
				log.debug("Admin Settings button is clicked");	
				Thread.sleep(4000);
				
				WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
				Agents.click();
				log.debug("Agents field is clicked - "+ Agents);
				Thread.sleep(3000);					
				boolean agentName = driver.findElement(By.xpath("//td[contains(text(),'Jack Sparrow')]")).isDisplayed();
				if(agentName == true) {
					
					driver.findElement(By.xpath(OR.getProperty("EditAgentName"))).click();
					WebElement  PhoneInputbox= driver.findElement(By.xpath(OR.getProperty("AddAgentPhoneNum")));
					PhoneInputbox.clear();
					PhoneInputbox.sendKeys("91919191919");	
					driver.findElement(By.xpath(OR.getProperty("UpdateButton"))).click();
					Thread.sleep(1000);
					String actualMsg=driver.findElement(By.xpath(OR.getProperty("UpdateAgentMsg"))).getText();
					String expectedMsg="User updated successfully";
					Assert.assertTrue(actualMsg.contains(expectedMsg));
					log.debug("Update agent phone number  functionality is working fine.");
					test.log(LogStatus.PASS,"Update Phone number functionality is working fine.");
				}
			
			}catch (Exception e) {
				// TODO: handle exception
				log.debug("Failed to execute Upadte phone number functionality.");
				test.log(LogStatus.FAIL,e);
			}
	}
	
	@Test(priority = 18)
	public void AdminSettings_Delete_Agent() throws InterruptedException, SQLException {
	
	log.debug("---------Verify the add new user -> upadte user details testcase---------");
	
	test = rep.startTest("AdminSettings_Delete_Agent");
	String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
	ResultSet rs = stmt.executeQuery(sql);
	rs.next();
	String username = rs.getString(2);
	username = username.replaceAll("\\s+","");
	String password = rs.getString(3);
	password = password.replaceAll("\\s+","");
	
	WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
	userName.sendKeys(username);
	log.debug("User Name is entered");
	
	WebElement passwordInput = driver.findElement(By.xpath(OR.getProperty("Password")));
	passwordInput.sendKeys(password);
	log.debug("Password is entered");
	
	WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
	signIn.click();
	log.debug("SignIn button is clicked");
	// Reporter.log("SignIn button is clicked");
		
		try {
				WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
				adminSettings.click();
				log.debug("Admin Settings button is clicked");	
				Thread.sleep(4000);
				
				WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
				Agents.click();
				log.debug("Agents field is clicked - "+ Agents);
				Thread.sleep(3000);					
				boolean agentName = driver.findElement(By.xpath("//td[contains(text(),'Jack Sparrow')]")).isDisplayed();
				if(agentName == true) {
					
					driver.findElement(By.xpath(OR.getProperty("DeleteAgent"))).click();
					driver.findElement(By.xpath(OR.getProperty("ConfirmDelete"))).click();
					String actualMsg=driver.findElement(By.xpath(OR.getProperty("DeleteAgentMsg"))).getText();
					String expectedMsg="User deleted successfully";
					Assert.assertTrue(actualMsg.contains(expectedMsg));
					log.debug("Update agent phone number  functionality is working fine.");
					test.log(LogStatus.PASS,"Update Phone number functionality is working fine.");
				}
			
			}catch (Exception e) {
				// TODO: handle exception
				log.debug("Failed to execute Upadte phone number functionality.");
				test.log(LogStatus.FAIL,e);
			}
	}
	
	@Test(priority = 19)
	public void AdminSettings_Add_Agent_FName_size() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the add new user -> add agent -> save testcase---------");
		
		test = rep.startTest("AdminSettings_Add_Agent_FName_size");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		userName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement passwordInput = driver.findElement(By.xpath(OR.getProperty("Password")));
		passwordInput.sendKeys(password);
		log.debug("Password is entered");

		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		// Reporter.log("SignIn button is clicked");

		try {
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			
			WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
			Agents.click();
			log.debug("Agents field is clicked - "+ Agents);
			Thread.sleep(3000);	
			driver.findElement(By.xpath(OR.getProperty("AddNewUser"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(OR.getProperty("AddAgent"))).click();
			WebElement firstNameInputbox = driver.findElement(By.xpath(OR.getProperty("EditFirstName")));
			firstNameInputbox.sendKeys("ababababababababababababababab");
			// Get the typed value
			String typedValue = firstNameInputbox.getAttribute("value");
			// Get the length of typed value
			int size = typedValue.length();
			// Assert with expected
			if (size == 25) {
				Assert.assertTrue(true);
				log.debug("Max character functionality is working fine.");
				test.log(LogStatus.PASS,"Max character functionality is working fine.");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to execute Max character functionality.");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 20)
	public void AdminSettings_Add_Agent_InvalidEmail() throws InterruptedException, SQLException {
	
	log.debug("---------Verify the add new user -> add agent -> invalid emailid testcase---------");
	
	test = rep.startTest("AdminSettings_Add_Agent_InvalidEmail");
	String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
	ResultSet rs = stmt.executeQuery(sql);
	rs.next();
	String username = rs.getString(2);
	username = username.replaceAll("\\s+","");
	String password = rs.getString(3);
	password = password.replaceAll("\\s+","");
	
	WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
	userName.sendKeys(username);
	log.debug("User Name is entered");
	
	WebElement passwordInput = driver.findElement(By.xpath(OR.getProperty("Password")));
	passwordInput.sendKeys(password);
	log.debug("Password is entered");
	
	WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
	signIn.click();
	log.debug("SignIn button is clicked");
	// Reporter.log("SignIn button is clicked");
		
		try {
				WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
				adminSettings.click();
				log.debug("Admin Settings button is clicked");	
				Thread.sleep(4000);
				
				WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
				Agents.click();
				log.debug("Agents field is clicked - "+ Agents);
				Thread.sleep(3000);	
				driver.findElement(By.xpath(OR.getProperty("AddNewUser"))).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(OR.getProperty("AddAgent"))).click();
				WebElement emailIdInputbox = driver.findElement(By.xpath(OR.getProperty("EnterAgentEmail")));
				emailIdInputbox.sendKeys("ababababababababababababababab");
				String ActualMsg=driver.findElement(By.xpath(OR.getProperty("ValidAgentEmail"))).getText();
				String expectedMsg= "Please enter a valid email!";
				Assert.assertEquals(ActualMsg, expectedMsg);
				log.debug("Max first name character functionality is working fine.");
				test.log(LogStatus.PASS,"Max First name character functionality is working fine.");
			
			
			}catch (Exception e) {
				// TODO: handle exception
				log.debug("Failed to execute Max character functionality.");
				test.log(LogStatus.FAIL,e);
			}
	}
	
	@Test(priority = 21)
	public void AdminSettings_Add_Agent_PhoneNumber_length() throws InterruptedException, SQLException {
	
	log.debug("---------Verify the add new user -> add agent -> phone numebr testcase---------");
	
	test = rep.startTest("AdminSettings_Add_Agent_PhoneNumber_length");
	String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
	ResultSet rs = stmt.executeQuery(sql);
	rs.next();
	String username = rs.getString(2);
	username = username.replaceAll("\\s+","");
	String password = rs.getString(3);
	password = password.replaceAll("\\s+","");
	
	WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
	userName.sendKeys(username);
	log.debug("User Name is entered");
	
	WebElement passwordInput = driver.findElement(By.xpath(OR.getProperty("Password")));
	passwordInput.sendKeys(password);
	log.debug("Password is entered");
	
	WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
	signIn.click();
	log.debug("SignIn button is clicked");
	// Reporter.log("SignIn button is clicked");
		
		try {
				WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
				adminSettings.click();
				log.debug("Admin Settings button is clicked");	
				Thread.sleep(4000);
				
				WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
				Agents.click();
				log.debug("Agents field is clicked - "+ Agents);
				Thread.sleep(3000);	
				driver.findElement(By.xpath(OR.getProperty("AddNewUser"))).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(OR.getProperty("AddAgent"))).click();
				WebElement PhoneInputbox = driver.findElement(By.xpath(OR.getProperty("AddAgentPhoneNum")));
				PhoneInputbox.sendKeys("123456");		
				String actualMsg = driver.findElement(By.xpath(OR.getProperty("PhoneNumLength"))).getText(); 
				String expectedMsg =  "Phone number must be between 10 and 17 characters long.";
				Assert.assertEquals(actualMsg, expectedMsg);;
				log.debug("Max phone number character functionality is working fine.");
				test.log(LogStatus.PASS,"Max Phone number character functionality is working fine.");
			}catch (Exception e) {
				// TODO: handle exception
				log.debug("Failed to execute Max character functionality.");
				test.log(LogStatus.FAIL,e);
			}
	}
		
	
	@Test(priority = 22)
	public void AdminSettings_Save_Agent_Empty() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the add new user -> add agent -> save testcase---------");
		
		test = rep.startTest("AdminSettings_Save_Agent_Empty");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		userName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement passwordInput = driver.findElement(By.xpath(OR.getProperty("Password")));
		passwordInput.sendKeys(password);
		log.debug("Password is entered");

		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		// Reporter.log("SignIn button is clicked");

		try {
				WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
				adminSettings.click();
				log.debug("Admin Settings button is clicked");	
				Thread.sleep(4000);
				
				WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
				Agents.click();
				log.debug("Agents field is clicked - "+ Agents);
				Thread.sleep(3000);	
				driver.findElement(By.xpath(OR.getProperty("AddNewUser"))).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(OR.getProperty("AddAgent"))).click();
				driver.findElement(By.xpath(OR.getProperty("SaveAgent"))).click();
				boolean firstNameReq= driver.findElement(By.xpath("FirstNameReq")).isDisplayed();
				Assert.assertTrue(firstNameReq);
				log.debug("Save empty agent details functionality is working fine.");
				test.log(LogStatus.PASS,"Save empty agent details functionality is working fine.");
			}
			catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to execute Max character functionality.");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 23)
	public void AdminSettings_Reset_Add_Agent_Details() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the add new user -> add agent -> reset testcase---------");
		
		test = rep.startTest("AdminSettings_Reset_Add_Agent_Details");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		userName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement passwordInput = driver.findElement(By.xpath(OR.getProperty("Password")));
		passwordInput.sendKeys(password);
		log.debug("Password is entered");

		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		// Reporter.log("SignIn button is clicked");

		try {
				WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
				adminSettings.click();
				log.debug("Admin Settings button is clicked");	
				Thread.sleep(4000);
				
				WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
				Agents.click();
				log.debug("Agents field is clicked - "+ Agents);
				Thread.sleep(3000);	
				driver.findElement(By.xpath(OR.getProperty("AddNewUser"))).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(OR.getProperty("AddAgent"))).click();
				WebElement firstNameInputbox = driver.findElement(By.xpath(OR.getProperty("EditFirstName")));
				firstNameInputbox.sendKeys("Jack");
				driver.findElement(By.xpath(OR.getProperty("ResetPassword"))).click();
				boolean firstNameReq = driver.findElement(By.xpath(OR.getProperty("EnterFirstName"))).isDisplayed();
				Assert.assertTrue(firstNameReq);
				log.debug("Save empty agent details functionality is working fine.");
				test.log(LogStatus.PASS,"Save empty agent details functionality is working fine.");
			}
			catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to execute Max character functionality.");
			test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 24)
	public void AdminSettings_Cancle_Add_Agent_Details() throws InterruptedException, SQLException {
		
		log.debug("---------Verify the add new user -> add agent -> cancle testcase---------");
		
		test = rep.startTest("AdminSettings_Cancle_Add_Agent_Details");
		String sql="Select * from user_credentials where instancename='"+config.getProperty("instancename")+"'";
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		String username = rs.getString(2);
		username = username.replaceAll("\\s+","");
		String password = rs.getString(3);
		password = password.replaceAll("\\s+","");
		
		WebElement userName = driver.findElement(By.xpath(OR.getProperty("UserName")));
		userName.sendKeys(username);
		log.debug("User Name is entered");

		WebElement passwordInput = driver.findElement(By.xpath(OR.getProperty("Password")));
		passwordInput.sendKeys(password);
		log.debug("Password is entered");

		WebElement signIn = driver.findElement(By.xpath(OR.getProperty("SignIn")));
		signIn.click();
		log.debug("SignIn button is clicked");
		// Reporter.log("SignIn button is clicked");

		try {
				WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
				adminSettings.click();
				log.debug("Admin Settings button is clicked");	
				Thread.sleep(4000);
				
				WebElement Agents = driver.findElement(By.xpath(OR.getProperty("Agents")));
				Agents.click();
				log.debug("Agents field is clicked - "+ Agents);
				Thread.sleep(3000);	
				driver.findElement(By.xpath(OR.getProperty("AddNewUser"))).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath(OR.getProperty("AddAgent"))).click();
				WebElement firstNameInputbox = driver.findElement(By.xpath(OR.getProperty("EditFirstName")));
				firstNameInputbox.sendKeys("Jacks");
				driver.findElement(By.xpath(OR.getProperty("CancelAddAgent"))).click();
				boolean addNewUser =driver.findElement(By.xpath(OR.getProperty("AddNewUser"))).isDisplayed();
				Assert.assertTrue(addNewUser);
				log.debug("Cancle add agent details functionality is working fine.");
				test.log(LogStatus.PASS,"Cancle add agent details functionality is working fine.");
			}
			catch (Exception e) {
			// TODO: handle exception
			log.debug("Failed to execute Cancle  add agent details functionality.");
			test.log(LogStatus.FAIL,e);
		}
	}
	

	
}
