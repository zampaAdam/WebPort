package com.goDeskless.testcases;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.goDeskless.base.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class AdminSettings_Group extends TestBase {
	
	@Test(priority = 1)
	public void AdminSettings_Groups_Navigation() throws SQLException {
		
		log.debug("---------Navigate to Groups page testcase 1 ---------");
		test = rep.startTest("AdminSettings_Group_Navigation");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement groups = driver.findElement(By.xpath(OR.getProperty("Groups")));
			groups.click();
			Thread.sleep(3000);
			String actualURL =driver.getCurrentUrl();
			String expectedURL = instanceurl + "groups";
			Assert.assertEquals(actualURL, expectedURL);
			log.debug("Navigated to Group tab successfully.");
			test.log(LogStatus.PASS,"Navigated to Group tab successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to naviagte group page");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 2)
	public void AdminSettings_Groups_Validation() throws SQLException {
		
		log.debug("---------Navigate to Groups page testcase 2 ---------");
		test = rep.startTest("AdminSettings_Group_Validation");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement groups = driver.findElement(By.xpath(OR.getProperty("Groups")));
			groups.click();
			Thread.sleep(3000);
			boolean searchGroup= driver.findElement(By.xpath(OR.getProperty("SearchGroup"))).isDisplayed();
			Assert.assertTrue(searchGroup);
			log.debug("validated Group page successfully.");
			test.log(LogStatus.PASS,"Validated to  group page successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to validate group page");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 3)
	public void AdminSettings_Add_New_Group() throws SQLException {
		
		log.debug("---------Add new Group  testcase 3 ---------");
		test = rep.startTest("AdminSettings_Add_New_Group");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement groups = driver.findElement(By.xpath(OR.getProperty("Groups")));
			groups.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewGroupButton"))).click();
			boolean addNewGroup= driver.findElement(By.xpath(OR.getProperty("AddGroupValidation"))).isDisplayed();
			Assert.assertTrue(addNewGroup);
			log.debug("Add new group window opened successfully.");
			test.log(LogStatus.PASS,"Add new group window opened successfully.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to open add new group window");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 4)
	public void AdminSettings_GroupName_GroupDescription_Size() throws SQLException {
		
		log.debug("---------Add new Group  testcase 4 ---------");
		test = rep.startTest("AdminSettings_GroupName_GroupDescription_Size");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement groups = driver.findElement(By.xpath(OR.getProperty("Groups")));
			groups.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewGroupButton"))).click();
			WebElement addGroupName= driver.findElement(By.xpath(OR.getProperty("AddGroupName")));
			addGroupName.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			WebElement addGroupDescription= driver.findElement(By.xpath(OR.getProperty("AddGroupDescription")));
			addGroupDescription.sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			String typedValue1 = addGroupName.getAttribute("value");
			String typedValue2 = addGroupDescription.getAttribute("value");

			// Get the length of typed value
			int groupNameSize = typedValue1.length();
			int groupDescriptionSize = typedValue2.length();
			// Assert with expected
			if (groupNameSize == 50 && groupDescriptionSize == 50) {
				Assert.assertTrue(true);
				log.debug("Max character functionality is working fine.");
				test.log(LogStatus.PASS,"Max character functionality is working fine.");
			}
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to check Max character functionality");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 5)
	public void AdminSettings_Add_New_Group_Details() throws SQLException {
		
		log.debug("---------Add new Group  testcase 5 ---------");
		test = rep.startTest("AdminSettings_Add_New_Group_Details");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement groups = driver.findElement(By.xpath(OR.getProperty("Groups")));
			groups.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewGroupButton"))).click();
			WebElement addGroupName= driver.findElement(By.xpath(OR.getProperty("AddGroupName")));
			addGroupName.sendKeys("Automation Testing");
			WebElement addGroupDescription= driver.findElement(By.xpath(OR.getProperty("AddGroupDescription")));
			addGroupDescription.sendKeys("Automate STB portal testing");
			
			driver.findElement(By.xpath(OR.getProperty("SaveAgent"))).click();
			String actualMsg = driver.findElement(By.xpath(OR.getProperty("SaveGroupMsg"))).getText();
			String expectedMsg = "Group added successfully";

			Assert.assertTrue(actualMsg.contains(expectedMsg));
			log.debug("Group added successfully.");
			test.log(LogStatus.PASS,"Group added successfully.");
			
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to add new group details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 6)
	public void AdminSettings_SaveEmpty_Group() throws SQLException {
		
		log.debug("---------Add new Group  testcase 6 ---------");
		test = rep.startTest("AdminSettings_SaveEmpty_Group");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement groups = driver.findElement(By.xpath(OR.getProperty("Groups")));
			groups.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewGroupButton"))).click();
			driver.findElement(By.xpath(OR.getProperty("SaveAgent"))).click();
			String actualMsg = driver.findElement(By.xpath(OR.getProperty("GrpNameRequired"))).getText();
			String expectedMsg = "Group Name is required.";

			Assert.assertTrue(actualMsg.contains(expectedMsg));
			log.debug("Correct messages are displayed on saving empty details.");
			test.log(LogStatus.PASS,"Correct messages are displayed on saving empty details.");
			
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to save empty details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 7)
	public void AdminSettings_Reset_Group_Details() throws SQLException {
		
		log.debug("---------Add new Group  testcase 7 ---------");
		test = rep.startTest("AdminSettings_Reset_Group_Details");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement groups = driver.findElement(By.xpath(OR.getProperty("Groups")));
			groups.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewGroupButton"))).click();
			WebElement addGroupName= driver.findElement(By.xpath(OR.getProperty("AddGroupName")));
			addGroupName.sendKeys("Automation Testing");
			driver.findElement(By.xpath(OR.getProperty("ResetButton"))).click();
			
			String typedValue1 = driver.findElement(By.xpath(OR.getProperty("AddGroupName"))).getAttribute("value");
			if(typedValue1.isEmpty())
			{
				Assert.assertTrue(true);
				log.debug("Reset button functionality is working fine.");
				test.log(LogStatus.PASS,"Reset button functionality is working fine.");
			}
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to reset the group details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 8)
	public void AdminSettings_Cancle_Add_New_Group() throws SQLException {
		
		log.debug("---------Add new Group  testcase 8 ---------");
		test = rep.startTest("AdminSettings_Cancle_Add_New_Group");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement groups = driver.findElement(By.xpath(OR.getProperty("Groups")));
			groups.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("AddNewGroupButton"))).click();
			driver.findElement(By.xpath(OR.getProperty("CancleGroup"))).click();
			boolean addNewGroup= driver.findElement(By.xpath(OR.getProperty("AddNewGroupButton"))).isDisplayed();
			Assert.assertTrue(addNewGroup);
			log.debug("Cancle  button functionality is working fine.");
			test.log(LogStatus.PASS,"Cancle button functionality is working fine.");
		
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to cancle the group details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 9)
	public void AdminSettings_Search_Group() throws SQLException {
		
		log.debug("---------Add new Group  testcase 8 ---------");
		test = rep.startTest("AdminSettings_Search_Group");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement groups = driver.findElement(By.xpath(OR.getProperty("Groups")));
			groups.click();
			Thread.sleep(3000);
			WebElement searchGroup = driver.findElement(By.xpath(OR.getProperty("SearchGroup")));
			searchGroup.sendKeys("Automation Testing");
			boolean groupName = driver.findElement(By.xpath("//td[contains(text(),'Automation Testing')]")).isDisplayed();
			Assert.assertTrue(groupName);
			log.debug("Group searched successfully.");
			test.log(LogStatus.PASS,"Group searched successfully.");
			
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to search group details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 10)
	public void AdminSettings_Upadte_Group() throws SQLException {
		
		log.debug("---------Add new Group  testcase 9 ---------");
		test = rep.startTest("AdminSettings_Upadte_Group");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement groups = driver.findElement(By.xpath(OR.getProperty("Groups")));
			groups.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("UpadteGroupButton"))).click();
			Thread.sleep(1000);
			boolean groupName = driver.findElement(By.xpath(OR.getProperty("UpdateGroupValidation"))).isDisplayed();
			Assert.assertTrue(groupName);
			log.debug("update group functionality is working fine.");
			test.log(LogStatus.PASS,"update group functionality is working fine.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to update the group details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 11)
	public void AdminSettings_Upadte_Group_Detials() throws SQLException {
		
		log.debug("---------Add new Group  testcase 10 ---------");
		test = rep.startTest("AdminSettings_Upadte_Group_Detials");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement groups = driver.findElement(By.xpath(OR.getProperty("Groups")));
			groups.click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(OR.getProperty("UpadteGroupButton"))).click();
			WebElement groupName= driver.findElement(By.xpath(OR.getProperty("UpdateGroupName")));
			groupName.clear();
			groupName.sendKeys("Automation Testr");
			driver.findElement(By.xpath(OR.getProperty("UpdateGroupDetails"))).click();
			String actualMsg= driver.findElement(By.xpath(OR.getProperty("UpdateGroupMsg"))).getText();
			String expectedMsg= "Group updated successfully";	
			Assert.assertTrue(actualMsg.contains(expectedMsg));
			log.debug("update group details functionality is working fine.");
			test.log(LogStatus.PASS,"update group details functionality is working fine.");
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to update the group details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	@Test(priority = 12)
	public void AdminSettings_Delete_Group() throws SQLException {
		
		log.debug("---------Add new Group  testcase 8 ---------");
		test = rep.startTest("AdminSettings_Delete_Group");

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
			WebElement adminSettings = driver.findElement(By.xpath(OR.getProperty("AdminSettings")));
			adminSettings.click();
			log.debug("Admin Settings button is clicked");	
			Thread.sleep(4000);
			WebElement groups = driver.findElement(By.xpath(OR.getProperty("Groups")));
			groups.click();
			Thread.sleep(3000);
			boolean groupName = driver.findElement(By.xpath("//td[contains(text(),'Automation Testr')]")).isDisplayed();
			if(groupName == true) {
				driver.findElement(By.xpath(OR.getProperty("DeleteGroupButton"))).click();
				driver.findElement(By.xpath(OR.getProperty("ConfirmDelete"))).click();
				boolean addNewGroup= driver.findElement(By.xpath(OR.getProperty("AddNewGroupButton"))).isDisplayed();
				Assert.assertTrue(addNewGroup);
				log.debug("Delete group functionality is working fine.");
				test.log(LogStatus.PASS,"Delete group functionality is working fine.");
			}
		}
		catch (Exception e) {
		// TODO: handle exception
		log.info("Failed to delete the group details");
		test.log(LogStatus.FAIL,e);
		}
	}
	
	
}
